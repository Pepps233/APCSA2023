package org.APCSA2023.MatrixStuff;

public class Tester {
    public static void main(String[] args) {
        // preset 2d arrays

        int[][] a = {
                {1, 2, -2, 0},
                {-3, 4, 7, 2},
                {6, 0, 3, 1} };
        int[][] b = {
                {-1,3},
                {0, 9},
                {1, -11},
                {4,-5} };

        // method call
        int[][] c = MatrixMult.mult(a, b);

        // counter to keep index during loop, ct standing for counter
        int ct = 0;

        for(int[] i: c) {
            for(int j: i) {
                // print out the number and increment ct
                System.out.print(j + " ");
                ct++;

                // if at the end of row, move to next row and make a new line
                if(ct == b[0].length)
                {
                    System.out.println();
                    ct = 0;
                }
            }
        }
    }
}
