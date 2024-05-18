package FinalOOPLab;

public class SimpleCalculator {
    private static final double PI = 3.14;

    static {
        System.out.println("Welcome to Simple Calculator!");
    }

    {
        System.out.println("New calculator instance");
    }

    public SimpleCalculator() {
        // Default constructor
    }

    public double add(double num1, double num2) {
        return num1 + num2;
    }

    public double subtract(double num1, double num2) {
        return num1 - num2;
    }

    public double multiply(double num1, double num2) {
        return num1 * num2;
    }

    public double divide(double num1, double num2) {
        if (num2 == 0) {
            System.out.println("Error: Division by zero");
            return Double.NaN; // Return NaN (Not a Number) for division by zero
        }
        return num1 / num2;
    }

    public static void main(String[] args) {
        SimpleCalculator calculator = new SimpleCalculator();

        // Perform some calculations
        double result1 = calculator.add(10, 5);
        System.out.println("Addition: " + result1);

        double result2 = calculator.subtract(10, 5);
        System.out.println("Subtraction: " + result2);

        double result3 = calculator.multiply(10, 5);
        System.out.println("Multiplication: " + result3);

        double result4 = calculator.divide(10, 5);
        System.out.println("Division: " + result4);

        double result5 = calculator.divide(10, 0); // Division by zero
        System.out.println("Division by zero result: " + result5);

        SimpleCalculator calculator2 = new SimpleCalculator();
    }
}

