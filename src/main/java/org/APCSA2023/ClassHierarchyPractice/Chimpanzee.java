package org.APCSA2023.ClassHierarchyPractice;

public class Chimpanzee extends Mammal{
    private String name;

    public Chimpanzee(int numLegs, String species) {
        super(numLegs, species);
    }

    public void giveName(String name) {
        this.name = name;
        System.out.println("The name of the animal is now " + name + '.');
    }

    @Override
    public void makeSound() {
        System.out.println(name + " is grunting...");
    }

    public void action() {
        System.out.println(name + " is climbing a tree!");
    }

    @Override
    public String toString() {
        return "From Chimpanzee";
    }
}
