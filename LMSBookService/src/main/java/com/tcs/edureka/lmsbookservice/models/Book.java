package com.tcs.edureka.lmsbookservice.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String ISBN;
    private Long authorId; // Instead of the whole author object, we're storing authorId
    @Enumerated(EnumType.STRING)
    private BookStatus status;
}
