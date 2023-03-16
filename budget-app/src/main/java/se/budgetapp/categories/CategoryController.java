package se.budgetapp.categories;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.budgetapp.transaction.TransactionDTO;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/categories")

public class CategoryController {

    CategoryService service;

    public CategoryController(@Autowired CategoryService service){
        this.service = service;
    }


    @GetMapping
    ResponseEntity<List<ResponseCategory>> getCategories(){
        List <Category> categories = service.getAllcategories();
        List <ResponseCategory> responseCategories = service.getAllcategories().stream().map(category -> service.toDTO(category)).collect(Collectors.toList());
        return new ResponseEntity<>(responseCategories, HttpStatus.OK);
    }


}
