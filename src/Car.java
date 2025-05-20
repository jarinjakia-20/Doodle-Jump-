
public class Car {

    private String owner;
    private String brand;
    private String serialNumber;
    private double fuelLevel;
    private boolean isRunning;

    public Car(String owner, String brand, String serialNumber, double fuelLevel) {
        this.owner = owner;
        this.brand = brand;
        this.serialNumber = serialNumber;
        this.fuelLevel = fuelLevel;
        this.isRunning = false; // Car is initially off
    }

    public void start() {
        if (fuelLevel > 0) {
            isRunning = true;
            System.out.println("Car started.");
        } else {
            System.out.println("Cannot start. Fuel is empty!");
        }
    }

    public void stop() {
        if (isRunning) {
            isRunning = false;
            System.out.println("Car stopped.");
        } else {
            System.out.println("Car is already stopped.");
        }
    }

    public void checkFuel() {
        System.out.println("Current fuel level: " + fuelLevel + " liters.");
    }

    public void refuel(double amount) {
        if (amount > 0) {
            fuelLevel += amount;
            System.out.println("Car refueled with " + amount + " liters. New fuel level: " + fuelLevel + " liters.");
        } else {
            System.out.println("Invalid fuel amount.");
        }
    }

    public void displayCarInfo() {
        System.out.println("Owner: " + owner);
        System.out.println("Brand: " + brand);
        System.out.println("Serial Number: " + serialNumber);
        System.out.println("Fuel Level: " + fuelLevel + " liters");
        System.out.println("Car is " + (isRunning ? "Running" : "Stopped"));
    }

    public static void main(String[] args) {

        Car myCar = new Car("John Doe", "Toyota", "12345XYZ", 10.0);

        myCar.displayCarInfo();

        myCar.start();

        myCar.checkFuel();

        myCar.stop();

        myCar.refuel(5);

        myCar.displayCarInfo();
    }
}
