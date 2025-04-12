package com.example.library.model.request;

import com.example.library.model.Book;
import lombok.Data;

import java.util.List;

@Data
public class MemberRequest {
    private String name;
    private String email;
    private String phoneNumber;
}
