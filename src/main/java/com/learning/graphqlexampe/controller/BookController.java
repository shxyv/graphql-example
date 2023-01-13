package com.learning.graphqlexampe.controller;


import com.learning.graphqlexampe.dao.entity.Book;
import com.learning.graphqlexampe.model.BookRequest;
import com.learning.graphqlexampe.service.BookService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @QueryMapping
    public Book bookById(@Argument Long id) {
        return bookService.getById(id);
    }

    @QueryMapping
    public List<Book> books() {
        return bookService.getAll();
    }

    @MutationMapping
    public Book saveBook(@Argument BookRequest book) {
        return bookService.saveBook(book);
    }

}
