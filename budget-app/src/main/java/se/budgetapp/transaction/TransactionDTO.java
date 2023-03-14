package se.budgetapp.transaction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TransactionDTO(@JsonProperty String typeIncEx,
                             @JsonProperty String category,
                             @JsonProperty String month,
                             @JsonProperty String description,
                             @JsonProperty double amount) {
}
