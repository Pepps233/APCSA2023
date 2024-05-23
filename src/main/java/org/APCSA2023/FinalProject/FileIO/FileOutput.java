package org.APCSA2023.FinalProject.FileIO;

import org.APCSA2023.FinalProject.Accounts.BankAccount;
import org.APCSA2023.FinalProject.Constants.Constants;

import java.io.FileWriter;
import java.io.IOException;

public class FileOutput implements FileIO {

    public static void printRawList() {
        for (String i : Constants.PRE_PROCESSED_STRINGS) {
            System.out.println(i);
        }
    }

    public static void printProcessedList() {
        for (BankAccount i : Constants.PROCESSED_OBJECTS) {
            System.out.println(i.toString());
        }
        System.out.println("\n" + "------------------------------" + "\n");
    }

    public static void outputToFile() {
        try {
            FileWriter myWriter = new FileWriter("output.txt");
            for (BankAccount ba : Constants.PROCESSED_OBJECTS) {
                myWriter.write(ba.toString());
                myWriter.write("\n");
            }
            myWriter.close();
            System.out.println("successfully outputted to file!");
        } catch (IOException e) {
            System.out.println("An error occurred while outputting to file");
            e.printStackTrace();
        }
    }

    @Override
    public void process() {

    }
}
