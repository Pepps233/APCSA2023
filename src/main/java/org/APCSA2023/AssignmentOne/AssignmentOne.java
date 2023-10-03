// this program will read two inputs from the user: the hypotenuse of a triangle, and an angle, the program
// then calculates a series of values and performs a series of operations

// 10/3/23

package org.APCSA2023.AssignmentOne;

import java.util.Scanner;

public class AssignmentOne {
    public static void main(String[] args) {
        int hypotenuse;
        double angle;
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("Enter hypotenuse: ");
        hypotenuse = inputScanner.nextInt();
        System.out.println("Enter angle: ");
        angle = inputScanner.nextDouble();
        System.out.println("\n" + "--------------------" + "\n");
        // to radians so the angles don't contain negatives for further calculations
        System.out.println("sin(theta): " + Math.sin(Math.toRadians(angle)));
        System.out.println("cos(theta): " + Math.cos(Math.toRadians(angle)));
        System.out.println("tan(theta): " + Math.tan(Math.toRadians(angle)));

        System.out.println("\n" + "--------------------" + "\n");
        // opposite length comes from: hypotenuse * sin(angle) => to radians so length is not negative
        double oppositeLength = hypotenuse * Math.sin(Math.toRadians(angle));
        // adjacent length comes from: hypotenuse * cos(angle) => to radians so length is not negative
        double adjacentLength = hypotenuse * Math.cos(Math.toRadians(angle));
        System.out.println("Adjacent side length: " + adjacentLength);
        System.out.println("Opposite side length: " + oppositeLength);
        // difference, doesn't matter which way we subtract since abs()
        double difference = Math.abs(oppositeLength - adjacentLength);
        System.out.println("Difference between adjacent and opposite side: " + difference);

        System.out.println("\n" + "--------------------" + "\n");
        System.out.println("Hypotenuse raised to opposite power: " + Math.pow(hypotenuse, oppositeLength));

        System.out.println("\n" + "--------------------" + "\n");
        // cast value to double since the round method returns a long
        double roundedOpposite = (double)Math.round(oppositeLength);
        double roundedAdjacent = (double)Math.round(adjacentLength);
        System.out.println("Rounded opposite side: " + roundedOpposite);
        System.out.println("Rounded adjacent side: " + roundedAdjacent);
        // hypot method returns a hypotenuse through the two sides of a triangle
        double newHypotenuse = Math.hypot(roundedOpposite, roundedAdjacent);
        System.out.println("New hypotenuse: " + newHypotenuse);
        // inverse function to find radians, and then convert to degrees
        double newAngle = Math.atan(roundedOpposite / roundedAdjacent) * (180/Math.PI);
        System.out.println("New angle: " + newAngle);

        System.out.println("\n" + "--------------------" + "\n");
        // figure which angle is larger, and which is smaller
        if(angle > newAngle) {
            System.out.println("Bigger angle: " + angle);
            System.out.println("Smaller angle: " + newAngle);
        }
        else {
            System.out.println("Bigger angle: " + newAngle);
            System.out.println("Smaller angle: " + angle);
        }
    }
}
