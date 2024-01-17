package org.APCSA2023.CABankAccount;

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

        BankAccount myAccount = new BankAccount(initialBalance, name);
        OutputHandler output = new OutputHandler(myAccount);

        myAccount.deposit(505.22);

        myAccount.withdraw(100);

        output.printInformation();
        output.closeOutputFile();
    }
}
