package com.example.ProductService.Repository;

import com.example.ProductService.Models.Booking;
import com.example.ProductService.Models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {

    List<Booking> findByDriver_Id(Long id);

    List<Booking> findByDriverIn(List<Driver> driver);
}
