# hw1- Manual Review

The homework will be based on this project named "Expense Tracker",where users will be able to add/remove daily transaction. 

## Compile

To compile the code from terminal, use the following command:
```
cd src
javac ExpenseTrackerApp.java
java ExpenseTrackerApp
```

You should be able to view the GUI of the project upon successful compilation. 

## Java Version
This code is compiled with ```openjdk 17.0.7 2023-04-18```. Please update your JDK accordingly if you face any incompatibility issue.


## New files
We have added 3 new files as difnied by the 2nd part. The additions are as follows:

 - `src/controller/TransactionFilter`: This is a interface that defines the filtering class. The actual filtering functions implement this interface. 
 - `src/controller/AmountFilter`: This is a class that is used to filter based on amount. We have the following 2 functions:
    -  `AmountFilter`: Takes in a double, that is the amount on which we want to filter.
    - `filter`: Takes in List of Transaction called transactions. It returns a filtered list if the input amount is valid, and null otherwise.
 - `src/controller/CategoryFilter`: This is a class that is used to filter based on category. We have the following 2 functions:
    -  `CategoryFilter`: Takes in a string, that is the category on which we want to filter.
    - `filter`: Takes in List of Transaction called transactions. It returns a filtered list if the input category is valid, and null otherwise.
 - `test/TestExample` : This file contains the test cases to test the application. It contains 5 test cases for input validation, transaction validation and filtering validation.


## Updated Files
We have updated 3 files as well:
 - `ExpenseTrackerController.java`: Added the apply filter function that takes in a string filterType, a string category, and a double amount. It returns a filter or displays an error. 
 - `ExpenseTrackerView.java`: Added all the elements to view. 
  - `ExpenseTrackerApp.java`: Added the functionality to the apply filter button. 