package com.example.library.model.request;

import lombok.Data;

@Data
public class BookRequest {

    private String name;

    private String author;

    private String genre;

    private double price;

    private int totalBooks;

    private int remainingBooks;

    private String shelfName;

}
