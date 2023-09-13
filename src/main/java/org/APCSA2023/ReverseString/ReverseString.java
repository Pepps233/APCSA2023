package org.APCSA2023.ReverseString;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter string: ");
        // taking user input string
        String myString = scanner.nextLine();
        // breaking up user inputted string into array using split() wth deliminator factor of space
        String[] arrayOfString = (myString.split(" "));
        String[] tempString = new String[arrayOfString.length];
        String tempReverseString = "";
        String finalString = "";

        // loop from left to right
        for(int i = 0; i < arrayOfString.length; i++) {
            tempString[i] = arrayOfString[i];
            // function call
            tempReverseString = reverse(tempString[i]);
            /*
                if we are on the last word of the string, we just add the reversed word into our final string, if we
                are not on our final string, we add the reversed string into our fianl string along with a space.
            */
            if(tempString[i] == arrayOfString[arrayOfString.length-1])
                finalString += tempReverseString;
            else
                finalString += tempReverseString + ' ';
        }
        System.out.println(finalString);
    }
    private static String reverse(String toReverse) {
        String toReturn = "";
        // loop from left to right
        for(int i = 0; i < toReverse.length(); i++) {
            /*
                we add individual character from parameter to our stored string.
                ex string: hello
                i = 0: h + ""
                i = 1: e + "h"
                i = 2: l + "eh"
            */
            toReturn = toReverse.charAt(i) + toReturn;
        }
        return toReturn;
    }
}
