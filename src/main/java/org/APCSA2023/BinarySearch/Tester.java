package org.APCSA2023.BinarySearch;

import java.util.ArrayList;

public class Tester {
    public static void main(String[] args) {
        ArrayList<String> months = new ArrayList<>();

        MonthsHelper.fillMonths(months);

        MonthsHelper.sortMonths(months);

        for(String i: months) {
            System.out.println(i);
        }

    }
}
