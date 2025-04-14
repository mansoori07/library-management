package com.example.library.controller;

import com.example.library.model.Book;
import com.example.library.model.request.BookRequest;
import com.example.library.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping("/books/saveAll")
    public ResponseEntity<?> saveAll(@RequestBody List<BookRequest> books){
        try {
            log.info("saveAllRun");
            if(books == null || books.isEmpty())
                return new ResponseEntity<>("BookRequest List cannot be empty", HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(bookService.saveAll(books), HttpStatus.CREATED);
        } catch(Exception ex){
            return new ResponseEntity<>(ex,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/books/save")
    public ResponseEntity<?> save(@RequestBody BookRequest bookRequest){
        try {
            log.info("saveRun");
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
            log.info("getRun");
            Book book = bookService.findById(id);
            if(book == null)
                return new ResponseEntity<>("Book not found with id : "+id,HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(book, HttpStatus.FOUND);
        } catch(Exception ex){
            return new ResponseEntity<>(ex,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("books/get/genre/{genre}")
    public ResponseEntity<?> findByGenre(@PathVariable String genre){
        log.info("get By genre");
        try {
            List<Book> books = bookService.findByGenre(genre);
            if (books == null || books.isEmpty())
                return new ResponseEntity<>("Books not found for genre " + genre, HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(books, HttpStatus.FOUND);
        }catch (Exception ex){
            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("books/get/author/{author}")
    public ResponseEntity<?> findByAuthor(@PathVariable String author){
        log.info("get By author");
        try {
            List<Book> books = bookService.findByAuthor(author);
            if (books == null || books.isEmpty())
                return new ResponseEntity<>("Books not found for author " + author, HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(books, HttpStatus.FOUND);
        }catch (Exception ex){
            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("books/get/min-{minPrice}/max-{maxPrice}")
    public ResponseEntity<?> findByPriceBetween(@PathVariable double minPrice,
                                                @PathVariable double maxPrice){
        log.info("get By price");
        try {
            List<Book> books = bookService.findByPriceBetween(minPrice, maxPrice);
            if (books == null || books.isEmpty())
                return new ResponseEntity<>("Books not found between price range "+minPrice+" to "+maxPrice, HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(books, HttpStatus.FOUND);
        }catch (Exception ex){
            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //get by genre, author

    @GetMapping("/books/getAll")
    public ResponseEntity<?> findAll(){
        try {
            log.info("getAllRun");
            List<Book> books = bookService.findAll();
            if(books == null || books.isEmpty())
                return new ResponseEntity<>("Books not found", HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(books, HttpStatus.FOUND);
        } catch(Exception ex){
            return new ResponseEntity<>(ex,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/books/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable(name = "id") Long id){
        try {
            log.info("delete");
            int size = bookService.deleteById(id);
            if(size<=0)
                return new ResponseEntity<>("Books not found", HttpStatus.NOT_FOUND);
            return new ResponseEntity<>("Deleted "+size+" books with id "+id+".", HttpStatus.FOUND);
        } catch(Exception ex){
            return new ResponseEntity<>(ex,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
