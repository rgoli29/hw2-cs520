# hw2

## New files
We have added 3 new files as difnied by the 2nd part. The additions are as follows:

 - `src/controller/TransactionFilter`: This is a interface that defines the filtering class. The actual filtering functions implement this interface. 
 - `src/controller/AmountFilter`: This is a class that is used to filter based on amount. We have the following 2 functions:
    -  `AmountFilter`: Takes in a double, that is the amount on which we want to filter.
    - `filter`: Takes in List of Transaction called transactions. It returns a filtered list if the input amount is valid, and null otherwise.
 - `src/controller/CategoryFilter`: This is a class that is used to filter based on category. We have the following 2 functions:
    -  `CategoryFilter`: Takes in a string, that is the category on which we want to filter.
    - `filter`: Takes in List of Transaction called transactions. It returns a filtered list if the input category is valid, and null otherwise.


