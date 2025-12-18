package net.javaguides;

import java.math.BigDecimal;

public class Manager extends Employee{

    private int clientAmount;

    public Manager(String name, BigDecimal salary, int clientAmount) {
        super(name, salary);
        if(clientAmount < 0){
            throw new IllegalArgumentException("please enter correct percent");
        }
        this.clientAmount = clientAmount;
    }

    @Override
    public void setBonus(BigDecimal bonus){
        if(clientAmount >= 150){
            super.setBonus(bonus.add(new BigDecimal("1000")));
        }else if(clientAmount >= 100){
            super.setBonus(bonus.add(new BigDecimal("500")));
        }else{
            super.setBonus(bonus);
        }
    }
}
