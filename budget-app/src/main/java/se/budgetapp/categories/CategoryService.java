package se.budgetapp.categories;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository repo;

    public List<Category> getAllcategories(){
        return repo.listAllCategory();
    }

    public ResponseCategory toDTO (Category category) {
        return new ResponseCategory(category.getCategoryName());
    }

    public Category getCategoryByName(String name) {
        return repo.getCategoryByName(name);
    }
}
