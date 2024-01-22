package org.APCSA2023.CABankAccountInheritance;

import java.io.IOException;
import java.util.Scanner;

public class Tester {
    public static void main(String[] args) throws IOException {
        // stores initial balance
        double initialBalance;

        // stores name
        String name;

        /* scanners for handling input */
        Scanner scanner = new Scanner(System.in);
        Scanner scannerTwo = new Scanner(System.in);


        System.out.println("Enter initial balance for bank account: ");
        initialBalance = scanner.nextDouble();

        System.out.println("Enter your name: ");
        name = scannerTwo.nextLine();

        CABankAccount account = new CABankAccount(initialBalance, name);

        /* Super class deposit method */
        account.deposit(505.22);
        /* Super class print status method */
        account.printState();
        /* Super class withdraw method */
        account.withdraw(100);
        /* Super class print status method */
        account.printState();

    }
}
