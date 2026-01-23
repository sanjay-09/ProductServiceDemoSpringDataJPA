package com.example.ProductService.Models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.hibernate.annotations.Fetch;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Driver extends BaseModel {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String licenseNumber;

    @OneToMany(mappedBy = "driver")
    private List<Booking> booking;

    @Override
    public String toString() {
        return "Driver{" +
                "updatedAt=" + updatedAt +
                ", createdAt=" + createdAt +
                ", licenseNumber='" + licenseNumber + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
