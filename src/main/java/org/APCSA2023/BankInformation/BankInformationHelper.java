package org.APCSA2023.BankInformation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BankInformationHelper {
    // static list to hold Person objects
    public static ArrayList<Person> personArrayList;
    // static list to hold BankInfo objects
    public static ArrayList<BankInfo> bankInfoArrayList;
    // scanner initialized to the user inputted file
    private Scanner inputFileScanner;
    // ReadIn object => using for late initialize
    private ReadIn read;
    // WriteOut object => using for late initialize
    private WriteOut output;
    public BankInformationHelper(File inputFile, ArrayList<Person> person, ArrayList<BankInfo> bank) throws FileNotFoundException {
        // setting static lists to lists passed in
        personArrayList = person;
        bankInfoArrayList = bank;
        // initialize scanner
        this.inputFileScanner = new Scanner(inputFile);
        // late init objects are now initialized
        read = new ReadIn();
        output = new WriteOut();
    }
    // method to call method from read class to read input
    // argument: scanner initialized in constructor method
    protected void readFile() {read.readInputFile(inputFileScanner);}
    // method to call method from output file class to output
    protected void outputFile() {output.outputFile();}
    // get directory path for input file
    // returns: new file initialized to the user inputted path
    protected static File getInputDirectoryPath() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter directory path for input file: ");
        String path = sc.nextLine();
        return new File(path);
    }
    // get directory path for two output files
    // returns: array of two directory paths
    protected static String[] getOutputDirectoryPath() {
        String[] outputDirectoryPaths = new String[2];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first directory path for output file: ");
        String pathOne = sc.nextLine();
        outputDirectoryPaths[0] = pathOne;
        System.out.println("Enter second directory path for output file: ");
        String pathTwo = sc.nextLine();
        outputDirectoryPaths[1] = pathTwo;

        return outputDirectoryPaths;
    }
}
