package net.javaguides;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
import net.javaguides.Rectangle;
import net.javaguides.ArrayRectangles;
import PruebasAbstractas.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public enum SortOrder {
        ASC,
        DESC;
    }

    public static void main(String[] args) {
        //reloj();
        //System.out.println(task1(4));
        //System.out.println(task1(-5));
        //System.out.println(task1(0));
        //System.out.println(task2(165));
        //System.out.println(task2(123));
        //System.out.println(sumOfFibonacciNumbers(-1));
        //int[] array = new int[] {10, 10, 10, 10, 10};
        //System.out.println("result = " + maximumDistance(array));
        //int[][] matrix = { { 2, 4, 3, 3 }, { 5, 7, 8, 5 }, { 2, 4, 3, 3 }, { 5, 7, 8, 5 } };
        //transformMatrix(matrix);
        //System.out.println(Arrays.deepToString(matrix));
        //int[] array = new int[] {15, 10, 3};
        //System.out.println(isSorted(array,SortOrder.DESC));
        //System.out.println(Arrays.toString(transform(array,SortOrder.DESC)));
        //int x = 0;
        //x = acumulacion(x);
        //x = acumulacion(x);
        //x = acumulacion(x);
        //x = acumulacion(x);
        //x = acumulacion(x);
        //System.out.println(x);
        //BigDecimal sueldo1 = new BigDecimal("1200");
        //BigDecimal sueldo2 = new BigDecimal("900.5");
        //BigDecimal sueldo3 = new BigDecimal("2000.54");
        //BigDecimal sueldo4 = new BigDecimal("1100");
        //SalesPerson employee1 = new SalesPerson("Jorge", sueldo1, 200);
        //SalesPerson employee2 = new SalesPerson("Emanuel", sueldo2, 200);
        //Manager employee3 = new Manager("Antonio", sueldo3, 100);
        //SalesPerson employee4 = new SalesPerson("jorge", sueldo4, 200);
        //employee3.setBonus(new BigDecimal("1000"));
        //System.out.println(employee3.toPay());
        //Employee [] employees = {employee1,employee2,employee3,employee4};
        //Company company = new Company(employees);
        //company.giveEverybodyBonus(new BigDecimal("100"));
        //System.out.println(company.totalToPay());
        //System.out.println(company.nameMaxSalary());
        BaseDeposit deposito1 = new BaseDeposit(new BigDecimal("1000"),2);
        SpecialDeposit deposito2 = new SpecialDeposit(new BigDecimal("1200"),3);
        LongDeposit deposito3 = new LongDeposit(new BigDecimal("1000"),30);
        BaseDeposit deposito4 = new BaseDeposit(new BigDecimal("1000"),1);
        SpecialDeposit deposito5 = new SpecialDeposit(new BigDecimal("1500"),2);
        Client client = new Client();
        client.addDeposit(deposito1);
        client.addDeposit(deposito2);
        client.addDeposit(deposito3);
        client.addDeposit(deposito4);
        client.addDeposit(deposito5);
        System.out.println(client.totalIncome());
        System.out.println(client.maxIncome());
        System.out.println(client.getIncomeByNumber(3));
        System.out.println(client.countPossibleToProlongDeposit());
        client.sortDeposits();

    }

    public static void reloj(){
        Scanner scanner = new Scanner(System.in);
        int seconds = scanner.nextInt();
        int horas = seconds / 3600;
        int desfase = horas / 24; // en caso de ser mas de 24 horas vemos cuantas veces entra, lo dejamos en int para eliminar extras
        horas = horas - (24 * desfase);
        int minutos = (seconds % 3600) / 60;
        int segundos = seconds % 60;
        System.out.println(String.format("%2d:%02d:%02d", horas, minutos, segundos));
    }

    public static int task1(int n) {

        if(n > 0){
            return n * n;
        }else if(n < 0){
            return n * (-1);
        }else{
            return 0;
        }
    }

    public static int task2(int n) {
        char[] digitos = String.valueOf(n).toCharArray();
        Character[] digitosChar = new Character[digitos.length];
        for (int i = 0; i < digitos.length; i++) {
            digitosChar[i] = digitos[i];
        }
        Arrays.sort(digitosChar, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder(digitosChar.length);
        for (char c : digitosChar) {
            sb.append(c);
        }
        String numeroOrdenado = sb.toString();
        return Integer.parseInt(numeroOrdenado);
    }

    public static int sumOfFibonacciNumbers(int n) {
        if (n < 0){
            throw new IllegalArgumentException("Value n should be positive");
        }
        int n1 = 1;
        int n2 = 0;
        int aux;
        int total = 0;
        while(n > 1){
            total += n1;
            aux = n1 + n2;
            n2 = n1;
            n1 = aux;
            n--;
        }
        return total;
    }

    public static int maximumDistance(int[] array) {
        int pos1 = 0;
        int pos2 = 0;
        int result = 0;
        if (array != null && array.length > 0){
            int [] array2 = Arrays.copyOf(array,array.length);//Creo una copia para poderlo organizar
            Arrays.sort(array2);
            int MaxValue = array2[array2.length - 1];//Al estar organizado el ultimo es el mayor

            for (int i = array.length-1; i > 0 ; i--) {
                if(array[i] == MaxValue){
                    pos1 = i;
                    break;
                }
            }
            for (int i = 0; i < array.length-1; i++) {
                if(array[i] == MaxValue){
                    pos2 = i;
                    break;
                }
            }
            result = pos1 - pos2;
        }
        return result;
    }

    public static void transformMatrix(int[][] matrix) {
        if (matrix != null && matrix.length > 0){
            for (int i = 0; i < matrix.length; i++) {
                System.out.println(Arrays.toString(matrix[i]));
                for (int j = 0; j < matrix[i].length; j++) {
                    System.out.println(matrix[i][j]);
                    if(j > i){
                        matrix[i][j] = 1;
                    }else if(j < i){
                        matrix[i][j] = 0;
                    }
                }
            }
        }
    }

    public static boolean isSorted(int[] array, SortOrder order) {
        boolean flag = false;
        if(array != null && array.length > 0){
            int [] array2 = Arrays.copyOf(array,array.length);
            if(order == SortOrder.ASC){
                Arrays.sort(array2);
                flag = Arrays.equals(array2,array);
            }else{
                Integer[] array1 = new Integer[array.length];
                for (int i = 0; i < array.length; i++) {
                    array1[i] = array[i];
                }
                Integer[] array22 = new Integer[array2.length];
                for (int i = 0; i < array2.length; i++) {
                    array22[i] = array2[i];
                }
                Arrays.sort(array22, Collections.reverseOrder());
                flag = Arrays.equals(array1,array22);
            }
        }else{
            throw new IllegalArgumentException("The array must have valid values");
        }
        return flag;
    }

    public static int[] transform(int[] array, SortOrder order) {
        if(isSorted(array,order)){
            for (int i = 0; i < array.length; i++) {
                array[i] += i;
            }
        }
        return array;
    }

    public static int acumulacion(int x){
        for (int i = 0; i < 10000000; i++) {
            x = x + 1;
        }
        return x;
    }







}