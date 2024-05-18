package org.APCSA2023.FinalProject;

public class BankAccount {
    private final String name;
    private final int accountNum;
    private double bal;

    public BankAccount(String n, int aN, double b) {
        this.name = n;
        this.accountNum = aN;
        this.bal = b;
    }

    public void deposit(double amount) {
        bal += amount;
    }

    public void withdraw(double amount) {
        bal -= amount;
    }

    public String getName() {
        return name;
    }

    public int getAccountNum() {
        return accountNum;
    }

    public double getBalance() {
        return bal;
    }

    public void setBalance(double value) {
        bal += value;
    }

    @Override
    public String toString() {
        String formattedBalance = String.format("%.2f", bal);
        return ("Name: " + name + ", account number: " + accountNum + ", balance: " + formattedBalance);
    }

    public int compareTo(BankAccount other) {
        if (getBalance() > other.getBalance()) return 1;
        if (getBalance() < other.getBalance()) return -1;
        if (getBalance() == other.getBalance()) return 0;
        return -2;
    }
}
