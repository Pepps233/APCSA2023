package org.APCSA2023.StudentAverages;

import java.io.File;
import java.io.FileNotFoundException;

public class StudentAverages {
    public static void main(String[] args) throws FileNotFoundException {
        // directory path to input file
        File inputFile = new File("src/main/java/org/APCSA2023/StudentAverages/StudentScores.in");
        // initialize ReadFile obj to null, so doesn't invoke compiler error
        ReadFile obj = null;
        try {
            // *try* creating new ReadFile object and assign to obj
            obj = new ReadFile(inputFile);
        } catch (FileNotFoundException e) {
            // debug message
            System.out.println("Error: " + e);
        }
        // calls output method => outputs the student name, and their rounded average
        System.out.println("------------Input File------------");
        obj.printFileContent();
        System.out.println("------------Output------------");
        obj.output();
        // calls close file method => closes the scanner
        obj.closeFile();
    }
}
