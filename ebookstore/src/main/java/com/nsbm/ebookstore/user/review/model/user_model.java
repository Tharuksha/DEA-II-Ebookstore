package com.nsbm.ebookstore.user.review.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class user_model {
    @Id
    private int userid;
}