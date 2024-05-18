package FinalOOPLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee {
    String name;
    int employeeId;
    double hourlyRate;

    public Employee(String name, int employeeId, double hourlyRate) {
        this.name = name;
        this.employeeId = employeeId;
        this.hourlyRate = hourlyRate;
    }

    public String getName() {
        return name;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public double calculateMonthlySalary() {
        // This will be overridden by subclasses
        return 0;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', employeeId=" + employeeId + ", hourlyRate=" + hourlyRate + "}";
    }
}

class FullTimeEmployee extends Employee {
    double salary;
    double benefits;

    public FullTimeEmployee(String name, int employeeId, double hourlyRate, double salary, double benefits) {
        super(name, employeeId, hourlyRate);
        this.salary = salary;
        this.benefits = benefits;
    }

    public double getSalary() {
        return salary;
    }

    public double getBenefits() {
        return benefits;
    }

    @Override
    public double calculateMonthlySalary() {
        // Assuming the monthly salary is simply the base salary + benefits
        return salary + benefits;
    }

    @Override
    public String toString() {
        return "FullTimeEmployee{" +
                "name='" + name + '\'' +
                ", employeeId=" + employeeId +
                ", hourlyRate=" + hourlyRate +
                ", salary=" + salary +
                ", benefits=" + benefits +
                '}';
    }
}

class PartTimeEmployee extends Employee {
    int hoursWorked;
    double overtimeRate;

    public PartTimeEmployee(String name, int employeeId, double hourlyRate, int hoursWorked, double overtimeRate) {
        super(name, employeeId, hourlyRate);
        this.hoursWorked = hoursWorked;
        this.overtimeRate = overtimeRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public double getOvertimeRate() {
        return overtimeRate;
    }

    @Override
    public double calculateMonthlySalary() {
        // Assuming no overtime for simplicity, just regular hours worked * hourly rate
        return hoursWorked * hourlyRate + (hoursWorked > 160 ? (hoursWorked - 160) * overtimeRate : 0);
    }

    @Override
    public String toString() {
        return "PartTimeEmployee{" +
                "name='" + name + '\'' +
                ", employeeId=" + employeeId +
                ", hourlyRate=" + hourlyRate +
                ", hoursWorked=" + hoursWorked +
                ", overtimeRate=" + overtimeRate +
                '}';
    }
}

public class EmployeeManager {
    List<Employee> employees;

    public EmployeeManager() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void displayAllEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public void calculateSalaries() {
        for (Employee employee : employees) {
            System.out.println("Monthly Salary of " + employee.getName() + ": " + employee.calculateMonthlySalary());
        }
    }

    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Full-Time Employee");
            System.out.println("2. Add Part-Time Employee");
            System.out.println("3. Display All Employees");
            System.out.println("4. Calculate Salaries");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String fullTimeName = scanner.nextLine();
                    System.out.print("Enter employee ID: ");
                    int fullTimeId = scanner.nextInt();
                    System.out.print("Enter hourly rate: ");
                    double fullTimeHourlyRate = scanner.nextDouble();
                    System.out.print("Enter salary: ");
                    double fullTimeSalary = scanner.nextDouble();
                    System.out.print("Enter benefits: ");
                    double fullTimeBenefits = scanner.nextDouble();
                    manager.addEmployee(new FullTimeEmployee(fullTimeName, fullTimeId, fullTimeHourlyRate, fullTimeSalary, fullTimeBenefits));
                    break;
                case 2:
                    System.out.print("Enter name: ");
                    String partTimeName = scanner.nextLine();
                    System.out.print("Enter employee ID: ");
                    int partTimeId = scanner.nextInt();
                    System.out.print("Enter hourly rate: ");
                    double partTimeHourlyRate = scanner.nextDouble();
                    System.out.print("Enter hours worked: ");
                    int partTimeHoursWorked = scanner.nextInt();
                    System.out.print("Enter overtime rate: ");
                    double partTimeOvertimeRate = scanner.nextDouble();
                    manager.addEmployee(new PartTimeEmployee(partTimeName, partTimeId, partTimeHourlyRate, partTimeHoursWorked, partTimeOvertimeRate));
                    break;
                case 3:
                    System.out.println("All Employees:");
                    manager.displayAllEmployees();
                    break;
                case 4:
                    System.out.println("Calculating Salaries:");
                    manager.calculateSalaries();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
