package com.example.lmsborrowingservice.respositories;

import com.example.lmsborrowingservice.models.Borrower;
import com.example.lmsborrowingservice.models.BorrowerBooks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BorrowerBookRepository extends JpaRepository<BorrowerBooks, Long> {
    List<Long> findAllBooksByBorrowerId(Long id);
    Borrower saveBorrowerBook(Borrower borrower, Long bookId);
}
