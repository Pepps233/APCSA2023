package org.APCSA2023.FinalProject;

public class CheckingAccount extends BankAccount {
    private final double ratePYear;
    private final double withdrawLimit;

    public CheckingAccount(String n, int aN, double b) {
        super(n, aN, b);
        // example interest rate per one year
        this.ratePYear = 2;
        // maximum withdraw per time is 40% of initial balance
        this.withdrawLimit = b * 0.4;
    }

    @Override
    public void withdraw(double amount) {
        if (!(amount > withdrawLimit) && !(amount > getBalance())) {
            super.withdraw(amount);
            System.out.println("withdrew " + amount + "$ from " + this.getName());
        }
        else {
            System.out.println("withdraw amount exceeded the limit!");
        }
    }

    public void applyInterest() {
        double amount = getBalance() * Math.pow((1 + (ratePYear / 365)), 365);
        super.setBalance(amount);
    }
}
