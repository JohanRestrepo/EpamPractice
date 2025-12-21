package PruebasAbstractas;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LongDeposit extends Deposit{

    private static final BigDecimal INTEREST = new BigDecimal("0.15");

    public LongDeposit(BigDecimal amount,int period) {
        super(amount, period);
    }

    public BigDecimal getInterest() {
        return INTEREST;
    }

    @Override
    public BigDecimal income() {
        BigDecimal aux = this.getAmount();
        BigDecimal aux1;
        if (getPeriod() > 6) {
            for (int i = 0; i < getPeriod()-6; i++) {
                aux1 = aux.multiply(getInterest());
                aux = aux.add(aux1);
            }
        }
        aux = aux.subtract(getAmount());
        return aux.setScale(2, RoundingMode.DOWN);
    }



}
