package com.example.ProductService.Models;


import jakarta.persistence.*;
import lombok.*;
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
@EntityListeners(AuditingEntityListener.class)  //Call Spring’s auditing code whenever this entity is inserted or updated.
@Table(name="BookingReview")
public class Review{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String content;

    @Column(nullable = false)
    double rating;

    @Column(nullable=false)
    @CreatedDate  //only handled when object is created
    Date created_at;

    @Column(nullable = false)
     @LastModifiedDate //this annotation tells only handles when the object is updated
    Date updated_at;

}
