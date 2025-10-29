// Implementation of the Category Filter that implements the TransactionFilter
package controller;

import java.util.ArrayList;
import java.util.List;
import model.Transaction;

public class AmountFilter implements TransactionFilter {
    private double amount;
    ''' 
        Constructor that defines the amount that we want to filter on.
        Arguments:
            amount (double) : The amount we want to filter on
    '''
    public AmountFilter(double amount) {
        this.amount = amount;
    }

    '''
        The main brains of the function, does the actuall filtering. This overwrites the filter function of the interface.
        Arguments:
            transactions (List<Transactions>): The list of all the transactions
        Returns: 
            List<Transaction> : The filtered transactions
    '''
    @Override
    public List<Transaction> filter(List<Transaction> transactions) {
        
        List<Transaction> filtered = new ArrayList<>();
        // If the category entered is not valid, we return null
        if (!InputValidation.isValidAmount(this.amount)) {
            return null;
        }
        
        for (Transaction t : transactions) {
            if (t.getAmount()==this.amount) {
                filtered.add(t);
            }
        }
        return filtered;
    }


}