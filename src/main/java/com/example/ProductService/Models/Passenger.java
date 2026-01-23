package com.example.ProductService.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Passenger extends BaseModel {


    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String adharNunber;


    @OneToMany(mappedBy = "passenger",fetch = FetchType.EAGER)
    private List<Booking> Bookings;
}
