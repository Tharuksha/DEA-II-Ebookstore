package com.nsbm.ebookstore.user.review.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity

public class ReviewModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewid;

    @ManyToOne
    @JoinColumn(name = "bookid")
    private  book_model book_model;

    @ManyToOne
    @JoinColumn(name = "userid")
    private  user_model user_model;

    @Column
    private String comment;

    @Column
    public int rating;



}
