package org.APCSA2023.OverdrawnBank;

public class BankAccount {

    /* balance the user holds */
    private double balance;

    /* name of user */
    private String name;

    public BankAccount(double balance, String name) {
        this.balance = balance;
        this.name = name;
    }

    /* adds parameter amount into balance */
    public void deposit(double amountToDeposited) {
        balance += amountToDeposited;
    }

    /* subtracts money from balance according to parameter amount (if not more than account balance) */
    public void withdraw(double amountToWithdraw) {
        if(amountToWithdraw > balance)
            System.out.println("You can not withdraw more than what you have!");
        else if(amountToWithdraw <= 0.0)
            System.out.println("You can not withdraw 0$ or less than 0$");
        else
            balance -= amountToWithdraw;
    }

    public void printState() {
        System.out.println(name + "'s account has a balance of: $" + balance);
    }
}
