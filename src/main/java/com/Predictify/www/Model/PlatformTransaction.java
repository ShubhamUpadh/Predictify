package com.Predictify.www.Model;

import com.Predictify.www.Enum.userWalletOperation;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class PlatformTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "wallet_id", nullable = false)
    private Long walletId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    PTType operation;

    @Column(nullable = false)
    private Double amount;

    @Column(name = "poll_id", nullable = true)
    private Long pollId;

    private LocalDateTime timestamp;

    public PlatformTransaction() {
    }

    public PlatformTransaction(Long pollId, Double amount, userWalletOperation operation, Long walletId){
        this.pollId = pollId;
        this.amount = amount;
        this.operation = PTConverter(operation);
        this.walletId = walletId;
        this.timestamp = LocalDateTime.now();
    }

    enum PTType{ USERBET, PRIZE}

    private PTType PTConverter(userWalletOperation operation){
        if (operation == userWalletOperation.BET) return PTType.USERBET;
        else return PTType.PRIZE;
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

    public PTType getOperation() {
        return operation;
    }

    public void setOperation(PTType operation) {
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

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
