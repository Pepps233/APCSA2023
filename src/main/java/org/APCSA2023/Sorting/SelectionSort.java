package org.APCSA2023.Sorting;

import java.util.ArrayList;

public class SelectionSort {
    public static ArrayList<Integer> selectionSort(ArrayList<Integer> arrayList) {
        int size = arrayList.size();
        // holds the smallest integer
        int smallest;
        // holds the index of the smallest integer
        int indexOfSmallest = 0;
        // holds current integer, or integer in place of index i
        int current;
        // for counting purposes
        int j;

        for(int i = 0; i < size; i++) {
            // set smallest to index i
            smallest = arrayList.get(i);
            // hold onto the current integer in index i
            current = arrayList.get(i);
            // add 1 to i for j so it starts searching from next value
            j = i+1;
            // assuming each search is false (we don't find smallest integer) so if nothing is found, we do not remove or add
            boolean foundSmallest = false;

            // if j is less than the arraylist size
            while(j < size) {
                // continue to check current element in index i with next elements
                if(smallest > arrayList.get(j)) {
                    // set the new smallest integer
                    smallest = arrayList.get(j);
                    // hold onto the index of the smallest integer (for swapping purposes)
                    indexOfSmallest = j;
                    // set to true so next portion could execute
                    foundSmallest = true;
                }
                // increment j for next index
                j++;
            }
            if(foundSmallest) {
                // put the smallest integer in place of the old (this pushes everything back by one index)
                arrayList.add(i, smallest);
                // put the current element in index i to index of the smallest (swapping and this pushes back by one)
                arrayList.add(indexOfSmallest, current);
                // remove the i + 1 index because things are pushed back by one
                arrayList.remove(i+1);
                // remove smallest index + 1 because things are pushed back by one
                arrayList.remove(indexOfSmallest+1);
            }
        }
        return arrayList;
    }
}
