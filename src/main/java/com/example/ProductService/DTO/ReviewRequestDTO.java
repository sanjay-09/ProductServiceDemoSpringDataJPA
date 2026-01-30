package com.example.ProductService.DTO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewRequestDTO {

    private String content;

    private Double rating;

    private Long bookingId;


}
