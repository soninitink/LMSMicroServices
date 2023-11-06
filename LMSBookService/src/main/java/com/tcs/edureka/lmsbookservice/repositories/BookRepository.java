package com.tcs.edureka.lmsbookservice.repositories;

import com.tcs.edureka.lmsbookservice.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
