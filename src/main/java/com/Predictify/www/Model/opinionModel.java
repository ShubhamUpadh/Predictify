//package com.Predictify.www.Model;
//
//import com.Predictify.www.Enum.opinionStatus;
//import com.Predictify.www.Enum.transactionStatus;
//import jakarta.persistence.*;
//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;
//
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name = "opinions")
//public class opinionModel {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    long id;
//
//    String title;
//    opinionStatus opinionStatus;
//    transactionStatus transactionStatus;
//    String createdBy;
//    Double stakes;
//
//
//
//    @CreationTimestamp
//    @Column(updatable = false)
//    private LocalDateTime createdAt;  // Auto-set when record is created
//
//    @UpdateTimestamp
//    private LocalDateTime updatedAt;  // Auto-updated when record changes
//
//    @Column(nullable = false)
//    private LocalDateTime expiryTime;
//
//    public opinionModel() {
//    }
//
//    public opinionModel(String title, String createdBy, Double stakes, LocalDateTime expiryTime) {
//        this.title = title;
//        this.createdBy = createdBy;
//        this.stakes = stakes;
//        this.expiryTime = expiryTime;
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
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public com.Predictify.www.Enum.opinionStatus getOpinionStatus() {
//        return opinionStatus;
//    }
//
//    public void setOpinionStatus(com.Predictify.www.Enum.opinionStatus opinionStatus) {
//        this.opinionStatus = opinionStatus;
//    }
//
//    public com.Predictify.www.Enum.transactionStatus getTransactionStatus() {
//        return transactionStatus;
//    }
//
//    public void setTransactionStatus(com.Predictify.www.Enum.transactionStatus transactionStatus) {
//        this.transactionStatus = transactionStatus;
//    }
//
//    public String getCreatedBy() {
//        return createdBy;
//    }
//
//    public void setCreatedBy(String createdBy) {
//        this.createdBy = createdBy;
//    }
//
//    public Double getStakes() {
//        return stakes;
//    }
//
//    public void setStakes(Double stakes) {
//        this.stakes = stakes;
//    }
//
//    public LocalDateTime getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(LocalDateTime createdAt) {
//        this.createdAt = createdAt;
//    }
//
//    public LocalDateTime getUpdatedAt() {
//        return updatedAt;
//    }
//
//    public void setUpdatedAt(LocalDateTime updatedAt) {
//        this.updatedAt = updatedAt;
//    }
//
//    public LocalDateTime getExpiryTime() {
//        return expiryTime;
//    }
//
//    public void setExpiryTime(LocalDateTime expiryTime) {
//        this.expiryTime = expiryTime;
//    }
//}
