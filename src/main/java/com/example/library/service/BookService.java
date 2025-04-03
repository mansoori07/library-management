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
        List<Book> books = new ArrayList<>();
        try {
            for (BookRequest bookRequest : bookRequests) {
                books.add(save(bookRequest));
            }
        }
        catch(Exception e){
            log.error("{}", String.valueOf(e));
        }
        return books;
    }

    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    public Book findById(Long id){
        return bookRepository.findById(id);
    }
}
