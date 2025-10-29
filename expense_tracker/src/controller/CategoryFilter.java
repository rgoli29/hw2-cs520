// Implementation of the Category Filter that implements the TransactionFilter
package controller;

import java.util.ArrayList;
import java.util.List;
import model.Transaction;

public class CategoryFilter implements TransactionFilter {
    private String category;
    /* 
        Constructor that defines the category that we want to filter on.
        Arguments:
            category (str) : The category we want to filter on

    */
    public CategoryFilter(String category) {
        this.category = category;
    }

    /*
        The main brains of the function, does the actuall filtering. This overwrites the filter function of the interface.
        Arguments:
            transactions (List<Transactions>): The list of all the transactions
        Returns: 
            List<Transaction> : The filtered transactions
    */
    @Override
    public List<Transaction> filter(List<Transaction> transactions) {
        List<Transaction> filtered = new ArrayList<>();
        for (Transaction t : transactions) {
            if (t.getCategory().equalsIgnoreCase(this.category)) {
                filtered.add(t);
            }
        }
        return filtered;
    }
}