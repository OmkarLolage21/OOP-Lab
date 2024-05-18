package FinalOOPLab;

interface Drawable {
    void draw();
}

interface Resizable {
    void resize(double factor);
}

class Circles implements Drawable, Resizable {
    private double radius;

    public Circles(double radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Circle with radius: " + radius);
    }

    @Override
    public void resize(double factor) {
        radius *= factor;
        System.out.println("Resized Circle to radius: " + radius);
    }
}

class Rectangles implements Drawable {
    private double width;
    private double height;

    public Rectangles(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle with width: " + width + " and height: " + height);
    }
}

public class ShapeHierarchy {
    public static void main(String[] args) {
        Circles circle = new Circles(5.0);
        circle.draw();
        circle.resize(2.0);
        circle.draw();

        Rectangles rectangle = new Rectangles(4.0, 7.0);
        rectangle.draw();
    }
}