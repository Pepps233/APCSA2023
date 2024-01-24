package org.APCSA2023.ClassHierarchyPractice;

/**
 * Jiale Yu
 * 1/24/24
 */
public class Tester {
    public static void main(String[] args) {
        Chimpanzee chimpanzee = new Chimpanzee(4, "Pan troglodytes");
        chimpanzee.giveName("David Tsang");
        chimpanzee.makeSound();
        chimpanzee.action();
        chimpanzee.walk();
        chimpanzee.displayInfo();
    }
}
