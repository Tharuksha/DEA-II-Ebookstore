package com.nsbm.ebookstore.user.review.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity

public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long userid;
    private String email;
    private String firstname;
    private String lastname;
    private String password;
    private String role;

}
