package org.APCSA2023.Vehicle;

public class Car extends VehicleBase implements Vehicle{
    private final String model;
    public Car(String brand, String model) {
        super(brand);
        this.model = model;
    }
    public void start() {
        System.out.println("Vehicle of Brand: " + getBrand() + ", model " + model + " started!");
    }

    public void stop() {
        System.out.println("Vehicle of Brand: " + getBrand() + ", model " + model + " stopped!");
    }
}
