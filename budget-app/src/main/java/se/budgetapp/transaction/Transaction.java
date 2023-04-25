package se.budgetapp.transaction;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import se.budgetapp.categories.Category;

import javax.persistence.*;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    @OneToOne
    private Category category;
    @Column(nullable = false)
    private String month;

    private String description;

    @Column(nullable = false)
    private double amount;

    public Transaction() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Transaction(Long id, String type, Category category, String month, String description, double amount) {
        this.id = id;
        this.type = type;
        this.category = category;
        this.month = month;
        this.description = description;
        this.amount = amount;
    }

    public Transaction(String type, Category category, String month, String description, double amount) {
        this.type = type;
        this.category = category;
        this.month = month;
        this.description = description;
        this.amount = amount;
    }

    public Transaction(String type, String month, String description, double amount) {
        this.type = type;
        this.month = month;
        this.description = description;
        this.amount = amount;
    }
}
