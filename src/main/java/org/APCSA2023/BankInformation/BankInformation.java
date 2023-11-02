package org.APCSA2023.BankInformation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class BankInformation {
    public static void main(String[] args) {
        // method call to get input file directory path
        File inputFile = BankInformationHelper.getInputDirectoryPath();
        // assign null to instance of BankInformationHelper, avoid compiler error
        BankInformationHelper bankInformationHelper = null;
        // maps person object to their corresponding banking information
        ArrayList<Person> personArrayList = new ArrayList<>();
        ArrayList<BankInfo> bankArrayList = new ArrayList<>();
        try {
            // instantiating new BankInformationHelper object
            bankInformationHelper = new BankInformationHelper(inputFile, personArrayList, bankArrayList);
        } catch (FileNotFoundException e) {
            // debugging
            System.out.println("Error: " + e);
        }
        // calling readFile method using BankInformationHelper object
        bankInformationHelper.readFile();
        // calling outputFile method using BankInformationHelper object
        bankInformationHelper.outputFile();
    }
}
