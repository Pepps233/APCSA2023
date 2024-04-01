package org.APCSA2023.BinarySearch;

import java.util.ArrayList;

public class MonthsHelper {
    public static int monthBinarySearch(ArrayList<String> months, String target) {
        int highest = months.size() -1;
        int lowest = 0;
        int middleIndex;
        String middleString;
        middleIndex = getMiddleIndex(lowest, highest);
        middleString = months.get(middleIndex);

        /* use <= b/c if arr only contains 2 elements, it will not be checked */
        while(lowest <= highest) {
            // if the target string is found
            if(target.compareTo(middleString) == 0) {
                return middleIndex;
            }
            // if target string is greater than middle string
            if(target.compareTo(middleString) > 0) {
                // move lowest to right of middle and continue searching
                lowest = middleIndex + 1;
            }
            // if target string is less than middle string
            else {
                // move highest to left of middle and continue searching
                highest = middleIndex - 1;
            }
            middleIndex = getMiddleIndex(lowest, highest);
            middleString = months.get(middleIndex);
        }
        // did not find the target
        return -1;
    }

    // random filling (can be filled in any way)
    public static void fillMonths(ArrayList<String> months) {
        months.add("August");
        months.add("October");
        months.add("January");
        months.add("June");
        months.add("July");
        months.add("March");
        months.add("May");
        months.add("September");
        months.add("December");
        months.add("April");
        months.add("February");
        months.add("November");
    }

    public static void sortMonths(ArrayList<String> months) {
        for(int i = 0; i < months.size(); i++) {
            for(int j = i + 1; j < months.size(); j++) {
                // if current string is bigger than next string
                if(months.get(i).compareTo(months.get(j)) > 0) {
                    // set temporary string as current string
                    String temp = months.get(i);
                    // change current string into next string: 0, 1 -> 1,1
                    months.set(i, months.get(j));
                    // change next string into temp (old current string): 1,1 -> 1,0
                    months.set(j, temp);
                }
            }
        }
    }

    private static int getMiddleIndex(int one, int two) {
        return (one + two) / 2;
    }
}
