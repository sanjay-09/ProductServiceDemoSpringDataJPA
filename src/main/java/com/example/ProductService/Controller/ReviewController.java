package com.example.ProductService.Controller;


import com.example.ProductService.DTO.ReviewRequestDTO;
import com.example.ProductService.DTO.ReviewResponseDTO;
import com.example.ProductService.Services.ErrorMessage;
import com.example.ProductService.Services.ReviewService;
import com.example.ProductService.Utils.BookingIdNotFound;
import com.example.ProductService.Utils.ReviewIdNotFound;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    ReviewService reviewService;
    ReviewController(ReviewService reviewService){
        this.reviewService=reviewService;
    }

    @PostMapping
    public ResponseEntity<?> createReview(@RequestBody ReviewRequestDTO reviewRequestDTO){
        if(reviewRequestDTO.getRating()==null||reviewRequestDTO.getBookingId()==null||reviewRequestDTO.getBookingId()==0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorMessage("rating or content is empty"));
        }
       try{
           ReviewResponseDTO reviewResponseDTO=this.reviewService.createReview(reviewRequestDTO);
           return ResponseEntity.status(HttpStatus.OK).body(reviewResponseDTO);
       }
       catch (BookingIdNotFound e){
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorMessage("booking id is not present"));
       }
       catch (Exception e){

           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorMessage("internal server error"));

       }



    }
    @GetMapping("/{reviewId}")
    public ResponseEntity<?> getReviewById(@PathVariable Long reviewId){

     try{
         ReviewResponseDTO reviewResponseDTO=this.reviewService.findById(reviewId);
         return ResponseEntity.status(HttpStatus.OK).body(reviewResponseDTO);
     }
     catch (ReviewIdNotFound e){
         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("review id not found");
     }
     catch (Exception e){
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("internal server error");
     }
    }

    @PatchMapping("/{reviewId}")
    public ResponseEntity<?> updateReviewBasedOnId(@PathVariable Long reviewId,@RequestBody ReviewRequestDTO reviewRequestDTO){
        if(reviewRequestDTO.getContent()==null||reviewRequestDTO.getRating()==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorMessage("content or rating missing"));
        }
        try{
            ReviewResponseDTO reviewResponseDTO=this.reviewService.updateReviewBasedOnId(reviewId,reviewRequestDTO);
            return ResponseEntity.status(HttpStatus.OK).body(reviewResponseDTO);
        }
        catch (ReviewIdNotFound e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorMessage("review id not found"));

        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorMessage("internal server error"));
        }

    }


    @DeleteMapping("/{reviewId}")
    public ResponseEntity<?> deleteReviewById(@PathVariable Long reviewId){

        try{
            ReviewResponseDTO reviewResponseDTO=this.reviewService.deleteReviewBasedOnId(reviewId);
            return ResponseEntity.status(HttpStatus.OK).body(reviewResponseDTO);

        }
        catch (ReviewIdNotFound e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorMessage("review id not found"));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorMessage("internal server error"));

        }
    }




}
