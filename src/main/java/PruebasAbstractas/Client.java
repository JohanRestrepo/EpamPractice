package PruebasAbstractas;

import java.util.Arrays;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Client implements Iterable<Deposit>{

    private Deposit [] depositos;

    public Client(){
        depositos = new Deposit[10];
    }

    public Client(Deposit[] deposits){
        if(deposits == null || deposits.length>10){
            throw new IllegalArgumentException("please add a correct value for the client - johan");
        }
        depositos = new Deposit[10];
        System.arraycopy(deposits, 0, depositos, 0, deposits.length);
    }

    public boolean addDeposit(Deposit deposit){
        for (int i = 0; i < depositos.length; i++) {
            if(depositos[i] == null){
                depositos[i] = deposit;
                return true;
            }
        }
        return false;
    }

    public BigDecimal totalIncome(){
        BigDecimal aux = new BigDecimal("0");
        for (int i = 0; i < depositos.length; i++) {
            if(depositos[i] != null){
                aux = aux.add(depositos[i].income());
            }
        }
        return aux;
    }

    public BigDecimal maxIncome(){
        BigDecimal aux = new BigDecimal("0");
        if(depositos[0] != null){
            aux = depositos[0].income();
        }
        for (Deposit deposito : depositos) {
            if (deposito != null && aux.compareTo(deposito.income()) < 0) {
                aux = deposito.income();
            }
        }
        return aux;
    }

    public BigDecimal getIncomeByNumber(int number){
        if(number < 0 || number > 9){
            throw new IllegalArgumentException("the number must be between 1 and 10 - johan");
        } else if (depositos[number] != null) {
            return depositos[number].income();
        } else{
            return new BigDecimal("0.00");
        }
    }

    @Override
    public Iterator<Deposit> iterator() {
        return new DepositIterator(); // nueva instancia
    }

    public int countPossibleToProlongDeposit(){
        int conteoProlong = 0;
        for (int i = 0; i < depositos.length; i++) {
            if (depositos[i] instanceof SpecialDeposit aux) {
                if (aux.canToProlong()){
                    conteoProlong += 1;
                }
            }else if(depositos[i] instanceof LongDeposit aux1){
                if (aux1.canToProlong()){
                    conteoProlong += 1;
                }
            }
        }
        return conteoProlong;
    }

    public void sortDeposits(){
        Deposit aux;
        for (int i = 0; i < depositos.length; i++) {
            if(depositos[i]!= null){
                for (int j = i+1; j < depositos.length; j++) {
                    if(depositos[j]!= null){
                        if(depositos[i].compareTo(depositos[j]) < 0){
                            aux = depositos[i];
                            depositos[i] = depositos[j];
                            depositos[j] = aux;
                        }
                    }else{
                        break;
                    }
                }
            }else{
                break;
            }
        }
        /*for (Deposit deposit: depositos){
            if (deposit != null){
                System.out.println(deposit.getAmount() + "-" + deposit.getPeriod() + "-" + deposit.income());
            }
        }*/

    }

    // 🔹 Clase interna NO estática
    public class DepositIterator implements Iterator<Deposit> {

        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < depositos.length;
        }

        @Override
        public Deposit next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return depositos[index++];
        }

        @Override
        public void remove(){
            throw new UnsupportedOperationException();
        }


    }

}
