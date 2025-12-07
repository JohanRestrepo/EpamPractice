package net.javaguides;
import net.javaguides.Rectangle;
public class ArrayRectangles {

    private Rectangle[] rectangleArray;

    public ArrayRectangles(int size) {
        if (size < 1){
            throw new IllegalArgumentException("the size must be greater than zero");
        }
        rectangleArray = new Rectangle[size];
    }

    public ArrayRectangles(Rectangle... rectangles) {
        if(rectangles == null || rectangles.length == 0) {
            throw new IllegalArgumentException("you must send a correct array of rectangles");
        }
        rectangleArray = rectangles;
    }

    public boolean addRectangle(Rectangle rectangle) {
        boolean flag = false;
        for (int i = 0; i < rectangleArray.length-1; i++) {
            if(rectangleArray[i] == null){
                rectangleArray[i] = rectangle;
                flag = true;
                break;
            }
        }
        return flag;
    }

    public int size() {
        int count = 0;
        for(int i = 0; i < rectangleArray.length; i++) {
            if(rectangleArray[i] != null){
                count++;
            }else{
                break;
            }
        }
        return count;
    }

    public int indexMaxArea() {
        int index = 0;
        double maxArea = 0;
        double aux;
        for (int i = 0; i < rectangleArray.length; i++) {
            aux = rectangleArray[i].area();
            if(aux >= maxArea){
                index = i;
                maxArea = aux;
            }
        }
        return index;
    }

    public int indexMinPerimeter() {
        int index = 0;
        double minPerimeter = rectangleArray[0].perimeter();
        double aux;
        for (int i = 0; i < rectangleArray.length; i++) {
            aux = rectangleArray[i].perimeter();
            if(aux <= minPerimeter){
                index = i;
                minPerimeter = aux;
            }
        }
        return index;
    }

    public int numberSquares() {
        int count = 0;
        for (int i = 0; i < rectangleArray.length; i++) {
            if(rectangleArray[i].isSquare()){
                count ++;
            }
        }
        return count;
    }


}
