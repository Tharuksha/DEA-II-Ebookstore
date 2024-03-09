package com.nsbm.ebookstore.user.review.repository;


import com.nsbm.ebookstore.user.review.model.ReviewModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<ReviewModel,Long> {
}
