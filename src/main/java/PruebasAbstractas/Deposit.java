package PruebasAbstractas;

import java.math.BigDecimal;

public abstract class Deposit implements Comparable<Deposit> {

    private final BigDecimal amount;
    private final int period;

    protected Deposit(BigDecimal depositAmount, int depositPeriod) {
        if(depositPeriod <= 0 || depositAmount.compareTo(new BigDecimal("0")) <= 0){
            throw new IllegalArgumentException("the sides must be greater than 0");
        }
        this.period = depositPeriod;
        this.amount = depositAmount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public int getPeriod() {
        return period;
    }

    public abstract BigDecimal income();

    @Override
    public int compareTo(Deposit other) {
        return this.income().add(this.amount).compareTo(other.income().add(other.amount));
    }
}
