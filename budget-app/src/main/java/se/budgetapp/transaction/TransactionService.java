package se.budgetapp.transaction;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;
import se.budgetapp.categories.Category;
import se.budgetapp.categories.ICategoryRepository;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    JPATransactionRepository repo;

    @Autowired
    ICategoryRepository categoryRepository;


    Transaction saveTransaction (Transaction newTransaction) {
        return repo.save(newTransaction);
    }

    Transaction transactionFromDTO(TransactionDTO dto) {
        double amount = dto.amount();
        String categoryName = dto.category();
        if(dto.category().isEmpty()){
            categoryName = "No category";
        }
        Category category = categoryRepository.getCategoryByCategoryName(categoryName);

        if (dto.typeIncEx().equals("Expense")){
            amount = (-1)*dto.amount();
        }
        return new Transaction(dto.typeIncEx(), category, dto.month(),dto.description(), amount);
    }

    public List<Transaction> getAlltransactionByMonth(String month) {
        Iterable<Transaction> all = repo.findAllByMonth(month);
        List<Transaction> transactions = Streamable.of(all).toList();
        return transactions;
    }


    public ResponseTransactionDTO transactionToDto (Transaction transaction) {
        double amount = transaction.getAmount();
//        if (transaction.getType().equals("Expense")){
//            amount = (-1)* transaction.getAmount();
//        }
        return new ResponseTransactionDTO(transaction.getId(), transaction.getType(), transaction.getCategory().getCategoryName(), transaction.getMonth(), transaction.getDescription(), amount);
    }


    public Transaction getTransactionById(Long id) {
        return repo.getTransactionById(id);
    }

    public Transaction updateTransaction(Transaction transaction, TransactionDTO dto) {
        Category category = categoryRepository.getCategoryByCategoryName(dto.category());
        transaction.setCategory(category);
        transaction.setType(dto.typeIncEx());
        transaction.setAmount(dto.amount());
        transaction.setDescription(dto.description());

        return repo.save(transaction);

    }

    public boolean delete(Long id) {
        Transaction transaction = repo.getTransactionById(id);
        repo.delete(transaction);
        return true;
    }

}
