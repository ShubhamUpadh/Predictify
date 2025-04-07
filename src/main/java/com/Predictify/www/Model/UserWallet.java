package com.Predictify.www.Model;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "wallet")
public class UserWallet {
    @Id
    @Column(name = "user_id")
    Long id;

    int balance = 0; // this is in paise

//    @Version
//    Integer version;

    public UserWallet(Long id, int balance) {
        this.id = id;
        this.balance = balance;
    }

    public UserWallet() {
    }

    public UserWallet(int balance) {
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
        UserWallet userWallet1 = (UserWallet)o;
        return Objects.equals(id, userWallet1.getId());
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ID = "  + (this.id) + " Balance = " + (this.balance);
    }
}
