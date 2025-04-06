package com.incture.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String comment;
    private int rating; // 1 to 5

    @ManyToOne
    private Product product;

    @ManyToOne
    private Customer customer;

    private LocalDateTime createdAt = LocalDateTime.now();

    // Getters and setters
}
