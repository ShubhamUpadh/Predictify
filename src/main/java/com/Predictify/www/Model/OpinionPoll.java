package com.Predictify.www.Model;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import com.Predictify.www.Enum.PollResult;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

@Entity
@Table(name="opinion_polls")
public class OpinionPoll {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @NotBlank(message = "Title is required")
    @Size(max = 255, message = "Title cannot exceed 255 characters")
    private String title;

    private boolean active = true;

    @NotNull
    @PastOrPresent(message = "CreatedAt must be in the past or present")
    private LocalDateTime createdAt = LocalDateTime.now();

    @NotNull
    private Long createdBy;

    @NotNull
    @Future(message = "Expiry time must be in the future")
    private LocalDateTime expiryTime;

    private boolean transactionSettled = false;

    @Min(value = 1, message = "Stakes cannot be negative")
    private Double stakesYes = 0D;

    @Min(value = 0, message = "Stakes cannot be negative")
    private Double stakesNo = 0D;

    @Enumerated(EnumType.STRING)
    private PollResult result = PollResult.UNDECIDED;

    public OpinionPoll() {}

    public OpinionPoll(String title, Long createdBy, LocalDateTime expiryTime, Double stakesYes, Double stakesNo) {
        this.title = title;
        this.createdBy = createdBy;
        this.expiryTime = expiryTime;
        this.createdAt = LocalDateTime.now();
        this.active = true;
        this.transactionSettled = false;
        this.result = PollResult.UNDECIDED;
        this.stakesYes = stakesYes;
        this.stakesNo = stakesNo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(LocalDateTime expiryTime) {
        this.expiryTime = expiryTime;
    }

    public boolean isTransactionSettled() {
        return transactionSettled;
    }

    public void setTransactionSettled(boolean transactionSettled) {
        this.transactionSettled = transactionSettled;
    }

    public @Min(value = 1, message = "Stakes cannot be negative") Double getStakesYes() {
        return stakesYes;
    }

    public void setStakesYes(Double stakesYes) {
        this.stakesYes = stakesYes;
    }

    public Double getStakesNo() {
        return stakesNo;
    }

    public void setStakesNo(Double stakesNo) {
        this.stakesNo = stakesNo;
    }

    public PollResult getResult() {
        return result;
    }

    public void setResult(PollResult result) {
        this.result = result;
    }


}
