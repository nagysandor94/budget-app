package se.budgetapp.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class TransactionRepository {

    JPATransactionRepository repo;
    public TransactionRepository (@Autowired JPATransactionRepository repo) {
        this.repo= repo;
    }



    public Transaction getTransactionById (Long id) {
        return repo.getTransactionById(id);
    }


    public void delete(Transaction transaction) {
        repo.delete(transaction);
    }

    public Transaction save(Transaction transaction) {
        return repo.save(transaction);
    }

    public Iterable<Transaction> findAllByMonth(String month) {
        return repo.findAllByMonth(month);
    }
}
