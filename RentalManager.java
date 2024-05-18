package FinalOOPLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Rentable {
    void rent();
    void returnVehicle();
    double calculateRentalCost(int days);
}

class Vehicles {
    String make;
    String model;
    boolean isRented;

    public Vehicles(String make, String model) {
        this.make = make;
        this.model = model;
        this.isRented = false;
    }

    @Override
    public String toString() {
        return make + " " + model + (isRented ? " (Rented)" : " (Available)");
    }
}

class Cars extends Vehicles implements Rentable {
    private static final double DAILY_RENTAL_RATE = 50.0;

    public Cars(String make, String model) {
        super(make, model);
    }

    @Override
    public void rent() {
        if (!isRented) {
            isRented = true;
            System.out.println(make + " " + model + " has been rented.");
        } else {
            System.out.println(make + " " + model + " is already rented.");
        }
    }

    @Override
    public void returnVehicle() {
        if (isRented) {
            isRented = false;
            System.out.println(make + " " + model + " has been returned.");
        } else {
            System.out.println(make + " " + model + " is not rented.");
        }
    }

    @Override
    public double calculateRentalCost(int days) {
        return DAILY_RENTAL_RATE * days;
    }
}

class Motorcycle extends Vehicles implements Rentable {
    private static final double DAILY_RENTAL_RATE = 30.0;

    public Motorcycle(String make, String model) {
        super(make, model);
    }

    @Override
    public void rent() {
        if (!isRented) {
            isRented = true;
            System.out.println(make + " " + model + " has been rented.");
        } else {
            System.out.println(make + " " + model + " is already rented.");
        }
    }

    @Override
    public void returnVehicle() {
        if (isRented) {
            isRented = false;
            System.out.println(make + " " + model + " has been returned.");
        } else {
            System.out.println(make + " " + model + " is not rented.");
        }
    }

    @Override
    public double calculateRentalCost(int days) {
        return DAILY_RENTAL_RATE * days;
    }
}

class Bicycle extends Vehicles implements Rentable {
    private static final double DAILY_RENTAL_RATE = 10.0;

    public Bicycle(String make, String model) {
        super(make, model);
    }

    @Override
    public void rent() {
        if (!isRented) {
            isRented = true;
            System.out.println(make + " " + model + " has been rented.");
        } else {
            System.out.println(make + " " + model + " is already rented.");
        }
    }

    @Override
    public void returnVehicle() {
        if (isRented) {
            isRented = false;
            System.out.println(make + " " + model + " has been returned.");
        } else {
            System.out.println(make + " " + model + " is not rented.");
        }
    }

    @Override
    public double calculateRentalCost(int days) {
        return DAILY_RENTAL_RATE * days;
    }
}

public class RentalManager {
    private List<Rentable> vehicles;

    public RentalManager() {
        vehicles = new ArrayList<>();
    }

    public void addVehicle(Rentable vehicle) {
        vehicles.add(vehicle);
    }

    public void displayAvailableVehicles() {
        System.out.println("Available Vehicles:");
        for (Rentable vehicle : vehicles) {
            if (!((Vehicles) vehicle).isRented) {
                System.out.println(vehicle);
            }
        }
    }

    public void displayRentedVehicles() {
        System.out.println("Rented Vehicles:");
        for (Rentable vehicle : vehicles) {
            if (((Vehicles) vehicle).isRented) {
                System.out.println(vehicle);
            }
        }
    }

    public Rentable findVehicle(String make, String model) {
        for (Rentable vehicle : vehicles) {
            Vehicles v = (Vehicles) vehicle;
            if (v.make.equalsIgnoreCase(make) && v.model.equalsIgnoreCase(model)) {
                return vehicle;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        RentalManager rentalManager = new RentalManager();
        rentalManager.addVehicle(new Cars("Toyota", "Camry"));
        rentalManager.addVehicle(new Motorcycle("Yamaha", "R1"));
        rentalManager.addVehicle(new Bicycle("Giant", "Escape 3"));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nVehicle Rental System:");
            System.out.println("1. Display Available Vehicles");
            System.out.println("2. Rent a Vehicle");
            System.out.println("3. Return a Vehicle");
            System.out.println("4. Display Rented Vehicles");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    rentalManager.displayAvailableVehicles();
                    break;
                case 2:
                    System.out.print("Enter Make: ");
                    String make = scanner.nextLine();
                    System.out.print("Enter Model: ");
                    String model = scanner.nextLine();
                    Rentable vehicleToRent = rentalManager.findVehicle(make, model);
                    if (vehicleToRent != null) {
                        vehicleToRent.rent();
                    } else {
                        System.out.println("Vehicle not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter Make: ");
                    make = scanner.nextLine();
                    System.out.print("Enter Model: ");
                    model = scanner.nextLine();
                    Rentable vehicleToReturn = rentalManager.findVehicle(make, model);
                    if (vehicleToReturn != null) {
                        vehicleToReturn.returnVehicle();
                    } else {
                        System.out.println("Vehicle not found.");
                    }
                    break;
                case 4:
                    rentalManager.displayRentedVehicles();
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
