package com.example.library.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "member_book")
public class MemberBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @Override
    public String toString() {
        return "MemberBook{" +
                "id=" + id +
                ", member=" + member.getId() +
                ", book=" + book.getId() +
                '}';
    }
}
