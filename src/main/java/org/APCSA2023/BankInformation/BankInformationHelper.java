package org.APCSA2023.BankInformation;

import java.io.*;
import java.util.Scanner;

public class BankInformationHelper {
    // ReadIn object => using for late initialize
    private static ReadIn read = null;
    // WriteOut object => using for late initialize
    private static WriteOut output = null;
    private Person person;
    private BankInfo bankInfo;
    public BankInformationHelper() throws FileNotFoundException {
        // late init objects are now initialized
        read = new ReadIn();
        output = new WriteOut();
    }
    // method to call method from read class to read input
    // argument: scanner initialized in constructor method, and current object
    protected void readFile(Scanner scanner) {read.readInputFile(scanner, this);}
    protected void outputFile() {output.outputFile(person, bankInfo);}
    // get directory path for input file
    // returns: new file initialized to the user inputted path
    protected static File getInputDirectoryPath() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter directory path for input file: ");
        String path = sc.nextLine();
        return new File(path);
    }
    // sets directory path in WriteOut class
    protected void getOutputDirectoryPath() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first directory path for output file: ");
        String pathOne = sc.nextLine();
        System.out.println("Enter second directory path for output file: ");
        String pathTwo = sc.nextLine();

        PrintWriter outputOne = null, outputTwo = null;
        try {
            // create a new FileWriter object using the first desired directory
            FileWriter fw = new FileWriter(pathOne);
            // PrintWriter object created with the previously created FileWriter as the argument
            outputOne = new PrintWriter(fw);
            // setting FileWriter object to use the second desired directory
            fw = new FileWriter(pathTwo);
            // PrintWriter object created with the FileWriter that holds the second desired directory
            outputTwo = new PrintWriter(fw);
        } catch (IOException e) {
            // debug
            System.out.println("Error: " + e);
        }
        output.setOutputFiles(outputOne, outputTwo);
    }
    // this method receives the formatted objects
    protected void setFormattedObject(Person person, BankInfo bankInfo) {
        this.person = person;
        this.bankInfo = bankInfo;
    }
    protected void setOutputStyle() {
        output.setOutputCategories();
    }
    protected void closeOutputFiles()  {
        output.closeFiles();
    }
}
