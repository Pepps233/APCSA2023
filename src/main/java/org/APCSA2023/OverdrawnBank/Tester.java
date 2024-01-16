package org.APCSA2023.OverdrawnBank;

import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        // stores initial balance
        double initialBalance;
        // stores name
        String name;

        Scanner scanner = new Scanner(System.in);
        Scanner scannerTwo = new Scanner(System.in);

        System.out.println("Enter initial balance for bank account: ");
        initialBalance = scanner.nextDouble();

        System.out.println("Enter your name: ");
        name = scannerTwo.nextLine();

        BankAccount myAccount = new BankAccount(initialBalance, name);

        myAccount.deposit(505.22);
        System.out.println("Depositing $505.22...");
        myAccount.printState();

        myAccount.withdraw(100);
        System.out.println("Withdrawing $100...");
        myAccount.printState();
    }
}
