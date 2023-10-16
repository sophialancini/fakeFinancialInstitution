package com.lancini.fakeFinancialInstitution.model;

import jakarta.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;

    public Customer(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
}
