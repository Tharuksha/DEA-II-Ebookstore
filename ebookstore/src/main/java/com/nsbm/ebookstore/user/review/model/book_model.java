package com.nsbm.ebookstore.user.review.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity

public class book_model {

    @Id
    private int id;
}
