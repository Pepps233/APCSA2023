package org.APCSA2023.CABankAccount;

import java.io.PrintWriter;

public class BankAccount {

    /* balance the user holds */
    private double balance;

    /* name of user */
    private String name;

    /* account type: checking or saving */
    private String accountType;

    /* rate of interest, default is 3% */
    private double rate = 0.03;

    public BankAccount(double balance, String name) {
        this.balance = balance;
        this.name = name;
    }

    /* adds parameter amount into balance */
    public void deposit(double amountToDeposited) {
        System.out.println("\n" + "Depositing $" + amountToDeposited + " from the account...");
        balance += amountToDeposited;
    }

    /* subtracts money from balance according to parameter amount (if not more than account balance) */
    public void withdraw(double amountToWithdraw) {
        /* if withdraw amount is greater than balance */
        if(amountToWithdraw > balance)
            System.out.println("You can not withdraw more than what you have!");
        /* if withdraw amount is 0 or less than 0 */
        else if(amountToWithdraw <= 0.0)
            System.out.println("You can not withdraw 0$ or less than 0$");
        /* if withdraw amount is correctly entered */
        else {
            System.out.println("\n" + "Withdrawing $" + amountToWithdraw + " from the account...");
            balance -= amountToWithdraw;
        }
    }

    public void setupRate(double rate) {
        /* rate can not be 0 or less than 0 */
        if(rate <= 0)
            System.out.println("You can not have an interest rate of 0 or less than 0!");
        else {
            /* converting percent to decimal */
            this.rate /= 100;
        }
    }

    /* Calculates one month of balance */
    public void monthBalance() {
        balance += (rate * balance);
    }

    /* prints account state into console */
    public void printState() {
        System.out.println(name + "'s account has a balance of: $" + balance);
    }

    /* prints account state into output file */
    public void printStateToFile(PrintWriter printWriter) {
        printWriter.println(name + "'s account has a balance of: $" + balance);
    }
}
