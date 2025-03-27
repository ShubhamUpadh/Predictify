package com.Predictify.www.Model;


import jakarta.persistence.*;

@Entity
@Table(name = "balance")
public class balanceModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

}
