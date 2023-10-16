package com.lancini.fakeFinancialInstitution.model;

import jakarta.persistence.*;

@Entity
@Table(name = "transferHistory")
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Account sender;

    @ManyToOne
    private Account receiver;

    private Long amount;

    public Transfer(Long id, Account sender, Account receiver, Long amount) {
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public Account getSender() {
        return sender;
    }

    public Account getReceiver() {
        return receiver;
    }

    public Long getAmount() {
        return amount;
    }
}
