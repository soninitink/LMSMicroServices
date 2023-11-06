package com.tcs.edureka.lmsbookservice.services;

import com.tcs.edureka.lmsbookservice.models.Author;
import com.tcs.edureka.lmsbookservice.models.Book;
import com.tcs.edureka.lmsbookservice.models.BookStatus;
import com.tcs.edureka.lmsbookservice.models.Borrower;
import com.tcs.edureka.lmsbookservice.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    BookRepository bookRepository;
    RestTemplate restTemplate;
    @Autowired
    public BookService(BookRepository bookRepository, RestTemplate restTemplate){
        this.bookRepository = bookRepository;
        this.restTemplate = restTemplate;
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
    public Book getBookById(long id){
        return bookRepository.findById(id).orElse(null);
    }
    public Book createBook(Book book){
        return bookRepository.save(book);
    }
    public Author getAuthorById(long authorId){
        return  restTemplate.getForObject("http://localhost:8081/api/authors" + authorId, Author.class);
    }

    public Borrower getBorrowerById(long borrowerId){
        return restTemplate.getForObject("http://localhost:8083/api/borrowers" + borrowerId, Borrower.class);
    }

    public List<Book> getAllBooksByAuthorId(long authorId){
        List<Long> bookIds =  restTemplate.getForObject("http://localhost:8081/api/authors/books/" + authorId, List.class);
        if(bookIds != null)
            return bookRepository.findAllById(bookIds);
        return null;
    }
    public List<Book> getAllBooksByBorrowerId(long borrowerId){
        List<Long> bookIds =  restTemplate.getForObject("http://localhost:8083/api/borrowers/books/" + borrowerId, List.class);
        if(bookIds != null)
            return bookRepository.findAllById(bookIds);
        return null;
    }
    public Book updateAuthorBook(long bookId, long authorId){
        Author author = getAuthorById(authorId);
        restTemplate.postForEntity("http://localhost:8081/api/authors/books/" + bookId, author, Author.class);
        Book book  = bookRepository.findById(bookId).orElse(null);
        if(book != null) {
            return bookRepository.save(book);
        }
        return null;
    }
    public Book updateBorrowerBook(long bookId, long borrowerId){
        Book book  = bookRepository.findById(bookId).orElse(null);
        if(book != null && book.getStatus() == BookStatus.AVAILABLE) {
            Borrower borrower = getBorrowerById(borrowerId);
            restTemplate.postForEntity("http://localhost:8083/api/borrowers/books/" + bookId, borrower, Borrower.class);
            book.setStatus(BookStatus.BORROWED);
            return bookRepository.save(book);
        }
        else if(book != null)
            return book;
        return null;
    }
    public Book returnBook(long bookId, long borrowerId){
        Book book = bookRepository.findById(bookId).orElse(null);
        if(book != null){
            //TODO: delete mapping in borrower service
            book.setStatus(BookStatus.AVAILABLE);
            return bookRepository.save(book);
        }
        return null;
    }


}
