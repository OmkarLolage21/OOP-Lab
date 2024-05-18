package FinalOOPLab;

abstract class ShapesS{
    abstract void display();
    abstract void info();
}
class Triangle extends ShapesS{
    @Override
    void display() {
        System.out.println("This is a triangle");
    }

    @Override
    void info() {
        System.out.println("Triangle has three sides");
    }
}
class RectangleS extends ShapesS{
    @Override
    void display() {
        System.out.println("This is a rectangle");
    }

    @Override
    void info() {
        System.out.println("Rectangle has 4 sides");
    }
}
public class AbstractShape {
    public static void main(String[] args) {
        RectangleS rect = new RectangleS();
        rect.display();
        rect.info();
        Triangle tri = new Triangle();
        tri.display();
        tri.info();
    }
}