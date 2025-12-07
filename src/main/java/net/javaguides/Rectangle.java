package net.javaguides;

import java.util.Objects;

public class Rectangle {

    private double sideA;
    private double sideB;

    public Rectangle(double sideA, double sideB){
        if(sideA <= 0 || sideB <= 0){
            throw new IllegalArgumentException("the sides must be greater than 0");
        }
        this.sideA = sideA;
        this.sideB = sideB;
    }

    public Rectangle(double sideC){
        if(sideC <= 0){
            throw new IllegalArgumentException("the sides must be greater than 0");
        }
        this.sideA = sideC;
        this.sideB = sideC;
    }

    public Rectangle(){
        this.sideA = 4;
        this.sideB = 3;
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double area(){
        return sideA * sideB;
    }

    public double perimeter(){
        return (2 * sideA) + (2 *  sideB);
    }

    public boolean isSquare(){
        return sideA == sideB;
    }

    public void replaceSides(){
        double aux = sideA;
        sideA = sideB;
        sideB = aux;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(sideA, rectangle.sideA) == 0 && Double.compare(sideB, rectangle.sideB) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sideA, sideB);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "sideA=" + sideA +
                ", sideB=" + sideB +
                '}';
    }
}
