package com.learning.graphqlexampe.service;

import com.learning.graphqlexampe.dao.entity.Book;
import com.learning.graphqlexampe.dao.repository.BookRepository;
import com.learning.graphqlexampe.model.BookRequest;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public Book getById(Long id) {
        return bookRepository.getBookById(id)
                .orElseThrow();
    }

    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public Optional<Book> getByName(String name) {
        return bookRepository.getBookByName(name);
    }

    public Book saveBook(BookRequest bookRequest) {

        getByName(bookRequest.getName()).ifPresent(book -> {
            throw new RuntimeException("Book already exists!");
        });

        Book newBook = Book.builder()
                .name(bookRequest.getName())
                .description(bookRequest.getDescription())
                .authorName(bookRequest.getAuthorName())
                .build();

        return bookRepository.save(newBook);
    }


}
