package org.APCSA2023.StudentAverages;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class StudentAverages {
    public static void main(String[] args) throws IOException {
        File inputFile;
        // scanner to handle user inputs
        Scanner inputScanner = new Scanner(System.in);
        // initialize ReadFile obj to null, so doesn't invoke compiler error
        ReadFile readFileHandler = null;
        System.out.println("Enter input file path: ");
        // initializes inputFile with valid directory address
        inputFile = new File(inputScanner.nextLine().trim());
        try {
            // *try* creating new ReadFile instance and assign to obj
            readFileHandler = new ReadFile(inputFile);
        } catch (FileNotFoundException e) {
            // debug message
            System.out.println("Error: " + e);
        }
        System.out.println("Enter output file name (excluding extensions): ");
        // gets file name and ends with txt format
        String fileName = inputScanner.nextLine().trim() + ".txt";
        FileWriter myFile = ReadFile.createOutputFile(fileName);
        // outputs input file
        System.out.println("------------Input File------------");
        readFileHandler.printFileContent();
        // outputs content to output file
        System.out.println("------------Output------------");
        readFileHandler.output(myFile);
        // calls close file method => closes the scanner within ReadFile class
        readFileHandler.closeScanner();
        // closes scanner and file object initialized within main
        closeAll(inputScanner, myFile);
    }
    public static void closeAll(Scanner inputScanner, FileWriter myFile) throws IOException {
        inputScanner.close();
        myFile.close();
    }
}
