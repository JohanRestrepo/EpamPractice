package net.javaguides;

import java.math.BigDecimal;

public class SalesPerson extends Employee {

    private int percent;

    public SalesPerson(String name, BigDecimal salary, int percent) {
        super(name, salary);
        if(percent < 0){
            throw new IllegalArgumentException("please enter correct percent");
        }
        this.percent = percent;
    }

    @Override
    public void setBonus(BigDecimal bonus){
        if(percent >= 200){
            super.setBonus(bonus.multiply(new BigDecimal("3")));
        }else if(percent >= 100){
            super.setBonus(bonus.multiply(new BigDecimal("2")));
        }else{
            super.setBonus(bonus);
        }
    }


}
