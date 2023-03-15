package se.budgetapp.transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface JPATransactionRepository extends CrudRepository<Transaction, Long> {

    Iterable<Transaction> findAllByMonth(String month);

    Transaction getTransactionById(Long Id);


}
