package org.APCSA2023.StudentAverages;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile {
    private Scanner inputScanner;
    private File inputFile;

    public ReadFile(File inputFile) throws FileNotFoundException {
        // inputFile will be used later for printing out the contents
        this.inputFile = inputFile;
        this.inputScanner = new Scanner(inputFile);
    }
    public void output(FileWriter outputFile) {
        String temporaryString = "";
        // holds the total score of a student
        int totalIndividualScore = 0;
        // parallel array list for name, and average score
        ArrayList<String> nameList = new ArrayList<>();
        ArrayList<Integer> scoreList = new ArrayList<>();
        // holds the number of scores of a student
        int numberOfIndividualScores = 0;
        // initialized as true => if it is the first student name we run into
        boolean firstName = true;

        while(inputScanner.hasNext()) {
            temporaryString = inputScanner.next();

            try {
                // parse string into integer, and add to the total score
                totalIndividualScore += Integer.parseInt(temporaryString);
                // increment number of scores
                numberOfIndividualScores++;
                // if reached eof, add the average score into list
                // if we don't check for eof, the last student's average score will not be recorded
                if(!(inputScanner.hasNext())) scoreList.add(calculateAverage(totalIndividualScore, numberOfIndividualScores));
            } catch(NumberFormatException e) {
                // add the name into list
                nameList.add(temporaryString);
                // if first name reached, do nothing
                if(firstName) {
                    firstName = false;
                }
                // if not first name, add the average into score list, and reset values to 0
                else {
                    scoreList.add(calculateAverage(totalIndividualScore, numberOfIndividualScores));
                    totalIndividualScore = 0;
                    numberOfIndividualScores = 0;
                }
            }
        }
        // outputs information onto both file and console
        printResultFile(nameList, scoreList, scoreList.size(), outputFile);
        printResultConsole(nameList, scoreList, scoreList.size());
        // closes existing scanners within this class
        closeScanner();
    }

    public void closeScanner() {
        inputScanner.close();
    }

    // returns rounded average score
    public int calculateAverage(int total, int count) {
        return Math.round((float)total / count);
    }

    // outputs average score to console
    public void printResultConsole(ArrayList<String> nameList, ArrayList<Integer> scoreList, int size) {
        for (int i = 0; i < size; i++) {
            System.out.println(nameList.get(i) + ", average = " + scoreList.get(i));
        }
    }

    // outputs average score to file
    public void printResultFile(ArrayList<String> nameList, ArrayList<Integer> scoreList, int size, FileWriter file) {
        PrintWriter output = new PrintWriter(file);
        for (int i = 0; i < size; i++) {
            output.println(nameList.get(i) + ", average = " + scoreList.get(i));
        }
        output.close();
    }

    // creates new output file based off name given by user
    public static FileWriter createOutputFile(String fileName) throws IOException {
        FileWriter myFile = new FileWriter(fileName);
        return myFile;
    }

    // outputs the input file
    public void printFileContent() throws FileNotFoundException {
        Scanner printFileScanner = new Scanner(inputFile);
        while(printFileScanner.hasNextLine()) {
            System.out.println(printFileScanner.nextLine());
        }
        printFileScanner.close();
    }

    // switches input file
    public void switchFile(File newInputFile) throws FileNotFoundException {
        this.inputScanner = new Scanner(newInputFile);
    }
}
