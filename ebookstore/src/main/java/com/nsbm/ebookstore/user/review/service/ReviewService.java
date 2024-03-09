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

    // Comment operations
    public ReviewModel addComment(ReviewModel reviewModel) {
        return reviewRepository.save(reviewModel);
    }

    public void deleteComment(Long id) {
        reviewRepository.deleteById(id);
    }

    public ReviewModel updateComment(Long id, String comment) {
        ReviewModel reviewModel = reviewRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid review id: " + id));

        reviewModel.setComment(comment);

        return reviewRepository.save(reviewModel);
    }

    // Rating operations
    public ReviewModel addRating(Long id, int rating) {
        ReviewModel reviewModel = reviewRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid review id: " + id));

        reviewModel.setRating(rating);

        return reviewRepository.save(reviewModel);
    }

    public void deleteRating(Long id) {
        ReviewModel reviewModel = reviewRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid review id: " + id));

        reviewModel.setRating(0); // Assuming 0 indicates no rating

        reviewRepository.save(reviewModel);
    }

    public ReviewModel updateRating(Long id, int rating) {
        ReviewModel reviewModel = reviewRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid review id: " + id));

        reviewModel.setRating(rating);

        return reviewRepository.save(reviewModel);
    }

}
