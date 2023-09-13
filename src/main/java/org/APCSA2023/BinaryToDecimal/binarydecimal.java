package org.APCSA2023.BinaryToDecimal;

import java.util.Scanner;

import static java.lang.Math.pow;

// this program will take a user's inputted value and convert a binary to a decimal, or a decimal to a binary
// *unfinished
public class binarydecimal implements BinaryAndDecimalHelper{
    public static void main(String[] args) {
        Scanner initialInput = new Scanner(System.in);
        printText("Please enter: ");
        String userChoice = initialInput.next();
        if(userChoice.equals("binary"))
            handleBinaryToDecimal();
        else if (userChoice.equals("decimal"))
            handleDecimalToBinary();
        else
            printText("No.");
    }
    private static void printText(String toPrint) {
        System.out.println(toPrint);
    }

    private static void handleBinaryToDecimal() {
        BinaryAndDecimalHelper.debugMsg("Inside handle binary to decimal");
        int binaryCombo = 2;
        Scanner binaryInput = new Scanner(System.in);
        printText("Please enter binary digits: ");
        int binaryDigits = binaryInput.nextInt();

        int arrOfBinary[] = BinaryAndDecimalHelper.digitBreaker(binaryDigits, BinaryAndDecimalHelper.digitCounter(binaryDigits));
        int i;
        int result = 0;

        for(i = 0; i < arrOfBinary.length; i++) {
            result += (arrOfBinary[i]) * (pow(binaryCombo, i));
        }
        System.out.println(result);
    }

    private static void handleDecimalToBinary() {
        Scanner decimalInput = new Scanner(System.in);
        int decimalDigits = decimalInput.nextInt();


    }
}
