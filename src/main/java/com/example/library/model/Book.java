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

    @JsonIgnore
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MemberBook> memberBooks;


    public Book(BookRequest bookRequest){
        this.name = bookRequest.getName();
        this.genre = bookRequest.getGenre();
        this.author = bookRequest.getAuthor();
        this.price = bookRequest.getPrice();
        this.totalBooks =  bookRequest.getTotalBooks();
        this.remainingBooks = bookRequest.getRemainingBooks();
        this.shelfName = bookRequest.getShelfName();
    }

    @Override
    public String toString() {
        return "Book{" +
                "shelfName='" + shelfName + '\'' +
                ", remainingBooks=" + remainingBooks +
                ", totalBooks=" + totalBooks +
                ", price=" + price +
                ", genre='" + genre + '\'' +
                ", author='" + author + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
