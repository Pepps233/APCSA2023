// Jiale Yu
// 3/22/24
// AP Comp Sci Binary Search

package org.APCSA2023.BinarySearch;

import java.util.ArrayList;
import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        ArrayList<String> months = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        String inputMonth;

        MonthsHelper.fillMonths(months);

        MonthsHelper.sortMonths(months);

        System.out.println("---------------Sorted Months---------------");
        for(String i: months) {
            System.out.println(i);
        }
        System.out.println("-------------------------------------------");
        do {
            System.out.print("Enter month ('stop' to terminate): ");
            inputMonth = input.next();
            System.out.println("Searching for " + inputMonth + "...");
            int index = MonthsHelper.monthBinarySearch(months, inputMonth);
            if(index != -1) {
                System.out.println(inputMonth + " was found at index: " + index);
            }
            else {
                System.out.println(inputMonth + " was not found: " + index);
            }
        } while(!inputMonth.equals("stop"));
    }
}
