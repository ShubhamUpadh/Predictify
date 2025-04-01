package com.Predictify.www.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import org.springframework.data.annotation.Id;

@Entity
@Table(name="user_transactions")
public class UserTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
}
