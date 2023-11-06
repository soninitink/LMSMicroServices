package com.example.lmsborrowingservice.controllers;

import com.example.lmsborrowingservice.models.Borrower;
import com.example.lmsborrowingservice.respositories.BorrowerBookRepository;
import com.example.lmsborrowingservice.respositories.BorrowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/borrowers")
public class BorrowerController {
    @Autowired
    BorrowerRepository borrowerRepository;
    @Autowired
    BorrowerBookRepository borrowerBookRepository;
    @GetMapping("")
    public List<Borrower> getAllBorrowers(){
        return borrowerRepository.findAll();
    }
    @GetMapping("/{id}")
    public Borrower getBorrowerById(@PathVariable long id){
        return borrowerRepository.findById(id).orElse(null);
    }
    @GetMapping("/books/{id}")
    public List<Long> getAllBorrowedBooks(@PathVariable long id){
        return borrowerBookRepository.findAllBooksByBorrowerId(id);
    }
    @PostMapping
    public void createBorrower(@RequestBody Borrower borrower){
        borrowerRepository.save(borrower);
    }
    @PostMapping("/books/{bookId}")
    public Borrower createAuthorBook(@PathVariable long bookId, @RequestBody Borrower borrower){
        return borrowerBookRepository.saveBorrowerBook(borrower, bookId);
    }

}
