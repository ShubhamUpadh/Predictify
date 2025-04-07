package com.Predictify.www.Model;

import com.Predictify.www.Enum.opinion;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class UserOpinion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    Long userId;
    Long opinionId;
    opinion opinion;
    boolean transactionSettled;
    LocalDateTime timestamp;

    public UserOpinion() {
    }

    public UserOpinion(Long userId, Long opinionId, opinion opinion) {
        this.userId = userId;
        this.opinionId = opinionId;
        this.opinion = opinion;
        this.transactionSettled = false;
        this.timestamp = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getOpinionId() {
        return opinionId;
    }

    public void setOpinionId(Long opinionId) {
        this.opinionId = opinionId;
    }

    public com.Predictify.www.Enum.opinion getOpinion() {
        return opinion;
    }

    public void setOpinion(com.Predictify.www.Enum.opinion opinion) {
        this.opinion = opinion;
    }

    public boolean isTransactionSettled() {
        return transactionSettled;
    }

    public void setTransactionSettled(boolean transactionSettled) {
        this.transactionSettled = transactionSettled;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
