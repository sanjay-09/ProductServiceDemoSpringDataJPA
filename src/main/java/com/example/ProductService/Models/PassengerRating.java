package com.example.ProductService.Models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PassengerRating extends BaseModel{
    @Column(nullable = false)
    private String passengerReviewContent;
    @Column(nullable = false)
    private Double passengerRating;
}
