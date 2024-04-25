package com.nsbm.ebookstore.user.review.service;

import com.nsbm.ebookstore.user.review.model.ReviewModel;
import com.nsbm.ebookstore.user.review.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ReviewService {

    @Autowired
    public ReviewRepository reviewRepository;

    // Retrieve all comments
    public List<ReviewModel> getAllComments() {
        return reviewRepository.findAll();
    }

    // Comment operations

    //add comment
    public ReviewModel addComment(ReviewModel reviewModel) {
        return reviewRepository.save(reviewModel);
    }

    //delete comments

    public void deleteComment(Long id) {
        reviewRepository.deleteById(id);
    }

    //update comments

    public ReviewModel updateComment(Long id, ReviewModel comment) {
        ReviewModel reviewModel = reviewRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid review id: " + id));
        reviewModel.setComments(comment.getComments());
        reviewModel.setRating(comment.getRating());

        return reviewRepository.save(reviewModel);
    }

    //get all reviews for certain book id
    public List<ReviewModel> GetReviewsByBookId(int book_id){
        return reviewRepository.findCommentsByBookID(book_id);
    }

    //get all users for certain book id
    public List<ReviewModel> GetUsersByBookId(int userid){
        return reviewRepository.findUsersByBookID(userid);
    }
}
