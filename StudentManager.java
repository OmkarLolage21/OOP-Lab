package FinalOOPLab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class Student {
    String name;
    int rollNumber;
    String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', rollNumber=" + rollNumber + ", grade='" + grade + "'}";
    }
}

public class StudentManager {
    List<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }
    public void removeStudent(int rollNumber) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getRollNumber() == rollNumber) {
                iterator.remove();
                return;
            }
        }
        System.out.println("Student with roll number " + rollNumber + " not found.");
    }

    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void replaceGrade(int rollNumber, String newGrade) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                student.setGrade(newGrade);
                return;
            }
        }
        System.out.println("Student with roll number " + rollNumber + " not found.");
    }
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Display All Students");
            System.out.println("4. Replace Student Grade");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter roll number: ");
                    int rollNumber = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter grade: ");
                    String grade = scanner.nextLine();
                    manager.addStudent(new Student(name, rollNumber, grade));
                    break;
                case 2:
                    System.out.print("Enter roll number of student to remove: ");
                    int rollToRemove = scanner.nextInt();
                    manager.removeStudent(rollToRemove);
                    break;
                case 3:
                    System.out.println("All Students:");
                    manager.displayAllStudents();
                    break;
                case 4:
                    System.out.print("Enter roll number of student to update grade: ");
                    int rollToUpdate = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter new grade: ");
                    String newGrade = scanner.nextLine();
                    manager.replaceGrade(rollToUpdate, newGrade);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
