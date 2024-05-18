package FinalOOPLab;

public class CalculateAreaOverloading {
    public static void main(String[] args) {
        Shapes s = new Shapes();
        s.calculateArea(5);
        s.calculateArea(1.0);
        s.calculateArea(45, 5);
    }
}

class Shapes {
    void calculateArea(int side) {
        System.out.println("Area of Square is " + side * side);
    }

    void calculateArea(double length, double breadth) {
        System.out.println("Area of Rectangle is " + length * breadth);
    }

    void calculateArea(double radius) {
        System.out.println("Area of Circle is " + 3.1428 * radius * radius);
    }
}
