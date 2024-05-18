package FinalOOPLab;

public class MasterShape {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        circle.calculateArea();
        circle.calculatePerimeter();
        circle.displayDetails();
        System.out.println();

        Rectangle rectangle = new Rectangle(4, 7);
        rectangle.calculateArea();
        rectangle.calculatePerimeter();
        rectangle.displayDetails();
        System.out.println();

        Square square = new Square(3);
        square.calculateArea();
        square.calculatePerimeter();
        square.displayDetails();
    }
}

abstract class Shape {
    abstract void calculateArea();
    abstract void calculatePerimeter();
    abstract void displayDetails();
}

class Circle extends Shape {
    double area;
    double perimeter;
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    void calculateArea() {
        area = radius * radius * Math.PI;
    }

    @Override
    void calculatePerimeter() {
        perimeter = 2 * radius * Math.PI;
    }

    @Override
    void displayDetails() {
        System.out.println("Circle:");
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + area);
        System.out.println("Perimeter: " + perimeter);
    }
}

class Rectangle extends Shape {
    double area;
    double perimeter;
    double length;
    double breadth;

    public Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    void calculateArea() {
        area = length * breadth;
    }

    @Override
    void calculatePerimeter() {
        perimeter = 2 * (length + breadth);
    }

    @Override
    void displayDetails() {
        System.out.println("Rectangle:");
        System.out.println("Length: " + length);
        System.out.println("Breadth: " + breadth);
        System.out.println("Area: " + area);
        System.out.println("Perimeter: " + perimeter);
    }
}

class Square extends Shape {
    double area;
    double perimeter;
    double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    void calculateArea() {
        area = side * side;
    }

    @Override
    void calculatePerimeter() {
        perimeter = 4 * side;
    }

    @Override
    void displayDetails() {
        System.out.println("Square:");
        System.out.println("Side: " + side);
        System.out.println("Area: " + area);
        System.out.println("Perimeter: " + perimeter);
    }
}