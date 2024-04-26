package com.nsbm.ebookstore.user.review.repository;

import com.nsbm.ebookstore.user.review.model.ReviewModel;
import com.nsbm.ebookstore.user.review.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository <ReviewModel, Long> {

    @Query(value = "SELECT r FROM ReviewModel r WHERE r.book_id = :book_id")
    List<ReviewModel> findCommentsByBookID (@Param("book_id") long book_id);

    @Query(value = "SELECT r FROM ReviewModel r WHERE r.userid = :userid")
    List<ReviewModel> findUsersByBookID (@Param("userid") long userid);

    @Query(value = "SELECT r FROM ReviewModel r WHERE (r.book_id = :book_id AND r.userid = :userid)")
    List<ReviewModel> findUserBookById(@Param("book_id") long bookId, @Param("userid") long userId);

    @Query(value = "SELECT r FROM UserModel r WHERE r.userid = :userid")
    List<UserModel>findUserById(@Param("userid")long userid);
}
