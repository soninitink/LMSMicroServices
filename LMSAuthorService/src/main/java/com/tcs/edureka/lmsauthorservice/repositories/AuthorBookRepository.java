package com.tcs.edureka.lmsauthorservice.repositories;

import com.tcs.edureka.lmsauthorservice.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AuthorBookRepository extends JpaRepository<AuthorBookRepository, Long> {
    List<Long> findAllBooksByAuthorId(Long id);
    void saveAuthorBook(Author author, Long bookId);
}
