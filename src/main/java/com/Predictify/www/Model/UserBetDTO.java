package com.Predictify.www.Model;

import com.Predictify.www.Enum.opinion;

public class UserBetDTO {
    Long id;
    Long poll_id;
    int amount;
    opinion opinion;

    public UserBetDTO() {
    }

    public UserBetDTO(Long id, Long poll_id, int amount, com.Predictify.www.Enum.opinion opinion) {
        this.id = id;
        this.poll_id = poll_id;
        this.amount = amount;
        this.opinion = opinion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPoll_id() {
        return poll_id;
    }

    public void setPoll_id(Long poll_id) {
        this.poll_id = poll_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public com.Predictify.www.Enum.opinion getOpinion() {
        return opinion;
    }

    public void setOpinion(com.Predictify.www.Enum.opinion opinion) {
        this.opinion = opinion;
    }
}
