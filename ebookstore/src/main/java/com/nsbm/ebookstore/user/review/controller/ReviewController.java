package com.nsbm.ebookstore.user.review.controller;

import com.nsbm.ebookstore.user.review.model.ReviewModel;
import com.nsbm.ebookstore.user.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/review")

public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    // Retrieve all comments
    @GetMapping("/comments")
    public List<ReviewModel> getAllComments() {
        return reviewService.getAllComments();
    }

     //Retrieve all ratings
    @GetMapping("/ratings")
    public ResponseEntity<List<ReviewModel>> getAllRatings() {
        List<ReviewModel> ratings = reviewService.getAllRatings();
//        List<ReviewModel> rating = null;
        return ResponseEntity.ok(ratings);
    }

    //add comment
    @PostMapping("/addComment")
    public ResponseEntity<ReviewModel> addComment(@RequestBody ReviewModel reviewModel){
        ReviewModel addedReview = reviewService.addComment(reviewModel);
        return ResponseEntity.ok(addedReview);
    }

    //delete comment
    @DeleteMapping("/deleteComment/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable("id") Long comment){
        reviewService.deleteComment(comment);
        return ResponseEntity.ok("comment deleted successfully");
    }

    //update comment
    @PutMapping("/updateComment/{id}")
    public  ResponseEntity<ReviewModel> updateComment(@PathVariable("id") Long id, @RequestBody String comment){
        ReviewModel updatedReview = reviewService.updateComment(id, comment);
        return ResponseEntity.ok(updatedReview);
    }

    //add rating
    @PostMapping("/addRating/{id}")
    public ResponseEntity<ReviewModel> addRating(@PathVariable("id") Long id,@RequestParam("rating") int rating){
        ReviewModel updatedReview = reviewService.addRating(id, rating);
        return ResponseEntity.ok(updatedReview);
    }

    //delete rating
    @DeleteMapping("/deleteRating/{id}")
    public ResponseEntity<?> deleteRating(@PathVariable("id") Long id){
        reviewService.deleteRating(id);
        return ResponseEntity.ok("Rating deleted successfully");
    }

    //update rating
    @PutMapping("/updateRating/{id}")
    public ResponseEntity<ReviewModel> updateRating(@PathVariable("id")Long id,@RequestParam("rating")int rating){
        ReviewModel updateReview = reviewService.updateRating(id,rating);
        return ResponseEntity.ok(updateReview);
    }
}
