//package com.Predictify.www.Model;
//
//import com.Predictify.www.Enum.operation;
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "transactions")
//public class transactionModel {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    long id;
//
//    @ManyToOne
//    User user;
//
//    operation operation;
//    Double amount;
//
//    public transactionModel() {
//    }
//
//    public transactionModel(double amount, User user) {
//        this.amount = amount;
//        this.user = user;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public com.Predictify.www.Enum.operation getOperation() {
//        return operation;
//    }
//
//    public void setOperation(com.Predictify.www.Enum.operation operation) {
//        this.operation = operation;
//    }
//
//    public double getAmount() {
//        return amount;
//    }
//
//    public void setAmount(double amount) {
//        this.amount = amount;
//    }
//}
