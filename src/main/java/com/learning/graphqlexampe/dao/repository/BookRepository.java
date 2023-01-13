package com.learning.graphqlexampe.dao.repository;

import com.learning.graphqlexampe.dao.entity.Book;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> getBookById(Long id);
    Optional<Book> getBookByName(String name);

}
