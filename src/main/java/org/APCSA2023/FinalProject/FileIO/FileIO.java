package org.APCSA2023.FinalProject.FileIO;

import org.APCSA2023.FinalProject.Constants.Constants;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public interface FileIO {
    default void readIn() {
        try {
            File myObj = new File(Constants.FILE_PATH);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                Constants.PRE_PROCESSED_STRINGS.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while opening file");
            System.out.println("Try an another file");
            e.printStackTrace();
        }
    }

    void process();
}
