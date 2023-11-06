package com.tcs.edureka.lmsauthorservice.repositories;

import com.tcs.edureka.lmsauthorservice.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
