package se.budgetapp.transaction;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class TransactionController {

    @GetMapping
    ResponseEntity<TransactionDTO> getTransaction(){
        TransactionDTO transactionDTO = new TransactionDTO("WORK");
        return new ResponseEntity<>(transactionDTO, HttpStatus.OK);
    }



}
