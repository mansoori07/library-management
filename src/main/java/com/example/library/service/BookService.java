package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.model.request.BookRequest;
import com.example.library.repository.BookRepository;
import com.example.library.utils.CommonUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

    private static final Logger log = LoggerFactory.getLogger(BookService.class);
    private final BookRepository bookRepository;

    public Book save(BookRequest bookRequest){
        Book book = bookRepository.findByName(bookRequest.getName());
        CommonUtils ob = new CommonUtils();
        if(book == null){
            book =  ob.convertToModel(bookRequest);
            book.setRemainingBooks(bookRequest.getTotalBooks());
        } else{
          updateBooksCount(book, bookRequest);
        }

        log.info("Final result : {}",book);
        return bookRepository.save(book);
    }

    public void updateBooksCount(Book book, BookRequest bookRequest) {
        book.setRemainingBooks(book.getRemainingBooks()+bookRequest.getTotalBooks());
        book.setTotalBooks(book.getTotalBooks()+bookRequest.getTotalBooks());
    }

    @Transactional(rollbackOn = Exception.class)
    public List<Book> saveAll(List<BookRequest> bookRequests){
        CommonUtils cu = new CommonUtils();
        List<Book> books = bookRequests.stream().map(cu::convertToModel).collect(Collectors.toList());
        log.info(bookRequests.stream().map(cu::convertToModel).toList().toString());
        log.info(books.toString());
        return bookRepository.saveAll(books);
    }

    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    public Book findById(Long id){
        return bookRepository.findById(id).orElse(null);
    }

    public int deleteById(Long id){
        List<Book> books = bookRepository.findAll()
                .stream()
                .filter(book -> Objects.equals(id, book.getId()))
                .toList();
        log.info(books.toString());
        if(books.isEmpty()){
            return -1;
        }
        bookRepository.deleteById(id);
        return books.size();
    }

    public List<Book> findByGenre(String genre) {
        return bookRepository.findByGenre(genre);
    }

    public List<Book> findByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    public List<Book> findByPriceBetween(double minPrice, double maxPrice) {
        return bookRepository.findByPriceBetween(minPrice, maxPrice);
    }
}
