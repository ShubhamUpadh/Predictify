package com.Predictify.www.Model;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Wallet")
public class Wallet {
    @Id
    @Column(name = "user_id")
    Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;
    int balance = 0; // this is in paise

    public Wallet(Long id, User user, int balance) {
        this.id = user.getId();
        this.user = user;
        this.balance = balance;
    }

    public Wallet() {
    }

    public Wallet(Double balance) {
        this.balance = balance;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Override
    public boolean equals(Object o){
        if (this == 0) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wallet wallet1 = (Wallet)o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashcode(){
        return Objects.hash(id);
    }
}
