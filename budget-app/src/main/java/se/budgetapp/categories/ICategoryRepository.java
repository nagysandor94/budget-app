package se.budgetapp.categories;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ICategoryRepository extends CrudRepository<Category, Long> {



    Category getCategoryByCategoryName(String CategoryName);







}
