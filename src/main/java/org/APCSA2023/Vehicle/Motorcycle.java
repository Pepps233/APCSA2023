package org.APCSA2023.Vehicle;

public class Motorcycle implements Vehicle{
    private final String brand;
    private final String model;

    public Motorcycle(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public void start() {
        System.out.println("Motorcycle of Brand: " + brand + ", model " + model + " started!");
    }

    public void stop() {
        System.out.println("Motorcycle of Brand: " + brand + ", model " + model + " stopped!");
    }
}
