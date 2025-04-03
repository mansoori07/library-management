package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.model.CheckOutRecord;
import com.example.library.model.Member;
import com.example.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@RequiredArgsConstructor
public class CheckOutService {

    private final BookRepository bookRepository;

    public void bookChekOut(Long id, Member member){

        Book book = bookRepository.findById(id);

        if(book == null){
            throw new NullPointerException();
        }
        CheckOutRecord checkout = createCheckOutDetails(book, member);

        

    }

    private CheckOutRecord createCheckOutDetails(Book book, Member member) {
        CheckOutRecord checkout = new CheckOutRecord();
        checkout.setBookName(book.getName());
        checkout.setBookAuthor(book.getAuthor());
        checkout.setMemberName(member.getName());
        checkout.setMemberEmail(member.getEmail());
        checkout.setBorrowDate(new Date());
        return checkout;
    }

}
