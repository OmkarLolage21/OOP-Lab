package FinalOOPLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ArrayListOperations {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));

        System.out.print("Enter an element to check if it exists in the ArrayList: ");
        Scanner scanner = new Scanner(System.in);
        int element = scanner.nextInt();
        if (list.contains(element)) {
            System.out.println(element + " exists in the ArrayList.");
        } else {
            System.out.println(element + " does not exist in the ArrayList.");
        }

        System.out.print("Enter an index to add an element: ");
        int index = scanner.nextInt();
        System.out.print("Enter the element to add at index " + index + ": ");
        element = scanner.nextInt();
        list.add(index, element);
        System.out.println("ArrayList after adding element: " + list);

        System.out.print("Enter an index to remove an element: ");
        index = scanner.nextInt();
        list.remove(index);
        System.out.println("ArrayList after removing element: " + list);

        Collections.sort(list);
        System.out.println("Sorted ArrayList: " + list);

        Collections.reverse(list);
        System.out.println("Reversed ArrayList: " + list);

        ArrayList<Integer> anotherList = new ArrayList<>(Arrays.asList(50, 40, 30, 20, 10));
        boolean areEqual = list.equals(anotherList);
        System.out.println("Comparing with another list: " + anotherList);
        if (areEqual) {
            System.out.println("Both ArrayLists are equal.");
        } else {
            System.out.println("ArrayLists are not equal.");
        }

        list.addAll(Arrays.asList(10, 20, 10, 15, 40, 15, 40));
        System.out.println("ArrayList with duplicates: " + list);
        System.out.print("Enter an element to find its first and last occurrence: ");
        element = scanner.nextInt();
        int firstIndex = list.indexOf(element);
        int lastIndex = list.lastIndexOf(element);
        if (firstIndex == -1) {
            System.out.println("Element not found in the list.");
        } else {
            System.out.println("First occurrence of element " + element + " is at index: " + firstIndex);
            System.out.println("Last occurrence of element " + element + " is at index: " + lastIndex);
        }

        scanner.close();
    }
}

