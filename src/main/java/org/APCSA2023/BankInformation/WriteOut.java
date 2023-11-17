package org.APCSA2023.BankInformation;

import java.io.PrintWriter;

public class WriteOut {
    private PrintWriter outputOne;
    private PrintWriter outputTwo;
    // sets non instantiated PrintWriter with paths inputted by user
    protected void setOutputFiles(PrintWriter outputOne, PrintWriter outputTwo) {
        this.outputOne = outputOne;
        this.outputTwo = outputTwo;
    }

    protected void closeFiles() {
        outputOne.close();
        outputTwo.close();
    }

    protected void setOutputCategories() {
        outputOne.format("%-10.10s  |  %-6.6s  |  %-10.10s  |  %-5.5s  |  %-6.6s  |  %-9.9s", "first", "middle", "last", "bank", "bankID", "balance");
        outputOne.println();
        outputOne.println("-----------------------------------------------------------------------");
        outputTwo.format("%-10.10s  |  %-6.6s  |  %-10.10s  |  %-5.5s  |  %-6.6s  |  %-9.9s", "first", "middle", "last", "bank", "bankID", "balance");
        outputTwo.println();
        outputTwo.println("-----------------------------------------------------------------------");
    }

    // method to output to file
    protected void outputFile(Person person, BankInfo bankInfo) {
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
        firstName = person.getFirstName();
        middleName = person.getMiddleName();
        lastName = person.getLastName();

        // if the second bank name is not null, it means the users have two bank accounts
        if(bankInfo.getBankTwoName() != null) {
            // initializing variables with getter methods to avoid longer getter method names
            bankOne = bankInfo.getBankOneName();
            bankTwo = bankInfo.getBankTwoName();
            accountNumOne = bankInfo.getBankOneNumber();
            accountNumTwo = bankInfo.getBankTwoNumber();
            accountBalOne = bankInfo.getBankOneBalance();
            accountBalTwo = bankInfo.getBankTwoBalance();

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
            bankOne = bankInfo.getBankOneName();
            accountNumOne = bankInfo.getBankOneNumber();
            accountBalOne = bankInfo.getBankOneBalance();
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
}
