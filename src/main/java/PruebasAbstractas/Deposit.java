package PruebasAbstractas;

import java.math.BigDecimal;

public abstract class Deposit {

    private final BigDecimal amount;
    private final int period;

    protected Deposit(BigDecimal amount, int period) {
        if(period < 0 || amount.compareTo(new BigDecimal("0")) < 0){
            throw new IllegalArgumentException("the sides must be greater than 0");
        }
        this.period = period;
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public int getPeriod() {
        return period;
    }

    public abstract BigDecimal income();
}
