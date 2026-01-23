package com.example.ProductService.Models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
public class PassengerRating extends Review{
    @Column(nullable = false)
    private String passengerReviewContent;
    @Column(nullable = false)
    private Double passengerRating;
}
