package FinalOOPLab;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Scanner;

public class ArrayManipulations {
    public static int[] generateRandomArray(int size, int minValue, int maxValue) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(maxValue - minValue + 1) + minValue;
        }
        return array;
    }

    // Rotate the elements of the array to the right by a specified number of positions
    public static void rotateRight(int[] array, int positions) {
        int length = array.length;
        positions = positions % length;
        reverseArray(array, 0, length - 1);
        reverseArray(array, 0, positions - 1);
        reverseArray(array, positions, length - 1);
    }

    // Helper method to reverse a portion of the array
    private static void reverseArray(int[] array, int start, int end) {
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

    // Remove duplicate elements from the array while preserving the original order
    public static int[] removeDuplicates(int[] array) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for (int value : array) {
            set.add(value);
        }
        int[] result = new int[set.size()];
        int i = 0;
        for (int value : set) {
            result[i++] = value;
        }
        return result;
    }

    // Rearrange the elements of the array such that all even numbers appear before all odd numbers
    public static int[] rearrangeEvenOdd(int[] array) {
        ArrayList<Integer> evenList = new ArrayList<>();
        ArrayList<Integer> oddList = new ArrayList<>();
        for (int value : array) {
            if (value % 2 == 0) {
                evenList.add(value);
            } else {
                oddList.add(value);
            }
        }
        evenList.addAll(oddList);
        int[] result = new int[evenList.size()];
        for (int i = 0; i < evenList.size(); i++) {
            result[i] = evenList.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int size = scanner.nextInt();
        System.out.print("Enter minimum value: ");
        int minValue = scanner.nextInt();
        System.out.print("Enter maximum value: ");
        int maxValue = scanner.nextInt();

        int[] array = generateRandomArray(size, minValue, maxValue);
        System.out.println("Generated Array: ");
        printArray(array);

        System.out.print("Enter number of positions to rotate: ");
        int positions = scanner.nextInt();
        rotateRight(array, positions);
        System.out.println("Array after right rotation: ");
        printArray(array);

        array = removeDuplicates(array);
        System.out.println("Array after removing duplicates: ");
        printArray(array);

        array = rearrangeEvenOdd(array);
        System.out.println("Array after rearranging even and odd numbers: ");
        printArray(array);

        scanner.close();
    }

    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
