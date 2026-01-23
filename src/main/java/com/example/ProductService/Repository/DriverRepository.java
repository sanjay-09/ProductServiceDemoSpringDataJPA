package com.example.ProductService.Repository;


import com.example.ProductService.Models.Driver;
import com.example.ProductService.Models.DriverDTO;
import com.example.ProductService.Models.DriverView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver,Long> {

    Optional<Driver> findByIdAndLicenseNumber(Long id,String licenseNumber);

    @Query(nativeQuery = true,value = "select * from driver where id=:id and license_number=:licenseNumber")
    Optional<Driver> rawFindByIdAndLicenseNumber(Long id,String licenseNumber);

    @Query("select new com.example.ProductService.Models.DriverDTO(d.id,d.licenseNumber) from Driver d where d.id=:id and d.licenseNumber=:licenseNumber")
    Optional<DriverDTO> rawFindByIdAndLicenseNumber2(Long id, String licenseNumber);

    @Query("select d.id as id,d.licenseNumber as licenseNumber from Driver d where d.id=:id and d.licenseNumber=:licenseNumber")
    Optional<DriverView> rawFindByIdAndLicenseNumber3(Long id, String licenseNumber);



}
