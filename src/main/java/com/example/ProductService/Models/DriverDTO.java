package com.example.ProductService.Models;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DriverDTO {

    private Long id;
    private String licensenumber;

    DriverDTO(Long id,String licenseNumber){
        this.id=id;
        this.licensenumber=licenseNumber;
    }




}
