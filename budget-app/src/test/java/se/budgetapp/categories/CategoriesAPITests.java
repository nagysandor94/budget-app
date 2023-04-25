package se.budgetapp.categories;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.http.ResponseEntity;
import se.budgetapp.BudgetAppApplicationTests;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CategoriesAPITests extends BudgetAppApplicationTests {

    @Test
    void shouldListThreeCategories() {
        ResponseEntity<List> response = restTemplate.getForEntity("http://localhost:%s/api/categories".formatted(port), List.class);
        List categories = response.getBody();

        assertThat(response.getStatusCode().value()).isEqualTo(200);
        assertThat(categories).hasSize(3);
    }

}
