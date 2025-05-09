package com.Predictify.www.Model;

import com.Predictify.www.Enum.userStatus;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String username;
    String password;
    @Enumerated(EnumType.STRING)
    userStatus status = userStatus.ACTIVE; // can be active, inactive, blocked

    public User(String password, String username) {
        this.password = password;
        this.username = username;
        this.status = userStatus.ACTIVE;
    }

    public User() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user1 = (User) o;
        return Objects.equals(id, user1.id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }

}
