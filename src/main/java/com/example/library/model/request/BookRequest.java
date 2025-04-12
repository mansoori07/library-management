package com.example.library.model.request;

import com.example.library.model.Member;
import lombok.Data;

import java.util.List;

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
