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
    public static final String ALL_COMMENTS_ENDPOINT = "/comments";
    public static final String ADD_COMMENT_ENDPOINT = "/addComment";
    public static final String DELETE_COMMENT_ENDPOINT = "/delete/{id}";
    public static final String UPDATE_COMMENT_ENDPOINT = "/update/{id}";


    @Autowired
    private ReviewService reviewService;

    // Retrieve all comments
    @GetMapping("/comments")
    public List<ReviewModel> getAllComments() {
        return reviewService.getAllComments();
    }


    //add comment
    @PostMapping("/addComment")
    public ResponseEntity<ReviewModel> addComment(@RequestBody ReviewModel reviewModel){
        ReviewModel addedReview = reviewService.addComment(reviewModel);
        return ResponseEntity.ok(addedReview);
    }

    //delete comment
    @DeleteMapping("/deleteComment/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable("id") Long id){
        reviewService.deleteComment(id);
        return ResponseEntity.ok("comment deleted successfully");
    }

    //update comment
    @PutMapping("/updateComment/{id}")
    public  ResponseEntity<ReviewModel> updateComment(@PathVariable("id") Long id, @RequestBody String comment){
        ReviewModel updatedReview = reviewService.updateComment(id, comment);
        return ResponseEntity.ok(updatedReview);
    }

}
