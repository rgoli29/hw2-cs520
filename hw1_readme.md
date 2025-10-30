# hw2- How to Run

The homework will be based on this project named "Expense Tracker",where users will be able to add/remove daily transaction. 

## How to build and test (from Terminal):
1. Make sure that you have Apache Ant installed. Run ```ant``` in the root directory, which contains the build.xml build file.

2. Run ```ant document``` to generate the jdoc folder. In that folder, open the index.html file.

3. Run ```ant compile``` to generate the class files. Compiled classes will be in the bin directory.

4. Run ```ant test``` to compile all unit tests and run them.

## How to run (from Terminal):
After building the project (i.e., running ant), run: ```java -cp bin ExpenseTrackerApp```

## How to clean up (from Terminal):
Run ```ant clean``` to clean the project (i.e., delete all generated files).


## Supported Features

1. Add Transaction: The user can input an amount and category for a particular transaction. There is also a button which when clicked, creates a transaction based on the user inputs and stores it in a list which is displayed to the user.
2. Filter Transactions: The user can filter the list of transactions based on either a category or amount. Only one filter can be applied at a time. There is a button which is used to apply the filter. The amount and catergory can be filled in the same boxes used to adding a transaction.