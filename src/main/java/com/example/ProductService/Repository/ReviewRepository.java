package com.example.ProductService.Repository;

import com.example.ProductService.Models.Booking;
import com.example.ProductService.Models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {



    List<Review> findByRatingGreaterThan(Double value);

    Optional<Review> findByBooking(Booking booking);


}
