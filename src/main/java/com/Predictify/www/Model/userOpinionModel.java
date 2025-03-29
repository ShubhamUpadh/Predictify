package com.Predictify.www.Model;

import jakarta.persistence.*;
import com.Predictify.www.Enum.opinion;

@Entity
@Table(name = "user_opinions")
public class userOpinionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @OneToMany
    User user;

    @OneToMany
    opinionModel opinionModel;

    opinion opinion;

    public userOpinionModel() {
    }

    public userOpinionModel(User user, opinionModel opinionModel, opinion opinion) {
        this.user = user;
        this.opinionModel = opinionModel;
        this.opinion = opinion;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUserModel() {
        return user;
    }

    public void setUserModel(User user) {
        this.user = user;
    }

    public com.Predictify.www.Model.opinionModel getOpinionModel() {
        return opinionModel;
    }

    public void setOpinionModel(com.Predictify.www.Model.opinionModel opinionModel) {
        this.opinionModel = opinionModel;
    }

    public com.Predictify.www.Enum.opinion getOpinion() {
        return opinion;
    }

    public void setOpinion(com.Predictify.www.Enum.opinion opinion) {
        this.opinion = opinion;
    }
}
