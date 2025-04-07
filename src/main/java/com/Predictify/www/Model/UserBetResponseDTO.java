package com.Predictify.www.Model;

import com.Predictify.www.Enum.opinion;

public class UserBetResponseDTO {
    Long userId;
    int balance;
    Long pollId;
    opinion opinion;

    public UserBetResponseDTO() {
    }

    public UserBetResponseDTO(Long userId, int balance, Long pollId, com.Predictify.www.Enum.opinion opinion) {
        this.userId = userId;
        this.balance = balance;
        this.pollId = pollId;
        this.opinion = opinion;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Long getPollId() {
        return pollId;
    }

    public void setPollId(Long pollId) {
        this.pollId = pollId;
    }

    public com.Predictify.www.Enum.opinion getOpinion() {
        return opinion;
    }

    public void setOpinion(com.Predictify.www.Enum.opinion opinion) {
        this.opinion = opinion;
    }
}
