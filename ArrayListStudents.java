package FinalOOPLab;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListStudents {
    static ArrayList<Students> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        if(adminLogin()){
            boolean running = true;
            while(running){
                displayMenu();
                int choice = sc.nextInt();
                switch (choice){
                    case 1: addStudent();
                    break;
                    case 2: removeStudent();
                        break;
                    case 3: updateStudent();
                        break;
                    case 4: displayStudents();
                        break;
                    case 5: searchStudents();
                        break;
                    case 6: running = false;
                        break;
                    default: System.out.println("Invalid Choice");
                }
            }
        }
        else{
            System.out.println("Login Failed");
        }
    }
    static void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Add a new student");
        System.out.println("2. Remove a student");
        System.out.println("3. Update student information");
        System.out.println("4. Display all students");
        System.out.println("5. Search for a student");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }
    static void removeStudent(){
        System.out.print("Enter student ID to remove: ");
        int id = sc.nextInt();
        Students student = findStudentByiD(id);
        if (student == null) {
            System.out.println("Student with this ID not found.");
        } else {
            students.remove(student);
            System.out.println("Student removed successfully.");
        }
    };
    static void addStudent() {
        System.out.println("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // Consume newline character
        if (findStudentByiD(id) != null) {
            System.out.println("Student with this ID already exists");
            return;
        }
        System.out.println("Enter student name: ");
        String name = sc.nextLine();
        System.out.println("Enter student age: ");
        int age = sc.nextInt();
        sc.nextLine(); // Consume newline character
        System.out.println("Enter student gender: ");
        String gender = sc.nextLine();
        System.out.println("Enter student grade: ");
        String grade = sc.nextLine();
        System.out.println("Enter student contact information: ");
        int contactInfo = Integer.parseInt(sc.nextLine());
        students.add(new Students(id, name, age, gender, grade, contactInfo));
        System.out.println("Student added successfully.");
    }

    static void updateStudent() {
        System.out.print("Enter student ID to update: ");
        int id = sc.nextInt();
        sc.nextLine(); // Consume newline character
        Students student = findStudentByiD(id);
        if (student == null) {
            System.out.println("Student with this ID not found.");
            return;
        }
        System.out.print("Enter new name (leave blank to keep current): ");
        String name = sc.nextLine();
        if (!name.isEmpty()) {
            student.name = name;
        }
        System.out.print("Enter new age (leave blank to keep current): ");
        String ageInput = sc.nextLine();
        if (!ageInput.isEmpty()) {
            student.age = Integer.parseInt(ageInput);
        }
        System.out.print("Enter new gender (leave blank to keep current): ");
        String gender = sc.nextLine();
        if (!gender.isEmpty()) {
            student.gender = gender;
        }
        System.out.print("Enter new grade (leave blank to keep current): ");
        String grade = sc.nextLine();
        if (!grade.isEmpty()) {
            student.grade = grade;
        }
        System.out.print("Enter new contact information (leave blank to keep current): ");
        String contactInfo = sc.nextLine();
        if (!contactInfo.isEmpty()) {
            student.contactInfo = Integer.parseInt(contactInfo);
        }
        System.out.println("Student information updated successfully.");
    }
    static void displayStudents(){
        if (students.isEmpty()) {
            System.out.println("No students in the database.");
        } else {
            for (Students student : students) {
                System.out.println(student.toString());
            }
        }
    };
    static void searchStudents(){
        System.out.println("Search by:");
        System.out.println("1. ID");
        System.out.println("2. Name");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.print("Enter student ID: ");
                int id = sc.nextInt();
                Students studentById = findStudentByiD(id);
                if (studentById == null) {
                    System.out.println("Student with this ID not found.");
                } else {
                    System.out.println(studentById);
                }
                break;
            case 2:
                System.out.print("Enter student name: ");
                String name = sc.nextLine();
                ArrayList<Students> studentsByName = findStudentByName(name);
                if (studentsByName.isEmpty()) {
                    System.out.println("No students with this name found.");
                } else {
                    for (Students student : studentsByName) {
                        System.out.println(student);
                    }
                }
                break;
            default:
                System.out.println("Invalid choice.");
        }
    };
    static Students findStudentByiD(int id){
        for (Students student : students) {
            if (student.id == id) {
                return student;
            }
        }
        return null;
    };
    static ArrayList<Students> findStudentByName(String name){
        ArrayList<Students> result = new ArrayList<>();
        for (Students student : students) {
            if (student.name.contains(name)) {
                result.add(student);
            }
        }
        return result;
    };

    static boolean adminLogin(){
        System.out.println("Enter admin username: ");
        String username = sc.nextLine();
        System.out.println("Enter admin password: ");
        String password = sc.nextLine();

        return username.equals("admin") && password.equals("password");
    }
}
class Students{
    int id;
    String name;
    int age;
    String gender;
    String grade;
    int contactInfo;

    public Students(int id, String name, int age, String gender, String grade, int contactInfo) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.grade = grade;
        this.contactInfo = contactInfo;
    }
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Gender: " + gender + ", Grade: " + grade + ", Contact Info: " + contactInfo;
    }
}
