package org.APCSA2023.FinalProject;

public class SavingsAccount extends BankAccount {
    private final double ratePYear;
    private final double withdrawLimit;

    public SavingsAccount(String n, int aN, double b) {
        super(n, aN, b);
        // example interest rate per one year
        this.ratePYear = 3;
        // maximum withdraw is 10% of money in bank
        this.withdrawLimit = b * 0.1;
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
