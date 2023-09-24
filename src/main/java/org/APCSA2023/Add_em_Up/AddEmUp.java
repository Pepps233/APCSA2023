/*
    this program will take in a string input from the terminal in format of: x +- y +- z
    and print out the sum
 */

package org.APCSA2023.Add_em_Up;

import java.util.Scanner;

public class AddEmUp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter: ");
        String inputString = scanner.nextLine();
        String tempString = "";
        int accumulatedTotal = 0;

        for(int i = 0; i < inputString.length(); i++) {
            // if character is plus
            if(inputString.charAt(i) == '+') {
                // create new line before and after the plus sign and put plus sign in middle
                tempString += "\n + \n";
            }
            else if(inputString.charAt(i) == '-') {
                // create new line before and after the minus sign and put minus sign in middle
                tempString += "\n - \n";
            }
            else
            {
                // if character not plus, just addon with the chars
                tempString += inputString.charAt(i);
            }
        }
        Scanner sc = new Scanner(tempString);
        String tempSCHolder;
        while(sc.hasNext()) {
            // temporary string for holding the .next() value so the scanner doesn't advance when we compare or use .nextInt()
            tempSCHolder = sc.next();
            // if temporary string equals to plus
            if(tempSCHolder.equals("+")) {
                accumulatedTotal += sc.nextInt();
            }
            // if temporary string equals to minus
            else if (tempSCHolder.equals("-")) {
                accumulatedTotal -= sc.nextInt();
            }
            // if current advancement does not equal to plus sign, or contains minus sign (just a positive integer)
            if(!(tempSCHolder.equals("+")) && !(tempSCHolder.contains("-"))) {
                // create a new scanner to store the value so original scanner doesn't advance when nextInt() is invoked
                Scanner tempSC = new Scanner(tempSCHolder);
                accumulatedTotal += tempSC.nextInt();
            }
            // if current contains a minus sign, but doesn't equal to minus sign (just a negative integer)
            else if(tempSCHolder.contains("-") && !(tempSCHolder.equals("-"))) {
                // create a new scanner to store the value so the original scanner doesn't advance when nextInt() is invoked
                Scanner tempSC = new Scanner(tempSCHolder);
                accumulatedTotal -= tempSC.nextInt();
            }
        }
        System.out.println("total: " + accumulatedTotal);
    }
}
