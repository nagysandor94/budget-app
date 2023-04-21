package se.budgetapp.transaction;

import se.budgetapp.BudgetAppApplicationTests;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class APITestTransaction extends BudgetAppApplicationTests {

    private static Transaction transaction;

    @BeforeAll
    static void setUp(@Autowired RestTemplate template, @Value("${server.port}") int port) {
        String baseURL = "http://localhost:%s/api/transactions".formatted(port);
        TransactionDTO createTransaction = new TransactionDTO("Income", "Salary", "january", "salary", 4500);
        ResponseEntity <Transaction> response = template
                .postForEntity(baseURL, createTransaction, Transaction.class);
        assertThat(response.getStatusCode().value()).isEqualTo(201);
        transaction = response.getBody();
    }

    @AfterAll
    static void tearDown (@Autowired TransactionRepository repository) {
    repository.delete(transaction);
    }

    @Test
    @Order(1)
    void shouldListTransactions() {
    ResponseEntity<List> response = restTemplate.getForEntity("http://localhost:%s/api/transactions/month/january".formatted(port), List.class);
    List transactions = response.getBody();

    assertThat(response.getStatusCode().value()).isEqualTo(200);
    assertThat(transactions).hasSize(1);

    }


}
