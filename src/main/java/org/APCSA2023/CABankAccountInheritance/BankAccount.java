package org.APCSA2023.CABankAccountInheritance;

public class BankAccount {

    /* balance the user holds */
    private double balance;

    /* name of user */
    private final String name;

    public BankAccount(double balance, String name) {
        this.balance = balance;
        this.name = name;
    }

    /* adds parameter amount into balance */
     void deposit(double amountToDeposited) {
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

    /* prints account state into console */
    public void printState() {
        System.out.println(name + "'s account has a balance of: $" + balance);
    }
}
