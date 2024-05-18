package FinalOOPLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IntegerList {
    private List<Integer> intList;

    public IntegerList() {
        intList = new ArrayList<>();
    }

    public void addInteger(int number) {
        intList.add(number);
        System.out.println(number + " added to the list.");
    }

    public void insertInteger(int index, int number) {
        if (index < 0 || index > intList.size()) {
            System.out.println("Index out of bounds.");
        } else {
            intList.add(index, number);
            System.out.println(number + " inserted at index " + index + ".");
        }
    }

    public void removeIntegerByValue(int number) {
        if (intList.remove((Integer) number)) {
            System.out.println(number + " removed from the list.");
        } else {
            System.out.println(number + " not found in the list.");
        }
    }

    public void removeIntegerByIndex(int index) {
        if (index < 0 || index >= intList.size()) {
            System.out.println("Index out of bounds.");
        } else {
            int removedNumber = intList.remove(index);
            System.out.println("Integer " + removedNumber + " removed from index " + index + ".");
        }
    }

    public void searchInteger(int number) {
        int index = intList.indexOf(number);
        if (index != -1) {
            System.out.println(number + " found at index " + index + ".");
        } else {
            System.out.println(number + " not found in the list.");
        }
    }

    public void displayIntegers() {
        if (intList.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            System.out.println("List of integers:");
            for (int number : intList) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        IntegerList listManipulator = new IntegerList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nList Manipulator Menu:");
            System.out.println("1. Add an integer to the end of the list");
            System.out.println("2. Insert an integer at a specified index in the list");
            System.out.println("3. Remove an integer from the list based on its value");
            System.out.println("4. Remove an integer at a specified index in the list");
            System.out.println("5. Search for the index of a given integer in the list");
            System.out.println("6. Display all integers in the list");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter integer to add: ");
                    int addNumber = scanner.nextInt();
                    listManipulator.addInteger(addNumber);
                    break;
                case 2:
                    System.out.print("Enter index to insert at: ");
                    int insertIndex = scanner.nextInt();
                    System.out.print("Enter integer to insert: ");
                    int insertNumber = scanner.nextInt();
                    listManipulator.insertInteger(insertIndex, insertNumber);
                    break;
                case 3:
                    System.out.print("Enter integer to remove: ");
                    int removeNumber = scanner.nextInt();
                    listManipulator.removeIntegerByValue(removeNumber);
                    break;
                case 4:
                    System.out.print("Enter index to remove from: ");
                    int removeIndex = scanner.nextInt();
                    listManipulator.removeIntegerByIndex(removeIndex);
                    break;
                case 5:
                    System.out.print("Enter integer to search for: ");
                    int searchNumber = scanner.nextInt();
                    listManipulator.searchInteger(searchNumber);
                    break;
                case 6:
                    listManipulator.displayIntegers();
                    break;
                case 7:
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
