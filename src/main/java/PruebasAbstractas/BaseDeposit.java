package PruebasAbstractas;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BaseDeposit extends Deposit{

    private static final BigDecimal INTEREST = new BigDecimal("0.05");

    public BaseDeposit(BigDecimal amount,int period){
        super(amount, period);
    }

    public BigDecimal getInterest() {
        return INTEREST;
    }

    @Override
    public BigDecimal income() {
        BigDecimal aux = getAmount();
        BigDecimal aux1;
        for (int i = 0; i < getPeriod(); i++) {
            aux1 = aux.multiply(getInterest());
            aux = aux.add(aux1);
        }
        aux = aux.subtract(getAmount());
        return aux.setScale(2, RoundingMode.DOWN);
    }

}
