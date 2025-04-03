package com.example.library.controller;

import com.example.library.model.Book;
import com.example.library.model.request.BookRequest;
import com.example.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping("/books/saveAll")
    public ResponseEntity<?> saveAll(@RequestBody List<BookRequest> books){
        try {
            if(books == null || books.isEmpty())
                return new ResponseEntity<>("Book List cannot be empty", HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(bookService.saveAll(books), HttpStatus.CREATED);
        } catch(Exception ex){
            return new ResponseEntity<>(ex,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/books/save")
    public ResponseEntity<?> save(@RequestBody BookRequest bookRequest){
        try {
            if(bookRequest == null)
                return new ResponseEntity<>("Book cannot be empty", HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(bookService.save(bookRequest), HttpStatus.CREATED);
        } catch(Exception ex){
            return new ResponseEntity<>(ex,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/books/get/{id}")
    public ResponseEntity<?> findById(@PathVariable(name = "id") Long id){
        try {
            return new ResponseEntity<>(bookService.findById(id), HttpStatus.FOUND);
        } catch(Exception ex){
            return new ResponseEntity<>(ex,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/books/getAll")
    public ResponseEntity<?> findAll(){
        try {
            return new ResponseEntity<>(bookService.findAll(), HttpStatus.FOUND);
        } catch(Exception ex){
            return new ResponseEntity<>(ex,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
