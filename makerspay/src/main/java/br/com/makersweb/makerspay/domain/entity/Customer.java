package br.com.makersweb.makerspay.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * @author anderson
 */
@Data
@Entity(name = "Customer")
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "financial_limit", nullable = false)
    private Integer financialLimit;

    @Column(name = "balance", nullable = false)
    private Integer balance;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Transaction> transactions;

    public void increaseBalance(final Integer balance){
        this.balance += balance;
    }

    public void decreaseBalance(final Integer balance){
        this.balance -= balance;
    }

    public void addTransaction(final Transaction transaction) {
        this.transactions.add(transaction);
    }

}
