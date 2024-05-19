package FinalOOPLab;

import java.util.Scanner;

class AdditionThread extends Thread {
    private double num1, num2;

    public AdditionThread(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public void run() {
        System.out.println("Addition Result: " + (num1 + num2));
    }
}

class SubtractionThread extends Thread {
    private double num1, num2;

    public SubtractionThread(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public void run() {
        System.out.println("Subtraction Result: " + (num1 - num2));
    }
}

class MultiplicationThread extends Thread {
    private double num1, num2;

    public MultiplicationThread(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public void run() {
        System.out.println("Multiplication Result: " + (num1 * num2));
    }
}

class DivisionThread extends Thread {
    private double num1, num2;

    public DivisionThread(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public void run() {
        if (num2 != 0) {
            System.out.println("Division Result: " + (num1 / num2));
        } else {
            System.out.println("Error: Division by zero");
        }
    }
}

public class MultithreadedCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter first number: ");
            double num1 = Double.parseDouble(scanner.nextLine());

            System.out.print("Enter second number: ");
            double num2 = Double.parseDouble(scanner.nextLine());

            System.out.println("Choose operation: addition, subtraction, multiplication, division");
            String operation = scanner.nextLine().toLowerCase();

            switch (operation) {
                case "addition":
                    AdditionThread addThread = new AdditionThread(num1, num2);
                    addThread.start();
                    break;
                case "subtraction":
                    SubtractionThread subThread = new SubtractionThread(num1, num2);
                    subThread.start();
                    break;
                case "multiplication":
                    MultiplicationThread mulThread = new MultiplicationThread(num1, num2);
                    mulThread.start();
                    break;
                case "division":
                    DivisionThread divThread = new DivisionThread(num1, num2);
                    divThread.start();
                    break;
                default:
                    System.out.println("Invalid operation chosen.");
                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter valid numbers.");
        } finally {
            scanner.close();
        }
    }
}

