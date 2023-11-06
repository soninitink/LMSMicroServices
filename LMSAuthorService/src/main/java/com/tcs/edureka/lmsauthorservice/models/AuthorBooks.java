package com.tcs.edureka.lmsauthorservice.models;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
public class AuthorBooks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @ManyToOne
    private Author author;
    private Long bookId;
}
