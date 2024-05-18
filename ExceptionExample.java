package FinalOOPLab;

import java.util.Scanner;

class NegativeArrayIndexException extends Exception {
    public NegativeArrayIndexException(String message) {
        super(message);
    }
}

public class ExceptionExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the size of the array: ");
            int size = scanner.nextInt();
            int[] arr = new int[size];

            System.out.print("Enter the index to access (0 to " + (size - 1) + "): ");
            int index = scanner.nextInt();

            if (index < 0) {
                throw new NegativeArrayIndexException("Negative array index is not allowed");
            }
            System.out.println("Value at index " + index + ": " + arr[index]);
        } catch (NegativeArrayIndexException e) {
            System.out.println("Caught NegativeArrayIndexException: " + e.getMessage());
        }
        try {
            System.out.println("Enter a number: ");
            int a = scanner.nextInt();

            System.out.println("Enter divisor: ");
            int b = scanner.nextInt();
            int result = a / b;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Caught Exception: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
