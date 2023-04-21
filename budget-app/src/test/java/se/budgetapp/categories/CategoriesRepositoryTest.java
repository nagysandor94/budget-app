package se.budgetapp.categories;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import se.budgetapp.BudgetAppApplicationTests;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CategoriesRepositoryTest extends BudgetAppApplicationTests {

    @Autowired
    CategoryRepository repo;

    @Test
    void shouldListThreeCategories(){
        List<Category> categories = repo.listAllCategory();
        assertThat(categories).hasSize(3);
    }

    @Test
    void shouldGetCategoryByNameSalary(){
        Category category = repo.getCategoryByName("Salary");
        assertThat(category.categoryName).isEqualTo("Salary");
    }

}
