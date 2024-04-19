package com.nsbm.ebookstore.user.review.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;

@Data
@Entity

public class ReviewModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger reviewid;

    private  int book_id;

    private int  userid;

    private String comments;

    public int rating;
}
