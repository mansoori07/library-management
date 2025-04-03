package com.example.library.model;

import com.example.library.model.request.BookRequest;
import com.example.library.model.request.MemberRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "member_book",
            joinColumns = @JoinColumn(name = "member_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private List<Book> books;

    public Member(MemberRequest memberRequest){
        this.name = memberRequest.getName();
        this.phoneNumber = memberRequest.getPhoneNumber();
        this.email = memberRequest.getEmail();
        this.address = memberRequest.getAddress();
        this.setBooks(memberRequest.getBooks());
    }

    public void setBooks(List<Book> bookList){
        this.books = bookList.stream()
                .map(Book::new)
                .collect(Collectors.toList());
    }

}
