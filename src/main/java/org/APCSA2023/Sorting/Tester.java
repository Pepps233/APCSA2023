/**
 * Jiale Yu
 * 2/27/2024
 * Sorting Assignment: Insertion, Selection, Quick
 */

package org.APCSA2023.Sorting;

import java.util.ArrayList;
import java.util.Random;

public class Tester {
    public static void main(String[] args) {
        /* arraylist for insertion sort */
        ArrayList<Integer> myArrayList = new ArrayList<>();
        /* arraylist for selection sort */
        ArrayList<Integer> myArrayListTwo = new ArrayList<>();
        Random rand = new Random();
        Random randTwo = new Random();

        /* preset elements for array (quick sort) because random numbers are not reliable */
        int[] myArr = new int[] {10, 2, 8, 7, 6, 5, 4, 3, 2, 6};

        /* generating numbers from 0-99 inclusive for arraylists */
        for(int i = 0; i < 5; i++) {
            myArrayList.add(i, rand.nextInt(100));
            myArrayListTwo.add(i, randTwo.nextInt(100));
        }

        System.out.println("- - - - - - Insertion Sort - - - - - -");
        System.out.println("Original list: ");
        print(myArrayList);
        InsertionSort.insertionSort(myArrayList);
        System.out.println("\n" + "Sorted list: ");
        print(myArrayList);

        System.out.println("\n" + "- - - - - - Selection Sort - - - - - -");
        System.out.println("Original list: ");
        print(myArrayListTwo);
        SelectionSort.selectionSort(myArrayListTwo);
        System.out.println("\n" + "Sorted list: ");
        print(myArrayListTwo);

        System.out.println("\n" + "- - - - - - Quick Sort - - - - - -");
        System.out.println("Original array: ");
        print(myArr);
        QuickSort.quickSort(myArr, 0, myArr.length - 1);
        System.out.println("\n" + "Sorted array: ");
        print(myArr);
        System.out.println();
    }
    public static void print(ArrayList<Integer> arr) {
        for(int i: arr) {
            System.out.print(i + " ");
        }
    }
    public static void print(int[] arr) {
        for(int i: arr) {
            System.out.print(i + " ");
        }
    }
}
