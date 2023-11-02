package org.APCSA2023.BankInformation;

public class BankInfo {
    private String bankOneName;
    private int bankOneNumber;
    private double bankOneBalance;
    private String bankTwoName;
    private int bankTwoNumber;
    private double bankTwoBalance;

    // overloading two constructor methods for more flexible object instantiation
    public BankInfo(String bankOneName, int bankOneNumber, double bankOneBalance) {
        this.bankOneName = bankOneName;
        this.bankOneNumber = bankOneNumber;
        this.bankOneBalance = bankOneBalance;
    }
    public BankInfo(String bankOneName, int bankOneNumber, double bankOneBalance, String bankTwoName, int bankTwoNumber,
                    double bankTwoBalance) {
        this.bankOneName = bankOneName;
        this.bankOneNumber = bankOneNumber;
        this.bankOneBalance = bankOneBalance;
        this.bankTwoName = bankTwoName;
        this.bankTwoNumber = bankTwoNumber;
        this.bankTwoBalance = bankTwoBalance;
    }
    // getter methods
    public String getBankOneName() {return bankOneName;}
    public String getBankTwoName() {return bankTwoName;}
    public int getBankOneNumber() {return bankOneNumber;}
    public int getBankTwoNumber() {return bankTwoNumber;}
    public double getBankOneBalance() {return bankOneBalance;}
    public double getBankTwoBalance() {return bankTwoBalance;}
}
