package org.APCSA2023.ClassHierarchyPractice;

/**
 * Jiale Yu
 * 1/24/24
 */
public class Tester {
    public static void main(String[] args) {
        Chimpanzee chimpanzee = new Chimpanzee(4, "Pan troglodytes");
        Animal animal = new Animal("Pan troglodytes");
        Mammal mammal = new Mammal(4, "Pan troglodytes");

        System.out.println("\n" + "Animal: ");

        animal.displayInfo();
        animal.makeSound();

        System.out.println("\n" + "Mammal: ");

        mammal.makeSound();
        mammal.walk();

        System.out.println("\n" + "Chimpanzee: ");

        chimpanzee.giveName("David Tsang");
        chimpanzee.makeSound();
        chimpanzee.action();
        chimpanzee.walk();
        chimpanzee.displayInfo();

        Mammal one = new Chimpanzee(4, "a");
        Animal two = new Chimpanzee(4, "b");
        Chimpanzee three = new Chimpanzee(4, "c");

        System.out.println("\n" + "To Strings: ");

        System.out.println(one.toString());
        System.out.println(two.toString());
        System.out.println(three.toString());
    }
}
