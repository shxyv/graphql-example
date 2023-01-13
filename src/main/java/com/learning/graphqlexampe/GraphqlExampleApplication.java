package com.learning.graphqlexampe;

import com.learning.graphqlexampe.dao.entity.Book;
import com.learning.graphqlexampe.dao.repository.BookRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RequiredArgsConstructor
public class GraphqlExampleApplication {

    private final BookRepository bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(GraphqlExampleApplication.class, args);
    }

    @Bean
    ApplicationRunner applicationRunner() {
        return args -> {
            Book book1 = Book.builder()
                    .id(1L)
                    .name("book1")
                    .description("description")
                    .authorName("name1")
                    .build();

            Book book2 = Book.builder()
                    .id(2L)
                    .name("book2")
                    .description("description2")
                    .authorName("name2")
                    .build();

            Book book3 = Book.builder()
                    .id(3L)
                    .name("book2")
                    .description("description3")
                    .authorName("name2")
                    .build();

            bookRepository.saveAll(List.of(book1, book2, book3));
        };
    }
}
