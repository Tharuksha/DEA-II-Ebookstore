package com.nsbm.ebookstore.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Users {
    @Id //permenent
    private int userid;
}
