package org.APCSA2023.Vehicle;

import java.util.ArrayList;

public class Tester {
    public static void main(String[] args) {
        ArrayList<Vehicle> vehicleList = new ArrayList<>();

        vehicleList.add(new Car("Tesla", "S"));
        vehicleList.add(new Car("Porsche", "911"));
        vehicleList.add(new Motorcycle("Harley", "Davidson"));
        vehicleList.add(new Motorcycle("BMW", "S 1000 RR"));

        for(Vehicle i: vehicleList) {
            VehicleStatus.reportVehicle(i);
        }
    }
}
