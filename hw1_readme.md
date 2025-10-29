# hw1- Manual Review

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

## Code Modification

Create a file named ```InputValidation.java```  to validate the ```amount``` and ```category``` field of this app. Some hints are as follows:
1. The ```amount``` should be greater than 0 and less than 1000. 
2. It should be a valid number. 
3. The ```category``` should be a valid string input from the following list: "food", "travel", "bills", "entertainment", "other" .
4. You should display error messages on the GUI and not accept the invalid input. . You should throw an appropriate exception. 
5. Update the ExpenseTrackerApp.java with the input validation steps for adding transaction.

## Manual Review
Here are some examples of satisfying ```non-functional`` requirements:

1. Portability: The project uses simple Java files and also includes a build.xml file for ant. This allows other systems to run the application as long as they have Java and ant installed. In our case, we ran this code on a Mac and Windows, and we were able to use the same commands to run the code.

2. Testability: The project has an aspect of testability to it. We have a separate ExpenseTrackerTest.java file, which we can run using ant test, where we can add tests for new features and make sure that the application is working as intended.

3. Understandability: External documentation (such as a README file) improves program understanding. This app’s README file helps users and developers by providing the build instructions (Point taken from the file’s README).


Here are some examples of violating ```non-functional``` requirements:

1. Security: There is no authentication, authorization, or data protection in this application. This is a violation of basic security requirements, which are vital for financial applications. The data is all stored in a public ExpenseTrackerView class in an ArrayList. This can be accessed and changed by another application or function, or class, which should not have access to it. To fix this, we need to regulate access to the data. 

2. Scalability: This is a simple application meant to run on a singular machine. There is no way to handle multiple users at the same time which limits the scalability. Once we run the command, the application launches locally, and there is no way to switch between users, as seen in the ExpenseTrackerView.java file. If multiple users want to access the application, they can’t. We would want to implement a feature where we let multiple users switch between their profiles and recover their data.

3. Persistence/Recoverability: This is a violation, as data does not outlive the process that created it. There is also no way to store the added transactions. Once the application is closed, we lose all progress. Again, as seen in the ExpenseTrackerView.java file, we can implement a simple data storage strategy. Maybe even as simple as writing to a JSON file. 

4. Modularity: The app does not apply the MVC architecture pattern. The app should declare the following packages and their classes: model, view, and controller.(Point taken from the file’s README).

## Supported Features

1. Add Transaction: The user can input an amount and category for a particular transaction. There is also a button which when clicked, creates a transaction based on the user inputs and stores it in a list which is displayed to the user.

## Understandibility
For the understandability section, we will be inspecting your git log. You should include either the .git folder or else a gitLog.(pdf | txt).