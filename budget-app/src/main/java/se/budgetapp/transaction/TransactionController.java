package se.budgetapp.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.budgetapp.categories.Category;
import se.budgetapp.categories.ResponseCategory;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/transactions")
public class TransactionController {


    public TransactionService service;

    public TransactionController (@Autowired TransactionService service) {
        this.service =service;
    }

    @GetMapping(path = "/month/{month}")
    ResponseEntity<List<ResponseTransactionDTO>> getTransactions(@PathVariable String month){
        List <Transaction> transactions = service.getAlltransactionByMonth(month.toLowerCase());
        List <ResponseTransactionDTO> responseTransactionDTOS = transactions.stream().map(transaction -> service.transactionToDto(transaction)).collect(Collectors.toList());
        return new ResponseEntity<>(responseTransactionDTOS, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<ResponseTransactionDTO> createNewTransaction (@RequestBody TransactionDTO dto){
        Transaction transaction = service.transactionFromDTO(dto);
        transaction.setCategory(service.findCategory(dto));
        Transaction savedTransaction = service.saveTransaction(transaction);
        return ResponseEntity.ok().body(service.transactionToDto(savedTransaction));
    }


    @GetMapping(path = "/{id}")
    ResponseEntity<ResponseTransactionDTO> getTransactionById(@PathVariable Long id){
        Transaction transaction = service.getTransactionById(id);
        ResponseTransactionDTO responseTransactionDTO = service.transactionToDto(transaction);
        return new ResponseEntity<>(responseTransactionDTO, HttpStatus.OK);
    }


    @PutMapping(path = "/{id}")
    ResponseEntity<ResponseTransactionDTO> updateTransaction(@PathVariable Long id, @RequestBody TransactionDTO dto){
        Transaction transactionToUpdate = service.getTransactionById(id);
        Transaction updatedTransaction = service.updateTransaction(transactionToUpdate, dto);
        return new ResponseEntity<>(service.transactionToDto(updatedTransaction), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        if(service.delete(id)){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.badRequest().build();
    }






}
