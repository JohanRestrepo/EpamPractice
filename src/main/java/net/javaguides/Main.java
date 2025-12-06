package net.javaguides;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
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
        int[][] matrix = { { 2, 4, 3, 3 }, { 5, 7, 8, 5 }, { 2, 4, 3, 3 }, { 5, 7, 8, 5 } };
        transformMatrix(matrix);
        System.out.println(Arrays.deepToString(matrix));

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



}