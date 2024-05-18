package FinalOOPLab;

import java.util.Scanner;

class SomeVehicle{

    String make;
    String model;
    int year;
    double mileage;

    public SomeVehicle(String make, String model, int year, double mileage){
        this.make = make;
        this.mileage = mileage;
        this.year = year;
        this.model = model;
    }

    public String toString() {
        return "Make: " + make + " , Model: " + model + " , Year: "+year+" , Mileage: " + mileage;
    }
    void displayDetails(){
        System.out.println(this.toString());
    }
}
public class FinalVehicle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String make;
        String model;
        int year=0;
        double mileage=0;
        System.out.println("Enter the make of the Vehicle: ");
        make = sc.nextLine();
        System.out.println("Enter the model of the Vehicle: ");
        model = sc.nextLine();
        System.out.println("Enter the year of the Vehicle: ");
        boolean correct = true;
        while (correct){
            year = sc.nextInt();
            if(year > 1950 && year <= 2024){
                break;
            }
            else{
                continue;
            }
        }
        System.out.println("Enter the Mileage of the Vehicle: ");
        boolean correctness = true;
        while (correctness){
            mileage = sc.nextDouble();
            if(mileage > 0){
                break;
            }
            else{
                continue;
            }
        }
        SomeVehicle veh = new SomeVehicle(make,model,year,mileage);
        veh.displayDetails();
        SomeVehicle gf = new SomeVehicle("Plastic", "Honda Activa", 2024, 50.32);
        gf.displayDetails();
    }
}