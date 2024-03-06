package org.APCSA2023.Sorting;

import java.util.ArrayList;

public class InsertionSort {
    public static ArrayList<Integer> insertionSort(ArrayList<Integer> arrayList) {
        int size = arrayList.size();
        // holds current element
        int current;
        // counter
        int j;

        for(int i = 1; i < size; i++) {
            // set current to first element, then advances forward
            current = arrayList.get(i);
            // to compare the last elements, set j to i - 1
            j = i - 1;
            /*
            * while j is bigger than or equal to 0, no array index out of bounds error
            * if current element is smaller than last one, push the element back and decrement i to check
            * element before it again
            */
            while((j >= 0) && (current < arrayList.get(j))) {
                arrayList.add(j, current);
                arrayList.remove(j+2);
                j--;
            }
        }
        return arrayList;
    }
}
