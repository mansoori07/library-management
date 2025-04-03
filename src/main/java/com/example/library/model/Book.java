package com.example.library.model;

import com.example.library.model.request.BookRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "book_title")
    private String name;

    @Column(name = "author_name")
    private String author;

    @Column(name = "genre")
    private String genre;

    @Column(name = "book_price")
    private double price;

    @Column(name = "total_books")
    private int totalBooks;

    @Column(name = "remaining_books")
    private int remainingBooks;

    @Column(name = "shelf_name")
    private String shelfName;

//    @JsonIgnore
//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "shelf_id")
//    private Shelf shelf;

    @JsonIgnore
    @ManyToMany(mappedBy = "books", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Member> members;


    public Book(BookRequest bookRequest){
        this.name = bookRequest.getName();
        this.genre = bookRequest.getGenre();
        this.author = bookRequest.getAuthor();
        this.price = bookRequest.getPrice();
        this.members = bookRequest.getMembers();
        this.totalBooks =  bookRequest.getTotalBooks();
        this.remainingBooks = bookRequest.getRemainingBooks();
        this.shelfName = bookRequest.getShelfName();
    }

    public Book(Book book){
        this.id = book.getId();
        this.name = book.getName();
        this.genre = book.getGenre();
        this.author = book.getAuthor();
        this.price = book.getPrice();
        this.members = book.getMembers();
        this.totalBooks =  book.getTotalBooks();
        this.remainingBooks = book.getRemainingBooks();
        this.shelfName = book.getShelfName();
    }

}
