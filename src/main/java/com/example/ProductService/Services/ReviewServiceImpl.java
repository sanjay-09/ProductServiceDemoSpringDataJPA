package com.example.ProductService.Services;

import com.example.ProductService.DTO.ReviewResponseDTO;
import com.example.ProductService.DTO.ReviewRequestDTO;
import com.example.ProductService.Models.Booking;
import com.example.ProductService.Models.Review;
import com.example.ProductService.Repository.BookingRepository;
import com.example.ProductService.Repository.ReviewRepository;
import com.example.ProductService.Utils.BookingIdNotFound;
import com.example.ProductService.Utils.ReviewIdNotFound;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService{

    ReviewRepository reviewRepository;
    BookingRepository bookingRepository;

    ReviewServiceImpl(ReviewRepository reviewRepository,BookingRepository bookingRepository){
        this.reviewRepository=reviewRepository;
        this.bookingRepository=bookingRepository;
    }


    @Override
    public ReviewResponseDTO findById(Long id) throws Exception {
        Optional<Review> review=this.reviewRepository.findById(id);
        if(review.isEmpty()){
            throw new ReviewIdNotFound("review id not found");
        }


        Review r=review.get();
       ReviewResponseDTO reviewResponseDTO = ReviewResponseDTO.builder().
               id(r.getId()).content(r.getContent()).rating(r.getRating()).createdAt(r.getCreatedAt()).updatedAt(r.getUpdatedAt())
               .bookingId(r.getBooking().getId()).build();
       return reviewResponseDTO;


    }

    @Override
    public ReviewResponseDTO findReviewByBookingId(Long booking_id)  throws  Exception{
        Optional<Booking> booking=this.bookingRepository.findById(booking_id);
        if(booking.isEmpty()){
            throw new BookingIdNotFound("booking id not found");
        }

        Optional<Review> review=this.reviewRepository.findByBooking(booking.get());
        if(review.isEmpty()){
            throw new ReviewIdNotFound("review id not found");
        }
        Review r=review.get();
        ReviewResponseDTO reviewResponseDTO = ReviewResponseDTO.builder().
                id(r.getId()).content(r.getContent()).rating(r.getRating()).createdAt(r.getCreatedAt()).updatedAt(r.getUpdatedAt())
                .bookingId(r.getBooking().getId()).build();
        return reviewResponseDTO;


    }

    @Override
    public List<ReviewResponseDTO> findReviewRatingGreaterThan(Double rating) {

        List<Review> reviews=this.reviewRepository.findByRatingGreaterThan(rating);
        List<ReviewResponseDTO> reviewResponseDTOS =new ArrayList<>();
        for(Review r:reviews){
            ReviewResponseDTO reviewResponseDTO = ReviewResponseDTO.builder().
                    id(r.getId()).content(r.getContent()).rating(r.getRating()).createdAt(r.getCreatedAt()).updatedAt(r.getUpdatedAt())
                    .bookingId(r.getBooking().getId()).build();
            reviewResponseDTOS.add(reviewResponseDTO);

        }
        return reviewResponseDTOS;

    }

    @Override
    public ReviewResponseDTO createReview(ReviewRequestDTO reviewRequestDTO) throws Exception {

        Optional<Booking> isBookingPresent=this.bookingRepository.findById(reviewRequestDTO.getBookingId());
        if(isBookingPresent.isEmpty()){
            throw new BookingIdNotFound("booking id is not present");
        }
        Review r=Review.builder().content(reviewRequestDTO.getContent()).
                rating(reviewRequestDTO.getRating()).booking(isBookingPresent.get()).build();

        this.reviewRepository.save(r);

        ReviewResponseDTO reviewResponseDTO = ReviewResponseDTO.builder().id(r.getId()).
                rating(r.getRating()).content(r.getContent())
                .bookingId(r.getBooking().getId()).
                createdAt(r.getCreatedAt()).updatedAt(r.getUpdatedAt()).build();

        return reviewResponseDTO;


    }

    @Override
    public ReviewResponseDTO updateReviewBasedOnId(Long id,ReviewRequestDTO reviewRequestDTO) throws Exception {

        Optional<Review> review=this.reviewRepository.findById(id);
        if(review.isEmpty()){
            throw new ReviewIdNotFound("review id is not found");
        }

        Review rr=review.get();
        rr.setRating(reviewRequestDTO.getRating());
        rr.setContent(reviewRequestDTO.getContent());
        this.reviewRepository.save(rr);
        ReviewResponseDTO reviewResponseDTO=ReviewResponseDTO.builder().id(rr.getId()).
                content(rr.getContent()).rating(rr.getRating()).createdAt(rr.getCreatedAt()).updatedAt(rr.getUpdatedAt()).build();
        return reviewResponseDTO;
    }
    @Override
    public ReviewResponseDTO deleteReviewBasedOnId(Long id) throws ReviewIdNotFound {
        Optional<Review> review=this.reviewRepository.findById(id);
        if(review.isEmpty()){
            throw new ReviewIdNotFound("review id is not found");
        }
        Review rr=review.get();
        this.reviewRepository.deleteById(id);
        ReviewResponseDTO reviewResponseDTO=ReviewResponseDTO.builder().id(rr.getId()).
                content(rr.getContent()).rating(rr.getRating()).createdAt(rr.getCreatedAt()).updatedAt(rr.getUpdatedAt()).build();
        return reviewResponseDTO;


    }


}
