package ClasesAnidadas;

import java.util.ArrayList;
import java.util.List;

public class Contact {

    private final String name;

    private ContactInfo phone;
    private final List<ContactInfo> emails = new ArrayList<>();
    private final List<ContactInfo> socials = new ArrayList<>();

    public Contact(String name) {
        this.name = name;
    }

      /* =========================
       Nested ContactInfo classes
       ========================= */

    // 1️⃣ NameContactInfo
    private class NameContactInfo implements ContactInfo {

        @Override
        public String getTitle() {
            return "Name";
        }

        @Override
        public String getValue() {
            return name; // usa el campo del Contact
        }
    }

    // 2️⃣ Email
    public static class Email implements ContactInfo {

        private final String value;

        public Email(String value) {
            this.value = value;
        }

        @Override
        public String getTitle() {
            return "Email";
        }

        @Override
        public String getValue() {
            return value;
        }
    }

    // 3️⃣ Social
    public static class Social implements ContactInfo {

        private final String title;
        private final String value;

        public Social(String title, String value) {
            this.title = title;
            this.value = value;
        }

        @Override
        public String getTitle() {
            return title;
        }

        @Override
        public String getValue() {
            return value;
        }
    }

    public ContactInfo getName() {
        return new NameContactInfo();
    }

    public void setPhone(String phoneNumber) {
        // Implementación anónima
        this.phone = new ContactInfo() {
            @Override
            public String getTitle() {
                return "Phone";
            }

            @Override
            public String getValue() {
                return phoneNumber;
            }
        };
    }

    public ContactInfo getPhone() {
        return phone;
    }

    public ContactInfo addEmail(String localPart, String domain) {
        if (emails.size() >= 3) {
            return null;
        }

        ContactInfo email = new Email(localPart + "@" + domain);
        emails.add(email);
        return email;
    }

    public ContactInfo addEpamEmail(String firstname, String lastname) {
        if (emails.size() >= 3) {
            return null;
        }

        ContactInfo email = new Email(firstname + "_" + lastname + "@epam.com") {
            @Override
            public String getTitle() {
                return "Epam Email";
            }
        };

        emails.add(email);
        return email;
    }

    public ContactInfo addPhoneNumber(int code, String number) {
        if (phone != null) {
            return null;
        }

        phone = new ContactInfo() {
            @Override
            public String getTitle() {
                return "Tel";
            }

            @Override
            public String getValue() {
                return "+" + code + " " + number;
            }
        };

        return phone;
    }
    public void addSocial(String title, String value) {
        if (socials.size() < 5) {
            socials.add(new Social(title, value));
        }
    }

    public List<ContactInfo> getSocials() {
        return socials;
    }

    public ContactInfo addSocialMedia(String title, String id) {
        if (socials.size() >= 5) {
            return null;
        }

        ContactInfo social = new Social(title, id);
        socials.add(social);
        return social;
    }

    public ContactInfo addTwitter(String twitterId) {
        return addSocialMedia("Twitter", twitterId);
    }

    public ContactInfo addInstagram(String instagramId) {
        return addSocialMedia("Instagram", instagramId);
    }

    public void addEmail(String email) {
        if (emails.size() < 3) {
            emails.add(new Email(email));
        }
    }

    public List<ContactInfo> getEmails() {
        return emails;
    }

}
