package org.APCSA2023.CABankAccount;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class OutputHandler {

    private BankAccount bankAccount;

    private PrintWriter printWriter;

    private FileWriter fileWriter;

    public OutputHandler(BankAccount bankAccount) throws IOException {
        this.bankAccount = bankAccount;
        /* instantiates output file location */
        fileWriter = new FileWriter("src/main/java/org/APCSA2023/CABankAccount/output.out");
        printWriter = new PrintWriter(fileWriter);
    }
    public void printInformation() {
        this.bankAccount.printStateToFile(printWriter);
    }

    public void closeOutputFile() {
        printWriter.close();
    }
}
