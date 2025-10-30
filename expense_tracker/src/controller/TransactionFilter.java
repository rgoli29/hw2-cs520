// New Interface to define the wanted filter
package controller;
import java.util.List;
import model.Transaction;

public interface TransactionFilter {
    List<Transaction> filter(List<Transaction> transactions);
}