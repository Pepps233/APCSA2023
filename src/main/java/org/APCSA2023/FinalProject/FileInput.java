package org.APCSA2023.FinalProject;

public class FileInput implements FileIO {
    public void processInputFile() {
        readIn();
    }

    @Override
    public void process() {
        /** Processing pre-processed array list of strings
         * 1. Take the array list and split each element and store them in an array
         * 2. Take individual elements within the new array and convert them to the argument types of bank account classes
         * 3. Instantiate those class objects
         * 4. Store them into a new array list
         * 5. Clear the Pre-Processed array list because we already processed everything (to save memory)
         * 6. Run-time complexity: O(n)^2
         */
        String tempString;
        String[] tempArr;
        for(String i: Constants.PRE_PROCESSED_STRINGS) {
            tempString = i;
            tempArr = tempString.split(" ");
            String name = tempArr[0] + " " + tempArr[1];
            double balance = Double.parseDouble(tempArr[2]);
            BankAccount ba;
            if (tempArr[3].equals("Checking")) {
                ba = new CheckingAccount(name, Constants.ACCOUNT_NUMBER, balance);
            } else {
                ba = new SavingsAccount(name, Constants.ACCOUNT_NUMBER, balance);
            }
            Constants.ACCOUNT_NUMBER++;
            Constants.PROCESSED_OBJECTS.add(ba);
        }
        Constants.PRE_PROCESSED_STRINGS.clear();
    }
}
