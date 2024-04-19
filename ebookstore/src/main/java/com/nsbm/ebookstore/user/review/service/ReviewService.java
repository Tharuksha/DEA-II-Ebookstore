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

    public ReviewModel updateComment(Long id, String comment) {
        ReviewModel reviewModel = reviewRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid review id: " + id));
        reviewModel.setComment(comment);

        return reviewRepository.save(reviewModel);
    }
}
