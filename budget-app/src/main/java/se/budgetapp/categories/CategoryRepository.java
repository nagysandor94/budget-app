package se.budgetapp.categories;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryRepository {
    private ICategoryRepository repo;

    public CategoryRepository (@Autowired ICategoryRepository repo){
        this.repo = repo;
    }

    public List<Category> listAllCategory () {
        Iterable<Category> all = repo.findAll();
        List<Category> categories = Streamable.of(all).toList();
        return categories;
    }

    public Category getCategoryByName (String name) {
        return repo.getCategoryByCategoryName(name);
    }


}
