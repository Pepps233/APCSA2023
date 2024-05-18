package org.APCSA2023.FinalProject;

public class BankHelper {

    /**
     * Insertion sort to sort the bank accounts by balance
     */
    public static void sortByBalance() {
        int size = Constants.PROCESSED_OBJECTS.size();
        // holds current element
        double currentBalance;
        BankAccount currentAccount;
        // counter
        int j;

        for(int i = 1; i < size; i++) {
            // set current to first element, then advances forward
            currentAccount = Constants.PROCESSED_OBJECTS.get(i);
            currentBalance = currentAccount.getBalance();
            // to compare the last elements, set j to i - 1
            j = i - 1;
            /*
             * while j is bigger than or equal to 0, no array index out of bounds error
             * if current element is smaller than last one, push the element back and decrement i to check
             * element before it again
             */
            while((j >= 0) && (currentBalance < Constants.PROCESSED_OBJECTS.get(j).getBalance())) {
                Constants.PROCESSED_OBJECTS.add(j, currentAccount);
                Constants.PROCESSED_OBJECTS.remove(j+2);
                j--;
            }
        }
    }

    /**
     * Insertion sort to sort the bank accounts by balance
     */
    public static void sortByAccountNum() {
        int size = Constants.PROCESSED_OBJECTS.size();
        // holds current element
        int currentAccNum;
        BankAccount currentAccount;
        // counter
        int j;

        for(int i = 1; i < size; i++) {
            // set current to first element, then advances forward
            currentAccount = Constants.PROCESSED_OBJECTS.get(i);
            currentAccNum = currentAccount.getAccountNum();
            // to compare the last elements, set j to i - 1
            j = i - 1;
            /*
             * while j is bigger than or equal to 0, no array index out of bounds error
             * if current element is smaller than last one, push the element back and decrement i to check
             * element before it again
             */
            while((j >= 0) && (currentAccNum < Constants.PROCESSED_OBJECTS.get(j).getAccountNum())) {
                Constants.PROCESSED_OBJECTS.add(j, currentAccount);
                Constants.PROCESSED_OBJECTS.remove(j+2);
                j--;
            }
        }
    }

    /**
     * Binary search the account numbers and find the index of the account in the array list
     */
    public static int searchAccount(int key) {
        int highest = Constants.PROCESSED_OBJECTS.size() -1;
        int lowest = 0;
        int middleIndex;
        int middleAccNumber;
        middleIndex = getMiddleIndex(lowest, highest);
        middleAccNumber = Constants.PROCESSED_OBJECTS.get(middleIndex).getAccountNum();

        /* use <= b/c if arr only contains 2 elements, it will not be checked */
        while(lowest <= highest) {
            // if the target string is found
            if(key == middleAccNumber) {
                return middleIndex;
            }
            // if target string is greater than middle string
            if(key > middleAccNumber) {
                // move lowest to right of middle and continue searching
                lowest = middleIndex + 1;
            }
            // if target string is less than middle string
            else {
                // move highest to left of middle and continue searching
                highest = middleIndex - 1;
            }
            middleIndex = getMiddleIndex(lowest, highest);
            middleAccNumber = Constants.PROCESSED_OBJECTS.get(middleIndex).getAccountNum();
        }
        // did not find the target
        return -1;
    }

    private static int getMiddleIndex(int one, int two) {
        return (one + two) / 2;
    }
}
