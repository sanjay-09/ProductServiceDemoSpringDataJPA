package com.example.ProductService.Models;


import jakarta.persistence.*;
import lombok.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@EntityListeners(AuditingEntityListener.class)  //Call Spring’s auditing code whenever this entity is inserted or updated.
@Table(name="BookingReview")
public class Review extends BaseModel{

    @Column(nullable=false)
    String content;

    @Column(nullable = false)
    Double rating;

    @OneToOne
    @JoinColumn(name = "booking_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Booking booking;

    @Override
    public String toString() {
        return "Review{" +
                "updatedAt=" + updatedAt +
                ", createdAt=" + createdAt +
                ", rating=" + rating +
                ", content='" + content + '\'' +
                '}';
    }




}
