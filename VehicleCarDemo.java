package FinalOOPLab;

public class VehicleCarDemo {

    public static class Vehicle {
        private String make;
        private String model;
        private int year;

        public Vehicle(String make, String model, int year) {
            this.make = make;
            this.model = model;
            this.year = year;
        }

        public String getMake() {
            return make;
        }

        public void setMake(String make) {
            this.make = make;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        @Override
        public String toString() {
            return "Vehicle [Make=" + make + ", Model=" + model + ", Year=" + year + "]";
        }
    }

    public static class Car extends Vehicle {
        private int numberOfDoors;

        public Car(String make, String model, int year, int numberOfDoors) {
            super(make, model, year);
            this.numberOfDoors = numberOfDoors;
        }

        public int getNumberOfDoors() {
            return numberOfDoors;
        }

        public void setNumberOfDoors(int numberOfDoors) {
            this.numberOfDoors = numberOfDoors;
        }

        @Override
        public String toString() {
            return "Car [Make=" + getMake() + ", Model=" + getModel() + ", Year=" + getYear() + ", Number of Doors=" + numberOfDoors + "]";
        }
    }

    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle("Toyota", "Corolla", 2015);
        System.out.println(vehicle);

        Car car = new Car("Honda", "Civic", 2020, 4);
        System.out.println(car);

        System.out.println("Make: " + car.getMake());
        System.out.println("Model: " + car.getModel());
        System.out.println("Year: " + car.getYear());
        System.out.println("Number of Doors: " + car.getNumberOfDoors());
    }
}
