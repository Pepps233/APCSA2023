/*
    this program will take in a string input from the terminal in format of: x +- y +- z
    and print out the sum -> uses useDelimiter from Scanner class
 */

// 9/25/23

package org.APCSA2023.Add_em_Up_Two;

import java.util.Scanner;
public class Add_em_Up_Two {
    public static void main(String[] args) {
        // user inputs
        System.out.println("Enter(something like -1 + 1-1+1 -1+1 -1 + 1 - 1 + 1): ");
        Scanner userInput = new Scanner(System.in);
        String input = userInput.nextLine();
        Scanner scanner = new Scanner(input);
        Scanner scannerTwo = new Scanner(input);
        Scanner firstDigitChecker = new Scanner(input);
        String firstDigitCheckerString;
        String temporaryString;
        int total = 0;
        int negativeTotal = 0;

        // delimits and spaces between plus sign and negative sign for first scanner
        scanner.useDelimiter("\\s*\\+\\s*|\\s*-\\s*");
        // delimits only plus signs and spaces on the sides for second scanner
        scannerTwo.useDelimiter("\\s*\\+\\s*");

        // initializing variable to value of first .next() with another scanner
        firstDigitCheckerString = firstDigitChecker.next();

        // if the first .next() equals to a negative sign
        if(firstDigitCheckerString.equals("-")) {
            // then number is negative, and add with next integer
            negativeTotal += firstDigitChecker.nextInt();
        }
        // if number contains negative sign, but does not equal to negative sign -> sign is attached to number
        if(firstDigitCheckerString.contains("-") && !(firstDigitCheckerString.equals("-"))) {
            // substring the first character
            String tempString = firstDigitCheckerString.substring(0, 1);
            // if the character is a negative sign -> meaning the case of x- is eliminated and -x is reserved
            if(tempString.equals("-")) {
                //  parseInt() the string into integer
                int temp = Integer.parseInt(firstDigitCheckerString);
                // since integer will be negative, we absolute value it into positive and store into negative num counter
                negativeTotal += Math.abs(temp);
            }
        }

        // since the first scanner delimited all of plus and minuses, we just add all the numbers together
        while(scanner.hasNextInt()) {
            total += scanner.nextInt();
        }

        // second scanner for handing negatives
        while(scannerTwo.hasNext()) {
            // initializing a temporary string into the value of the first .next() value
            temporaryString = scannerTwo.next();
            // if the string contains negative sign
            if(temporaryString.contains("-")) {
                // create a new scanner and pass in the temporaryString
                Scanner scannerThree = new Scanner(temporaryString);
                // delimit the negative sign and any spaces
                scannerThree.useDelimiter("\\s*-\\s*|\\s");
                // advance so the first number is not read
                scannerThree.next();
                // add to the negative total with the next integer(s)
                while(scannerThree.hasNextInt()) {
                    negativeTotal += scannerThree.nextInt();
                }
            }
        }
        /*
            since all integers were add up before, we need to multiply negativeTotal by 2 to cancel out the added portion
            as well as decrease the needed portion
         */
        negativeTotal *= 2;
        // total subtract 2 times the negative total
        total -= negativeTotal;

        // result
        System.out.println("total: " + total);
    }
}
