package org.APCSA2023.ClassHierarchyPractice;

public class Mammal extends Animal{
    private final int numLegs;
    private final String species;

    public Mammal(int numLegs, String species) {
        super(species);
        this.numLegs = numLegs;
        this.species = species;
    }

    /* methods for subclasses to override */

    @Override
    public void makeSound() {
        System.out.println(species + " is making a sound!");
    }

    public void walk() {
        System.out.println("The " + species + " is walking around with " + numLegs + " legs!");
    }
}
