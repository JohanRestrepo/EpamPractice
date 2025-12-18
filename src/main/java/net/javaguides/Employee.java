package net.javaguides;

import java.math.BigDecimal;

public class Employee {

    private String name;
    private BigDecimal salary;
    private BigDecimal bonus;

    public Employee(String name, BigDecimal salary) {
        if(name == null || salary.compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException("please enter correct information");
        }
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setBonus(BigDecimal bonus) {
        if(bonus.compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException("please enter correct bonus");
        }
        this.bonus = bonus;
    }

    public BigDecimal toPay(){
        return salary.add(bonus);
    }
}
