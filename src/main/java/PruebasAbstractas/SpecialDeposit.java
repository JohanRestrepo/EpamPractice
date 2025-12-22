package PruebasAbstractas;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SpecialDeposit extends Deposit implements Prolongable{

    private static final BigDecimal INTERESTGROW = new BigDecimal("0.01");

    public SpecialDeposit(BigDecimal amount,int period){
        super(amount, period);
    }

    public BigDecimal getInterestGrow() {
        return INTERESTGROW;
    }

    @Override
    public BigDecimal income() {
        BigDecimal aux = getAmount();
        BigDecimal interest = getInterestGrow();
        BigDecimal aux1;
        for (int i = 0; i < getPeriod(); i++) {
            aux1 = aux.multiply(interest);
            aux = aux.add(aux1);
            interest = interest.add(getInterestGrow());
        }
        aux = aux.subtract(getAmount());
        return aux.setScale(2, RoundingMode.DOWN);
    }

    @Override
    public boolean canToProlong() {
        return getAmount().compareTo(new BigDecimal("1000")) > 0;
    }
}
