package com.tcs.edureka.lmsbookservice.controllers;

import com.tcs.edureka.lmsbookservice.models.Author;
import com.tcs.edureka.lmsbookservice.models.Book;
import com.tcs.edureka.lmsbookservice.models.Borrower;
import com.tcs.edureka.lmsbookservice.services.BookService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    BookService bookService;
    @Autowired
    public BookController(BookService bookService){
        this.bookService = bookService;
    }
    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }
    @GetMapping("{id}")
    public Book getBookById(@PathVariable long id){
        return bookService.getBookById(id);
    }
    @PostMapping
    public Book createBook(@RequestBody Book book){
        return bookService.createBook(book);
    }
    @GetMapping("/authors/{id}")
    public Author getAuthorById(@PathVariable long id){
        return bookService.getAuthorById(id);
    }
    @GetMapping("/borrowers/{id}")
    public Borrower getBorrowerById(@PathVariable long id){
        return  bookService.getBorrowerById(id);
    }
    @GetMapping("/authors/{id}/books")
    public List<Book> getAllBooksByAuthorId(@PathVariable long id){
        return bookService.getAllBooksByAuthorId(id);
    }
    @GetMapping("/borrowers/{id}/books")
    public List<Book> getAllBooksByBorrowerId(@PathVariable long id){
        return bookService.getAllBooksByBorrowerId(id);
    }
    @PutMapping("authors/{authorId}/books/{bookId}")
    public Book updateAuthorBook(@PathVariable long bookId, @PathVariable long authorId){
        return bookService.updateAuthorBook(bookId, authorId);
    }
    @PutMapping("borrowers/{borrowerId}/books/{bookId}")
    public Book updateBorrowerBook(@PathVariable long bookId, @PathVariable long borrowerId){
        return bookService.updateBorrowerBook(bookId, borrowerId);
    }
    @DeleteMapping("borrowers/{borrowerId}/books/{bookId}")
    public Book returnBook(@PathVariable long bookId,@PathVariable long borrowerId){
        return bookService.returnBook(bookId, borrowerId);
    }
}
