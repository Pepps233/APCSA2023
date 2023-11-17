package org.APCSA2023.BankInformation;

/*
 * This class will take the individual lines from the input file and break them down to store them into objects
 */
public class FormatObject {
    /*
     * Params: individual file line
     * Returns: new Person object
     */
    public static Person instantiatePerson(String inputString) {
        // splits the individual file line with delimiters "BUS or BOC", or both
        String[] individualPersonInfo = inputString.split("BUS | BOC");
        /*
         * Params: the first index of the split string
         * Returns: boolean, if user has middle name
         * Explanation: Since the individual line is split through "BUS", "BOC", the first index must contain the name
         * information, while the second index contains bank number and balance
         */
        boolean hasMiddleName = hasMiddleName(individualPersonInfo[0]);
        // split the name information by spaces once more to obtain the firstName, middleName(if any), and lastname in order
        individualPersonInfo = individualPersonInfo[0].split(" ");
        // if the user has a middle name, return the first name, middle name, and last name
        if (hasMiddleName) return new Person(individualPersonInfo[0], individualPersonInfo[1], individualPersonInfo[2]);
        // if the user has no middle name, return the first name and last name only
        if (!hasMiddleName) return new Person(individualPersonInfo[0], individualPersonInfo[1]);
        // else, return null on all properties (debug)
        return new Person(null, null, null);
    }
    /*
     * Params: individual file line
     * Returns: new BankInfo object
     */
    public static BankInfo instantiateBankInfo(String inputString) {
        // local variables to hold data that will be passed into the constructor of BankInfo
        String bankNameOne, bankNameTwo;
        int accountNumberOne, accountNumberTwo;
        double accountOneBalance, accountTwoBalance;
        // if the string contains BOC, and not BUS => user is using BOC
        if(inputString.contains("BOC") && !inputString.contains("BUS")) {
            // split the line with regex BOC
            String[] splitString = inputString.split("BOC");
            /*
             * If we split the line with regex "BOC", the first index must include information on the bank holder's name,
             * the second index would be the bank id, followed by the bank balance.
             * Split the bank information furthermore, through trim, so the left and right side of the line does
             * not contain spaces, then split the line with regex "\\s" in case there are trailing spaces
             */
            String[] temporaryStringArrayOne = splitString[1].trim().split("\\s");
            bankNameOne = "BOC";
            // since the line is split, the first index must be the account number while the second is the balance
            accountNumberOne = Integer.parseInt(temporaryStringArrayOne[0]);
            accountOneBalance = Double.parseDouble(temporaryStringArrayOne[1]);
            // return newly instantiated BankInfo object
            return new BankInfo(bankNameOne, accountNumberOne, accountOneBalance);
        }
        // if the string contains BUS, and not BOC => user is using BUS
        if(inputString.contains("BUS") && !inputString.contains("BOC")) {
            // split string with BUS as regex
            String[] splitString = inputString.split("BUS");
            // split array so index 0 holds account number, and index 1 holds balance
            String[] temporaryStringArrayOne = splitString[1].trim().split("\\s");

            bankNameOne = "BUS";
            // parse the account number and balance from their string state into integers and doubles
            accountNumberOne = Integer.parseInt(temporaryStringArrayOne[0]);
            accountOneBalance = Double.parseDouble(temporaryStringArrayOne[1]);
            // return newly instantiated BankInfo
            return new BankInfo(bankNameOne, accountNumberOne, accountOneBalance);
        }
        // if string contains BOC and string contains BUS => user is using both BOC and BUS
        if(inputString.contains("BOC") && inputString.contains("BUS")) {
            // split the string using regex BOC and BUS
            String[] splitString = inputString.split("BOC | BUS");
            /*
             * The string would be split up into three portions, the name information portion, the first bank portion,
             * followed by the second bank portion. Operations done on last two portions to extract the information out
             * onto two separate string arrays. Both array's 0 index will hold their bank id, and their 1 index will hold
             * balance
             */
            String[] temporaryStringArrayOne = splitString[1].split("\\s");
            String[] temporaryStringArrayTwo = splitString[2].trim().split("\\s");

            // user using two banks, so two bank names
            bankNameOne = "BOC";
            bankNameTwo = "BUS";
            // extract necessary information from the array and store them into variables
            accountNumberOne = Integer.parseInt(temporaryStringArrayOne[0]);
            accountOneBalance = Double.parseDouble(temporaryStringArrayOne[1]);
            accountNumberTwo = Integer.parseInt(temporaryStringArrayTwo[0]);
            accountTwoBalance = Double.parseDouble(temporaryStringArrayTwo[1]);
            // return newly created BankInfo
            return new BankInfo(bankNameOne, accountNumberOne, accountOneBalance, bankNameTwo, accountNumberTwo, accountTwoBalance);
        }
        // if user's bank information does not fit above, pass in nulls and 0s (debug)
        return new BankInfo(null, 0, 0, null, 0, 0);
    }
    private static boolean hasMiddleName(String string) {
        // if the passed in string has a length of 3, it means that it has a middle name, else, it does not
        String[] array = string.split(" ");
        return array.length == 3;
    }
}
