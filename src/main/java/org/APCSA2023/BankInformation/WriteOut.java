package org.APCSA2023.BankInformation;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteOut {
    // two strings to hold the two user inputted user directories
    private String outputDirectoryOne;
    private String outputDirectoryTwo;
    // empty constructor (only the default instance of the class is needed to call methods)
    public WriteOut(){}

    // method to output to file
    protected void outputFile() {
        // invokes method from BankInformationHelper to obtain the user's desired output locations
        String[] temporaryArray = BankInformationHelper.getOutputDirectoryPath();
        // storing them into two string variables
        outputDirectoryOne = temporaryArray[0];
        outputDirectoryTwo = temporaryArray[1];
        // late initializing the PrintWriters, initializing to null to avoid compiler error
        PrintWriter outputOne = null, outputTwo = null;
        try {
            // create a new FileWriter object using the first desired directory
            FileWriter fw = new FileWriter(outputDirectoryOne);
            // PrintWriter object created with the previously created FileWriter as the argument
            outputOne = new PrintWriter(fw);
            // setting FileWriter object to use the second desired directory
            fw = new FileWriter(outputDirectoryTwo);
            // PrintWriter object created with the FileWriter that holds the second desired directory
            outputTwo = new PrintWriter(fw);
        } catch (IOException e) {
            // debug
            System.out.println("Error: " + e);
        }
        // necessary information needed to output
        // using shorter variable names to avoid longer names with the getter methods
        String firstName, middleName, lastName;
        String bankOne, bankTwo;
        int accountNumOne, accountNumTwo;
        double accountBalOne, accountBalTwo;
        // outputting the format onto the first output file
        /*
        * Format used:
        * minimum width 10, and maximum width 10, patting remaining with spaces to the right
        * minimum width 6, and maximum width 6, patting remaining with spaces to the right
        * minimum width of 10, and maximum width of 10, patting remaining with spaces to the right
        * minimum width of 5, maximum width of 5, patting remaining with spaces to the right
        * minimum width of 6, maximum width of 6, patting remaining with spaces to the right
        * minimum width of 9, maximum width of 9, patting remaining with spaces to the right
        * individual information are separated with two spaces followed by a pipe (|)
        */
        outputOne.format("%-10.10s  |  %-6.6s  |  %-10.10s  |  %-5.5s  |  %-6.6s  |  %-9.9s", "firstName", "middleName", "lastName", "bank", "bankID", "balance");
        outputOne.println();
        // outputting the format onto the second output file
        outputOne.println("-----------------------------------------------------------------------");
        outputTwo.format("%-10.10s  |  %-6.6s  |  %-10.10s  |  %-5.5s  |  %-6.6s  |  %-9.9s", "firstName", "middleName", "lastName", "bank", "bankID", "balance");
        outputTwo.println();
        outputTwo.println("-----------------------------------------------------------------------");
        for(int ct = 0; ct < BankInformationHelper.personArrayList.size(); ct++) {
            // initializing variables with getter methods
            firstName = BankInformationHelper.personArrayList.get(ct).getFirstName();
            middleName = BankInformationHelper.personArrayList.get(ct).getMiddleName();
            lastName = BankInformationHelper.personArrayList.get(ct).getLastName();

            // if the second bank name is not null, it means the users have two bank accounts
            if(BankInformationHelper.bankInfoArrayList.get(ct).getBankTwoName() != null) {
                // initializing variables with getter methods to avoid longer getter method names
                bankOne = BankInformationHelper.bankInfoArrayList.get(ct).getBankOneName();
                bankTwo = BankInformationHelper.bankInfoArrayList.get(ct).getBankTwoName();
                accountNumOne = BankInformationHelper.bankInfoArrayList.get(ct).getBankOneNumber();
                accountNumTwo = BankInformationHelper.bankInfoArrayList.get(ct).getBankTwoNumber();
                accountBalOne = BankInformationHelper.bankInfoArrayList.get(ct).getBankOneBalance();
                accountBalTwo = BankInformationHelper.bankInfoArrayList.get(ct).getBankTwoBalance();

                // if the user does not have a middle name
                if(middleName == null) {
                    // outputting formatted information onto first output file
                    outputOne.format("%-10.10s  |  %-6.6s  |  %-10.10s  |  %-5.5s  |  %-6d  |  %-,9.3f", firstName, "", lastName, bankOne, accountNumOne, accountBalOne);
                    outputOne.println();
                    // outputting formatted information onto second output file
                    outputTwo.format("%-10.10s  |  %-6.6s  |  %-10.10s  |  %-5.5s  |  %-6d  |  %-,9.3f", firstName, "", lastName, bankTwo, accountNumTwo, accountBalTwo);
                    outputTwo.println();
                }
                // if the user does have a middle name
                else {
                    // outputting formatted information onto first output file
                    outputOne.format("%-10.10s  |  %-6.6s  |  %-10.10s  |  %-5.5s  |  %-6d  |  %-,9.3f", firstName, middleName, lastName, bankOne, accountNumOne, accountBalOne);
                    outputOne.println();
                    // outputting formatted information onto second output file
                    outputTwo.format("%-10.10s  |  %-6.6s  |  %-10.10s  |  %-5.5s  |  %-6d  |  %-,9.3f", firstName, middleName, lastName, bankTwo, accountNumTwo, accountBalTwo);
                    outputTwo.println();
                }
            }
            // only one bank account
            else {
                // initialize necessary information using getter methods
                bankOne = BankInformationHelper.bankInfoArrayList.get(ct).getBankOneName();
                accountNumOne = BankInformationHelper.bankInfoArrayList.get(ct).getBankOneNumber();
                accountBalOne = BankInformationHelper.bankInfoArrayList.get(ct).getBankOneBalance();
                // if the user is registered under BOC
                if(bankOne.equals("BOC")) {
                    // if the user does not have a middle name
                    if(middleName == null) {
                        // output onto the first output file, which holds BOC banks
                        outputOne.format("%-10.10s  |  %-6.6s  |  %-10.10s  |  %-5.5s  |  %-6d  |  %-,9.3f", firstName, "", lastName, bankOne, accountNumOne, accountBalOne);
                        outputOne.println();
                    }
                    // the user does have a middle name
                    else {
                        // output onto the first output file, which holds BOC banks
                        outputOne.format("%-10.10s  |  %-6.6s  |  %-10.10s  |  %-5.5s  |  %-6d  |  %-,9.3f", firstName, middleName, lastName, bankOne, accountNumOne, accountBalOne);
                        outputOne.println();
                    }
                }
                // if user is registered under BUS
                else {
                    // if the user does not have a middle name
                    if(middleName == null) {
                        // output onto the second output file, which holds BUS banks
                        outputTwo.format("%-10.10s  |  %-6.6s  |  %-10.10s  |  %-5.5s  |  %-6d  |  %-,9.3f", firstName, "", lastName, bankOne, accountNumOne, accountBalOne);
                        outputTwo.println();
                    }
                    // the user does have a middle name
                    else {
                        // output onto the second output file, which holds BUS banks
                        outputTwo.format("%-10.10s  |  %-6.6s  |  %-10.10s  |  %-5.5s  |  %-6d  |  %-,9.3f", firstName, middleName, lastName, bankOne, accountNumOne, accountBalOne);
                        outputTwo.println();
                    }
                }
            }
        }
        outputOne.close();
        outputTwo.close();
    }
}
