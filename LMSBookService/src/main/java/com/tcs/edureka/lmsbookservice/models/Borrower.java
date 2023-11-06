package com.tcs.edureka.lmsbookservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Borrower {
    private Long id;
    private LocalDate borrowingDate;
    private LocalDate returnDate;
    private String user;
}
