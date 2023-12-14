package org.APCSA2023.MatrixStuff;

public class MatrixMult {
    public static int[][] mult(int[][] a, int[][] b) {
        // assuming dimensions can work and matrices can multiply

        // new dimensions for new 2d array
        int newColumn = a.length;
        int newRow = b[0].length;
        int[][] c = new int[newColumn][newRow];

        // accumulating the product elements
        int accumulation = 0;

        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < b[0].length; j++) {
                for(int k = 0; k < b.length; k++) {
                    accumulation += a[i][k] * b[k][j];
                }
                c[i][j] = accumulation;
                accumulation = 0;
            }
        }
        return c;
    }
}
