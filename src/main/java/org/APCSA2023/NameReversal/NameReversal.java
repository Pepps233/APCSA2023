// This program takes in user inputted name, and reverses it.
// 10/2/2023

package org.APCSA2023.NameReversal;

import java.util.Scanner;

public class NameReversal {
    public static void main(String[] args) {
        Scanner inputSC = new Scanner(System.in);
        String input;
        System.out.println("Enter name: ");
        input = inputSC.nextLine();
        String reversedName = "";

        for(int i = input.length() -1; i >= 0; i--) {
            reversedName += input.substring(i, i+1);
        }
        reversedName.toLowerCase();
        System.out.println("Reversed name: " + reversedName);
    }
}
