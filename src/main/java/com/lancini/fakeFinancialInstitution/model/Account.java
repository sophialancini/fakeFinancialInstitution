package com.lancini.fakeFinancialInstitution.model;

import jakarta.persistence.*;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Customer customer;
    private Long balance;

    public Account(Long id, Customer customer, Long balance) {
        this.id = id;
        this.customer = customer;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }
}
