package FinalOOPLab;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class DatabaseStudent {
    private int id;
    private String name;
    private String department;

    public DatabaseStudent(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Department: " + department;
    }
}

public class StudentDatabase {
    private ArrayList<DatabaseStudent> students;

    public StudentDatabase() {
        students = new ArrayList<>();
    }

    public void addStudent(DatabaseStudent student) {
        students.add(student);
        System.out.println("Student added: " + student.getName());
    }

    public void removeStudent(int id) {
        Iterator<DatabaseStudent> iterator = students.iterator();
        while (iterator.hasNext()) {
            DatabaseStudent student = iterator.next();
            if (student.getId() == id) {
                iterator.remove();
                System.out.println("Student removed: " + student.getName());
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }

    public void searchById(int id) {
        for (DatabaseStudent student : students) {
            if (student.getId() == id) {
                System.out.println("Student found: " + student);
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }

    public void searchByName(String name) {
        boolean found = false;
        for (DatabaseStudent student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                System.out.println("Student found: " + student);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Student with name '" + name + "' not found.");
        }
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in the database.");
        } else {
            System.out.println("All students in the database:");
            for (DatabaseStudent student : students) {
                System.out.println(student);
            }
        }
    }

    public static void main(String[] args) {
        StudentDatabase database = new StudentDatabase();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nStudent Database Menu:");
            System.out.println("1. Add a new student");
            System.out.println("2. Remove a student");
            System.out.println("3. Search for a student by ID");
            System.out.println("4. Search for a student by name");
            System.out.println("5. Display all students");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student department: ");
                    String department = scanner.nextLine();
                    database.addStudent(new DatabaseStudent(id, name, department));
                    break;
                case 2:
                    System.out.print("Enter student ID to remove: ");
                    id = scanner.nextInt();
                    database.removeStudent(id);
                    break;
                case 3:
                    System.out.print("Enter student ID to search: ");
                    id = scanner.nextInt();
                    database.searchById(id);
                    break;
                case 4:
                    System.out.print("Enter student name to search: ");
                    name = scanner.nextLine();
                    database.searchByName(name);
                    break;
                case 5:
                    database.displayAllStudents();
                    break;
                case 6:
                    System.out.println("Exiting the student database.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
