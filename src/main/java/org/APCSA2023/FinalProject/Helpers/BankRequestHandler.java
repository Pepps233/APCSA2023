package org.APCSA2023.FinalProject.Helpers;

import org.APCSA2023.FinalProject.Accounts.BankAccount;
import org.APCSA2023.FinalProject.Accounts.CheckingAccount;
import org.APCSA2023.FinalProject.Accounts.SavingsAccount;
import org.APCSA2023.FinalProject.Constants.Constants;

public class BankRequestHandler {

    /**
     * Bank related requests will be in the following form:
     * pep accountNum -d/-w amount
     */
    public static void bankRequestHandler(String request) {
        BankHelper.sortByAccountNum();
        String[] tempArray = request.split(" ");
        int accountNumber = Integer.parseInt(tempArray[1]);
        double amount = Double.parseDouble(tempArray[3]);
        String operation = tempArray[2].equals("-d") ? "deposit" : "withdraw";
        int key = BankHelper.searchAccount(accountNumber);

        if (key != -1) {
            if (operation.equals("deposit")) {
                Constants.PROCESSED_OBJECTS.get(key).deposit(amount);
            } else {
                Constants.PROCESSED_OBJECTS.get(key).withdraw(amount);
            }
        }
    }

    public static void bankAccCreationHandler(String request) {
        String[] tempArray = request.split(" ");
        String firstName = tempArray[1];
        String lastName = tempArray[2];
        double accountBalance = Double.parseDouble(tempArray[3]);
        String accountType = tempArray[4];
        BankAccount ba;
        if (accountType.equalsIgnoreCase("checking")) {
            ba = new CheckingAccount(firstName + " " + lastName, Constants.ACCOUNT_NUMBER, accountBalance);
        } else {
            ba = new SavingsAccount(firstName + " " + lastName, Constants.ACCOUNT_NUMBER, accountBalance);
        }
        System.out.println("Created new account");
        System.out.println(ba);
        Constants.PROCESSED_OBJECTS.add(ba);
        Constants.ACCOUNT_NUMBER++;
    }
}
