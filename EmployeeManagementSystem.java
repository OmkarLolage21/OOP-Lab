package FinalOOPLab;

import java.util.ArrayList;
import java.util.Scanner;

abstract class Employees {
    protected String name;
    protected int employeeID;

    public Employees(String name, int employeeID) {
        this.name = name;
        this.employeeID = employeeID;
    }

    public abstract double calculateSalary();
    public abstract String evaluatePerformance();

    public String getName() {
        return name;
    }

    public int getEmployeeID() {
        return employeeID;
    }
}

class FullTimeEmployees extends Employees {
    private double monthlySalary;
    private double performanceBonus;

    public FullTimeEmployees(String name, int employeeID, double monthlySalary) {
        super(name, employeeID);
        this.monthlySalary = monthlySalary;
    }

    public void setPerformanceBonus(double performanceBonus) {
        this.performanceBonus = performanceBonus;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary + performanceBonus;
    }

    @Override
    public String evaluatePerformance() {
        if (performanceBonus > 0) {
            return "Excellent";
        } else {
            return "Satisfactory";
        }
    }
}

class PartTimeEmployees extends Employees {
    private double hourlyRate;
    private int hoursWorked;

    public PartTimeEmployees(String name, int employeeID, double hourlyRate, int hoursWorked) {
        super(name, employeeID);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }

    @Override
    public String evaluatePerformance() {
        return "Performance evaluation not applicable";
    }
}

public class EmployeeManagementSystem {
    private ArrayList<Employees> employees = new ArrayList<>();

    public void registerEmployee(Employees employee) {
        employees.add(employee);
    }

    public void displaySalaries() {
        for (Employees employee : employees) {
            System.out.println("Employee ID: " + employee.getEmployeeID() +
                    ", Name: " + employee.getName() +
                    ", Salary: $" + employee.calculateSalary());
        }
    }

    public void evaluateEmployees() {
        for (Employees employee : employees) {
            System.out.println("Employee ID: " + employee.getEmployeeID() +
                    ", Name: " + employee.getName() +
                    ", Performance: " + employee.evaluatePerformance());
        }
    }

    public static void main(String[] args) {
        EmployeeManagementSystem system = new EmployeeManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Register Full-time Employee");
            System.out.println("2. Register Part-time Employee");
            System.out.println("3. Calculate Salaries");
            System.out.println("4. Evaluate Performance");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            if (option == 1) {
                System.out.print("Enter name: ");
                String name = scanner.next();
                System.out.print("Enter employee ID: ");
                int employeeID = scanner.nextInt();
                System.out.print("Enter monthly salary: ");
                double monthlySalary = scanner.nextDouble();
                FullTimeEmployees ftEmployee = new FullTimeEmployees(name, employeeID, monthlySalary);
                System.out.print("Enter performance bonus: ");
                double performanceBonus = scanner.nextDouble();
                ftEmployee.setPerformanceBonus(performanceBonus);
                system.registerEmployee(ftEmployee);

            } else if (option == 2) {
                System.out.print("Enter name: ");
                String name = scanner.next();
                System.out.print("Enter employee ID: ");
                int employeeID = scanner.nextInt();
                System.out.print("Enter hourly rate: ");
                double hourlyRate = scanner.nextDouble();
                System.out.print("Enter hours worked: ");
                int hoursWorked = scanner.nextInt();
                PartTimeEmployees ptEmployee = new PartTimeEmployees(name, employeeID, hourlyRate, hoursWorked);
                system.registerEmployee(ptEmployee);

            } else if (option == 3) {
                system.displaySalaries();

            } else if (option == 4) {
                system.evaluateEmployees();

            } else if (option == 5) {
                break;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

