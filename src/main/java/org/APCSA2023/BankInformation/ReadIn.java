package org.APCSA2023.BankInformation;

import java.util.Scanner;

public class ReadIn {

    /*
    * method to process and instantiate BankInfo and Person objects and store them into their corresponding
    * list.
    * private person and bankInfo variables are overwritten during each loop iteration to create new objects
    */
    protected void readInputFile(Scanner inputScanner, BankInformationHelper bankInfoHelper) {
        String individualLineProcess;
        // fetches the next line
        individualLineProcess = inputScanner.nextLine();
        // method call to FormatObject class
        BankInfo bankInfo = FormatObject.instantiateBankInfo(individualLineProcess);
        // method call to FormatObject class
        Person person = FormatObject.instantiatePerson(individualLineProcess);
        // Sending formatted object back to BankInformationHelper class for further processing
        bankInfoHelper.setFormattedObject(person, bankInfo);
    }
}
