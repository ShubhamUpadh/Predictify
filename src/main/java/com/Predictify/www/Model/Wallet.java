package com.Predictify.www.Model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "wallet")
public class Wallet {
    @Id
    @Column(name = "user_id")
    Long id;

    int balance = 0; // this is in paise

//    @Version
//    Integer version;

    public Wallet(User user, int balance) {
        this.id = user.getId();
        this.balance = balance;
    }

    public Wallet() {
    }

    public Wallet(int balance) {
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

    public void setId(Long id) {
        this.id = id;
    }

//    public Integer getVersion() {
//        return version;
//    }
//
//    public void setVersion(Integer version) {
//        this.version = version;
//    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wallet wallet1 = (Wallet)o;
        return Objects.equals(id, wallet1.getId());
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
}
