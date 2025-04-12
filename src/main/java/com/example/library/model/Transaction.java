package com.example.library.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "book_author")
    private String bookAuthor;

    @Column(name = "member_name")
    private String memberName;

    @Column(name = "member_address")
    private String memberAddress;

    @Column(name = "member_mobile")
    private String memberMobile;

    @Column(name = "borrow_date")
    private Date borrowDate;

    @Column(name = "return_date")
    private Date returnDate;

    public Transaction setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
        return this;
    }

    public Transaction setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
        return this;
    }

    public Transaction setMemberMobile(String memberMobile) {
        this.memberMobile = memberMobile;
        return this;
    }

    public Transaction setMemberName(String memberName) {
        this.memberName = memberName;
        return this;
    }

    public Transaction setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
        return this;
    }

    public Transaction setId(Long id) {
        this.id = id;
        return this;
    }

    public Transaction setBookName(String bookName) {
        this.bookName = bookName;
        return this;
    }

    public Transaction setMemberAddress(Address address){
        this.memberAddress = address.getAddressLine1() +
                ", " + address.getAddressLine2() +
                ", " + address.getCity() +
                ", " + address.getState() +
                ", " + address.getCountry() +
                " - " + address.getPinCode();
        return this;
    }
}
