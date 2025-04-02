package com.Predictify.www.Model;

import jakarta.persistence.*;
import com.Predictify.www.Enum.userWalletOperation;

import java.util.Objects;

@Entity
@Table(name="user_transactions")
public class UserTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "wallet_id", nullable = false)
    private Long walletId;  // Storing only wallet ID instead of Wallet object

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    userWalletOperation operation; // Enum: DEPOSIT, WITHDRAW, BET

    @Column(nullable = false)
    private Double amount;

    @Column(name = "poll_id", nullable = true)
    private Long pollId; // Storing only the ID instead of the full OpinionPoll object

    public UserTransaction() {
    }

    public UserTransaction(Long pollId, Double amount, userWalletOperation operation, Long walletId){
        this.pollId = pollId;
        this.amount = amount;
        this.operation = operation;
        this.walletId = walletId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getWalletId() {
        return walletId;
    }

    public void setWalletId(Long walletId) {
        this.walletId = walletId;
    }

    public userWalletOperation getOperation() {
        return operation;
    }

    public void setOperation(userWalletOperation operation) {
        this.operation = operation;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getPollId() {
        return pollId;
    }

    public void setPollId(Long pollId) {
        this.pollId = pollId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
