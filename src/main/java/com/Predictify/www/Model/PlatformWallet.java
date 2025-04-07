package com.Predictify.www.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class PlatformWallet {
    @Id
    private Long id = 1L;

    private Double balance;
    private LocalDateTime lastUpdated;

    public PlatformWallet() {
    }

    public PlatformWallet(Long id, Double balance, LocalDateTime lastUpdated) {
        this.id = id;
        this.balance = balance;
        this.lastUpdated = lastUpdated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
