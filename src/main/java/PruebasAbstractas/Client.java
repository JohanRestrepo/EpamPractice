package PruebasAbstractas;

import java.math.BigDecimal;

public class Client {

    private Deposit [] depositos;

    public Client(){
        depositos = new Deposit[10];
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
        if(number < 1 || number > 10){
            throw new IllegalArgumentException("the sides must be greater than 0");
        } else if (depositos[number-1] != null) {
            return depositos[number-1].income();
        } else{
            return new BigDecimal("0.00");
        }
    }
}
