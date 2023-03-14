package se.budgetapp.transaction;

import org.springframework.beans.factory.annotation.Autowired;

public class TransactionRepository {

    JPATransactionRepository repo;
    public TransactionRepository (@Autowired JPATransactionRepository repo) {
        this.repo= repo;
    }

    public Transaction saveTransaction (Transaction newTransaction) {
        return repo.save(newTransaction);
    }

    public Transaction getTransactionById (Long id) {
        return repo.getTransactionById(id);
    }




}
