package org.APCSA2023.Sorting;

public class QuickSort {
    public static int[] quickSort(int[] arr, int start, int end) {
        /*
         * if the starting index is not greater than the ending index, means that it is still not sorted.
         * Eventually, the start will be the same index as end due to reaching the last index, but since we are
         * Passing in index+1 and index-1, we need to check with greater than.
        */
        if(!(start > end)) {
            /* first, sort the array and get the index of where the pivot is (now we can separate the array into two) */
            int index = getPivotIndex(arr, start, end);
            /*
            * for the first subarray, we will recursively call quickSort with the array, starting (0), and the ending,
            * which is the pivot index -1 (we don't want to include the pivot)
            */
            quickSort(arr, start, index-1);
            /*
            * for the second subarray, we will recursively call quickSort with the array, starting point as pivot
            * index +1 (we don't want to include the pivot), and the ending (size of the array -1)
            */
            quickSort(arr, index+1, end);
        }
        // finally, we will return the sorted portions until it adds up to our final sorted array
        return arr;
    }
    private static int getPivotIndex(int[] arr, int start, int end) {
        // setting pivotValue to the right
        int pivotValue = arr[end];
        // temporary integer for swapping purposes
        int temp;
        // i will be used for counting purposes
        int i = start;
        // j will be used for swapping the elements
        int j = i - 1;

        while(i < end) {
            // if current index is less than pivot value
            if(arr[i] < pivotValue) {
                // increment j
                j++;
                // swap the two elements of i and j
                /*
                * since j will always be behind i, if arr[i] is less than pivot value, we will just move that value
                * backwards and move the greater value up
                */
                temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }

            /*
            * if the last index is reached, we will swap it with the j+1 to make j+1 the pivot point
            */
            if(i + 1 == end) {
                temp = arr[j+1];
                arr[j+1] = arr[i+1];
                arr[i+1] = temp;
            }
            i++;
        }
        // this is the index of the pivot value
        return j+1;
    }
}
