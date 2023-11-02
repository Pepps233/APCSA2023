package org.APCSA2023.BankInformation;

public class Person {
    private String firstName;
    private String lastName;
    private String middleName;

    // overloading two constructors for more flexible instantiation
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.middleName = null;
        this.lastName = lastName;
    }
    public Person(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }
    // getter methods
    public String getFirstName() {return firstName;}
    public String getMiddleName() {return middleName;}
    public String getLastName() {return lastName;}
}
