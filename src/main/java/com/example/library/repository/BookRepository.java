package com.example.library.repository;

import com.example.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByName(String name);

    List<Book> findByGenre(String genre);

    List<Book> findByPriceBetween(double min, double max);

    List<Book> findByAuthor(String author);
}
