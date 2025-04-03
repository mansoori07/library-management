package com.example.library.model.request;

import com.example.library.model.Book;
import com.example.library.model.Member;
import com.example.library.model.Shelf;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
public class BookRequest extends Book {

    private String name;

    private String author;

    private String genre;

    private double price;

    private int originalQuantity;

    private int remainingQuantity;

    private Shelf shelf;

    private List<Member> members;

}
