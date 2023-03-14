package se.budgetapp.transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPATransactionRepository extends CrudRepository<Transaction, Long> {


}
