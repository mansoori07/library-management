package com.example.library.repository;

import com.example.library.model.Book;
import com.example.library.model.request.BookRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BookRepository {

    private final IBookRepository bookRepository;

    public Book save(Book book){
        return bookRepository.save(book);
    }

    public List<Book> saveAll(List<Book> books){
        return bookRepository.saveAll(books);
    }

    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    public Book findById(Long id){
        return bookRepository.findById(id)
                .orElseThrow(() ->new RuntimeException("Book not found"));
    }

    public Book findByName(String name) {
        return bookRepository.findByName(name);
    }
}
