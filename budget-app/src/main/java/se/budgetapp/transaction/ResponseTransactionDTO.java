package se.budgetapp.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ResponseTransactionDTO(
        @JsonProperty(namespace = "id")
        Long id,
        @JsonProperty(namespace = "type")
        String type,
        @JsonProperty(namespace = "category")
        String category,
        @JsonProperty(namespace = "month")
        String month,
        @JsonProperty(namespace = "description")
        String description,
        @JsonProperty(namespace = "amount")
        double amount
) {
}
