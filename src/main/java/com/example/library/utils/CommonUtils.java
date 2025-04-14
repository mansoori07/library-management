package com.example.library.utils;

import com.example.library.enums.ShelfType;
import com.example.library.model.Book;
import com.example.library.model.Member;
import com.example.library.model.Transaction;
import com.example.library.model.request.BookRequest;
import com.example.library.model.request.MemberRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class CommonUtils {

    public static byte[] generatePDF(List<Transaction> checkout) {

        return new byte[10];
    }

    public Book convertToModel(BookRequest bookRequest) {
        try {
            findShelf(bookRequest);
        } catch (Exception e) {
            log.error("{}", String.valueOf(e));
        }
        return new Book(bookRequest);
    }

    public void findShelf(BookRequest bookRequest) {
        String genre = bookRequest.getGenre();
        try{
        switch(genre.toUpperCase()) {
            case "LITERATURE":
                bookRequest.setShelfName(ShelfType.LITERATURE.getShelfName());
                break;
            case "SCIENCE":
                bookRequest.setShelfName(ShelfType.SCIENCE.getShelfName());
                break;
            case "HISTORY":
                bookRequest.setShelfName(ShelfType.HISTORY.getShelfName());
                break;
            case "FICTION":
                bookRequest.setShelfName(ShelfType.FICTION.getShelfName());
                break;
            case "COOKING":
                bookRequest.setShelfName(ShelfType.COOKING.getShelfName());
                break;
            case "TRAVEL":
                bookRequest.setShelfName(ShelfType.TRAVEL.getShelfName());
                break;
            case "ART":
                bookRequest.setShelfName(ShelfType.ART.getShelfName());
                break;
            case "PHILOSOPHY":
                bookRequest.setShelfName(ShelfType.PHILOSOPHY.getShelfName());
                break;
            case "SCI_FI":
                bookRequest.setShelfName(ShelfType.SCI_FI.getShelfName());
                break;
            case "BIOGRAPHY":
                bookRequest.setShelfName(ShelfType.BIOGRAPHY.getShelfName());
                break;
            case "TECHNOLOGY":
                bookRequest.setShelfName(ShelfType.TECHNOLOGY.getShelfName());
                break;
            case "KIDS":
                bookRequest.setShelfName(ShelfType.KIDS.getShelfName());
                break;
            default:
                throw new RuntimeException("Shelf not found");
        }
        } catch(Exception ex){
            log.error("{}", String.valueOf(ex));
        }
    }

    public Member convertToMemberModel(MemberRequest memberRequest) {
        return new Member(memberRequest);
    }
}
