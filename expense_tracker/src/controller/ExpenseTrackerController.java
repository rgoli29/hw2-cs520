package controller;

import view.ExpenseTrackerView;

import java.util.List;



import model.ExpenseTrackerModel;
import model.Transaction;
public class ExpenseTrackerController {
  
  private ExpenseTrackerModel model;
  private ExpenseTrackerView view;

  public ExpenseTrackerController(ExpenseTrackerModel model, ExpenseTrackerView view) {
    this.model = model;
    this.view = view;

    // Set up view event handlers
  }

  public void refresh() {

    // Get transactions from model
    List<Transaction> transactions = model.getTransactions();

    // Pass to view
    view.refreshTable(transactions);

  }

  public boolean addTransaction(double amount, String category) {
    if (!InputValidation.isValidAmount(amount)) {
      return false;
    }
    if (!InputValidation.isValidCategory(category)) {
      return false;
    }
    
    Transaction t = new Transaction(amount, category);
    model.addTransaction(t);
    view.getTableModel().addRow(new Object[]{t.getAmount(), t.getCategory(), t.getTimestamp()});
    refresh();
    return true;
  }
  
  public void applyFilter(String filterType, double amount, String category) {
    List<Transaction> transactions = model.getTransactions();
    TransactionFilter filter = null;
    if (filterType.toLowerCase().equals("amount")){
      // If the amount entered is not valid
      if (!InputValidation.isValidAmount(amount)) {
        view.showError("Invalid amount filter");
        return;
      }
      filter = new AmountFilter(amount);
    }
    else if (filterType.toLowerCase().equals("category")){
      // If the category entered is not valid
      if (!InputValidation.isValidCategory(category)) {
        view.showError("Invalid category filter");
        return;
      }  
      filter = new CategoryFilter(category);
    }
    else{
      view.refreshTable(transactions);
      return;
    }
    List<Transaction> filtered = filter.filter(transactions);
    view.refreshTable(filtered);
  }
}