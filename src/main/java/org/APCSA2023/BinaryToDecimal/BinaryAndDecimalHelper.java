package org.APCSA2023.BinaryToDecimal;

public interface BinaryAndDecimalHelper {
    static int digitCounter(int num) {
        int i = 0;
        while(num != 0) {
            num /= 10;
            i++;
        }
       return i;
    }

    static int[] digitBreaker(int num, int size) {
        int i;
        int arr[] = new int[size];
        int placeHolderArr[] = new int[size];
        int ct = size-1;
        for(i = 0; i < size; i++) {
            arr[i] = num % 10;
            num /= 10;
        }
        return arr;
    }

    static void debugMsg(String msg) {
        System.out.println(msg);
    }
}
