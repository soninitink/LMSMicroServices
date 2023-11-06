package com.tcs.edureka.lmsauthorservice.controllers;

import com.tcs.edureka.lmsauthorservice.models.Author;
import com.tcs.edureka.lmsauthorservice.repositories.AuthorBookRepository;
import com.tcs.edureka.lmsauthorservice.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private AuthorBookRepository authorBookRepository;
    @GetMapping
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }
    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable long id){
        return authorRepository.findById(id).orElse(null);
    }
    @GetMapping("/books/{id}")
    public List<Long> getAllBooksByAuthor(@PathVariable long id){
        return authorBookRepository.findAllBooksByAuthorId(id);
    }
    @PostMapping
    public Author createAuthor(@RequestBody Author author) {
        return authorRepository.save(author);
    }
    @PostMapping("/books/{bookId}")
    public void createAuthorBook(@PathVariable long bookId, @RequestBody Author author){
        authorBookRepository.saveAuthorBook(author, bookId);
    }
}

