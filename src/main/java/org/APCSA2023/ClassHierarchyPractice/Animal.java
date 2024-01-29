package org.APCSA2023.ClassHierarchyPractice;

public class Animal {
    private final String species;

    public Animal(String species) {
        this.species = species;
    }

    /* Methods for subclass to override */

    public void makeSound() {
        System.out.println("The " + species + " is making a sound!");
    }

    public void displayInfo() {
        System.out.println("The specie of this animal is: " + species);
    }

    @Override
    public String toString() {
        return "From Animal";
    }
}
