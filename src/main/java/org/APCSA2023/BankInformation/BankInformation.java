package org.APCSA2023.BankInformation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BankInformation {
    public static void main(String[] args) throws FileNotFoundException {
        // method call to get input file directory path
        File inputFile = BankInformationHelper.getInputDirectoryPath();
        // assign null to instance of BankInformationHelper, avoid compiler error
        BankInformationHelper bankInformationHelper = null;
        Scanner scanner = new Scanner(inputFile);
        try {
            // instantiating new BankInformationHelper object
            bankInformationHelper = new BankInformationHelper();
        } catch (FileNotFoundException e) {
            // debugging msg
            System.out.println("Error: " + e);
        }
        // gets the user desired output file directory path
        bankInformationHelper.getOutputDirectoryPath();
        // displays different information categories
        bankInformationHelper.setOutputStyle();

        while(scanner.hasNextLine()) {
            // file reading line by line
            bankInformationHelper.readFile(scanner);
            // outputting line by line
            bankInformationHelper.outputFile();
        }
        // closing output files
        bankInformationHelper.closeOutputFiles();
    }
}
