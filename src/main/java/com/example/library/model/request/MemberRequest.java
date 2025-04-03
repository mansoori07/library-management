package com.example.library.model.request;

import com.example.library.model.Address;
import com.example.library.model.Book;
import com.example.library.model.Member;
import lombok.Data;

import java.util.List;

@Data
public class MemberRequest {
    private String name;
    private String email;
    private String phoneNumber;
    private Address address;
    private List<Book> books;

}
