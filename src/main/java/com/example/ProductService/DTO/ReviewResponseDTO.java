package com.example.ProductService.DTO;

import lombok.*;

import java.util.Date;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class ReviewResponseDTO {


    private Long id;
    private String content;
    private Double rating;
    private Long bookingId;
    private Date createdAt;
    private Date updatedAt;


}
