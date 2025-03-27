package com.Predictify.www.Model;

import com.Predictify.www.Enum.userStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class userModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String username;
    String password;
    userStatus status;

    @OneToMany
    transactionModel transaction;

    public userModel(long id, String username) {
        this.id = id;
        this.username = username;
        this.status = userStatus.ACTIVE;
    }

    public userModel() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public userStatus getStatus() {
        return status;
    }

    public void setStatus(userStatus status) {
        this.status = status;
    }
}
