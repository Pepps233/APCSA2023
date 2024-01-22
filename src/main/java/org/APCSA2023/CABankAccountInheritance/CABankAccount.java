package org.APCSA2023.CABankAccountInheritance;

public class CABankAccount extends BankAccount {

    /* balance the user holds */
    private double balance;

    /* name of user */
    private String name;
    /* account type: checking or saving */
    private String accountType;

    /* rate of interest, default is 3% */
    private double rate = 0.03;

    public CABankAccount(double balance, String name) {
        super(balance, name);
        this.balance = balance;
        this.name = name;
    }

    private void setupRate(double rate) {
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
}
