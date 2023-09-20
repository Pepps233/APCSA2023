package org.APCSA2023.ReverseStringTwo;

import java.util.Scanner;

// this program is another solution to reversing letters but not the overall order using delimiters
public class ReverseStringTwo {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Enter string: ");
        String stringToReverse = inputScanner.nextLine();
        Scanner stringToReverseScanner = new Scanner(stringToReverse);
        String stringToPrint = "";
        String tempString = "";
        String tempStringReverse = "";

        // separates string using white space
        stringToReverseScanner.useDelimiter(" ");

        while(stringToReverseScanner.hasNext()) {
            int ct;
            // store next separated string into temp variable
            tempString = stringToReverseScanner.next();

            // go through the string and reverse the word and store into temp string
            for(ct = tempString.length()-1; ct >= 0; ct--) {
                tempStringReverse += tempString.charAt(ct);
            }
            // add the temporary reversed word and a white space into the string to print
            stringToPrint += tempStringReverse + ' ';
            // reset the temporary string
            tempStringReverse = "";
        }
        System.out.println(stringToPrint);
    }
}
