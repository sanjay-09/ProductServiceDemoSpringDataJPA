package com.example.ProductService.Services;

import com.example.ProductService.DTO.ReviewResponseDTO;
import com.example.ProductService.DTO.ReviewRequestDTO;

import java.util.List;

public interface ReviewService {

    ReviewResponseDTO findById(Long id) throws Exception;
    ReviewResponseDTO findReviewByBookingId(Long booking_id) throws  Exception;
    List<ReviewResponseDTO> findReviewRatingGreaterThan(Double rating);
    ReviewResponseDTO createReview(ReviewRequestDTO reviewRequestDTO) throws  Exception;
    ReviewResponseDTO updateReviewBasedOnId(Long id,ReviewRequestDTO reviewRequestDTO) throws Exception;
    ReviewResponseDTO deleteReviewBasedOnId(Long id) throws Exception;

}
