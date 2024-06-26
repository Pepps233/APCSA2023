# Commands:

## info:

pep firstName lastName accountBalance accountType

## path:

absolute path of a file to open and process

"default": opens default file

## request:

"end": ends the program

"show": prints the output in the terminal

"output": outputs all processed contents onto an output file

"sort balance": sort the accounts by balance in ascending order

"sort number": sort the accounts by account number in ascending order

"clear": clears all pre-processed and processed contents

"pep accountNum -d/-w amount": using the account number, deposit or withdraw money


# For grading
### Interface: FileIO
### Inheritance: BankAccount (superclass) and CheckingAccount, Savings Account (both subclasses)
### Sorting: BankHelper (insertion sort)
### R/W File: FileIO and FileInput, FileOutput (both implement FileIO)
### ArrayList: Constants (pre-processed array list and processed array list)
### Binary Search: BankHelper
### User Interface: UIInputHandler
### Tester: Tester
### Input Files: InputFile, InputFileTwo
### Other: BankRequestHandler
