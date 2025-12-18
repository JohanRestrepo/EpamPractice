package net.javaguides;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

public class Company {

    private ArrayList<Employee> listEmployees;

    public Company(Employee[] empleadosEntrada) {
        boolean todosSonEmpleados = Arrays.stream(empleadosEntrada)
                .allMatch(e -> e instanceof Employee);
        if(empleadosEntrada.getClass().isArray() && todosSonEmpleados){
            this.listEmployees = new ArrayList<>(Arrays.asList(empleadosEntrada));
        }else{
            throw new IllegalArgumentException("please enter correct percent");
        }
    }

    public void giveEverybodyBonus(BigDecimal companyBonus){
        for (Employee emp:listEmployees){
            emp.setBonus(companyBonus);
        }
    }

    public BigDecimal totalToPay(){
        BigDecimal aux = new BigDecimal("0");
        for (Employee emp:listEmployees){
            aux = aux.add(emp.toPay());
        }
        return aux;
    }

    public String nameMaxSalary(){
        BigDecimal aux = listEmployees.get(0).toPay();
        String name = listEmployees.get(0).getName();

        for (Employee emp:listEmployees){

            if(emp.toPay().compareTo(aux) > 0){
                aux = emp.toPay();
                name = emp.getName();
            }
        }

        return name;
    }
}
