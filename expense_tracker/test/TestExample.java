// package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.beans.Transient;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import controller.ExpenseTrackerController;
import controller.InputValidation;
import controller.CategoryFilter;
import controller.AmountFilter;
import model.ExpenseTrackerModel;
import model.Transaction;
import view.ExpenseTrackerView;


public class TestExample {
  
    private ExpenseTrackerModel model;
    private ExpenseTrackerView view;
    private ExpenseTrackerController controller;

    @Before
    public void setup() {
        model = new ExpenseTrackerModel();
        view = new ExpenseTrackerView();
        controller = new ExpenseTrackerController(model, view);
    }

    public double getTotalCost() {
        double totalCost = 0.0;
        List<Transaction> allTransactions = model.getTransactions(); // Using the model's getTransactions method
        for (Transaction transaction : allTransactions) {
            totalCost += transaction.getAmount();
        }
        return totalCost;
    }
    


    @Test
    public void testAddTransaction() {
        // Pre-condition: List of transactions is empty
        assertEquals(0, model.getTransactions().size());
    
        // Perform the action: Add a transaction
        assertTrue(controller.addTransaction(50.00, "food"));
    
        // Post-condition: List of transactions contains one transaction
        assertEquals(1, model.getTransactions().size());
    
        // Check the contents of the list
        assertEquals(50.00, getTotalCost(), 0.01);
    }


    @Test
    public void testRemoveTransaction() {
        // Pre-condition: List of transactions is empty
        assertEquals(0, model.getTransactions().size());
    
        // Perform the action: Add and remove a transaction
        Transaction addedTransaction = new Transaction(50.00, "Groceries");
        model.addTransaction(addedTransaction);
    
        // Pre-condition: List of transactions contains one transaction
        assertEquals(1, model.getTransactions().size());
    
        // Perform the action: Remove the transaction
        model.removeTransaction(addedTransaction);
    
        // Post-condition: List of transactions is empty
        List<Transaction> transactions = model.getTransactions();
        assertEquals(0, transactions.size());
    
        // Check the total cost after removing the transaction
        double totalCost = getTotalCost();
        assertEquals(0.00, totalCost, 0.01);
    }

    @Test
    public void testValidAmount() {
        assertEquals(true, InputValidation.isValidAmount(500.0));   // valid amount
        assertEquals(false, InputValidation.isValidAmount(-10.0));  // negative amount
        assertEquals(false, InputValidation.isValidAmount(1500.0)); // amount exceeding max limit
        assertEquals(false, InputValidation.isValidAmount(0.0));     // boundary case: minimum valid amount
        assertEquals(true, InputValidation.isValidAmount(1000.0));  // boundary case: maximum valid amount
    }

    @Test
    public void testValidCategory() {
        assertEquals(true, InputValidation.isValidCategory("food"));            // valid category
        assertEquals(true, InputValidation.isValidCategory("travel"));    // valid category
        assertEquals(true, InputValidation.isValidCategory("BILLS"));           // case sensitivity
        assertEquals(false, InputValidation.isValidCategory("entertainmentt")); // typo in category
        assertEquals(true, InputValidation.isValidCategory("other"));           // valid category
        assertEquals(false, InputValidation.isValidCategory("groceries"));      // invalid category
        assertEquals(false, InputValidation.isValidCategory(""));               // empty string
        assertEquals(false, InputValidation.isValidCategory(null));             // null value
    }
    
    @Test
    public void testFilterTransactionsByCategory() {
        // Setup: Add some transactions
        model.addTransaction(new Transaction(50.0, "food"));
        model.addTransaction(new Transaction(20.0, "travel"));
        model.addTransaction(new Transaction(100.0, "bills"));
        model.addTransaction(new Transaction(500.0, "other"));
        model.addTransaction(new Transaction(250.0, "entertainment"));
        model.addTransaction(new Transaction(30.0, "food")); //Adding transactions
    
        // Test: Filter by category "food"
        CategoryFilter categoryFilter = new CategoryFilter("food"); //Applying Category Filter
        List<Transaction> filteredTransactions = categoryFilter.filter(model.getTransactions()); //Getting filtered transactions
        assertEquals(2, filteredTransactions.size()); //Checking size of filtered transactions
        for (Transaction t : filteredTransactions) {
            assertEquals("food", t.getCategory().toLowerCase()); //Checking category of each transaction
        }
    }
    @Test
    public void testFilterTransactionsByAmount() {
        // Setup: Add some transactions
        model.addTransaction(new Transaction(50.0, "food"));
        model.addTransaction(new Transaction(200.0, "travel"));
        model.addTransaction(new Transaction(100.0, "bills"));
        model.addTransaction(new Transaction(50.0, "other"));
        model.addTransaction(new Transaction(50.0, "entertainment"));  
        model.addTransaction(new Transaction(30.0, "food")); //Adding transactions
        // Test: Filter by amount exactly 50.0
        AmountFilter amountFilter = new AmountFilter(50.0); //Applying Amount Filter
        List<Transaction> filteredTransactions = amountFilter.filter(model.getTransactions()); //Getting filtered transactions
        assertEquals(3, filteredTransactions.size()); //Checking size of filtered transactions
        for (Transaction t : filteredTransactions) {
            assertEquals(50.0, t.getAmount(), 0.01); //Checking amount of each transaction
        }
    }
}