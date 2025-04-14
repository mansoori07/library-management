package com.example.library.controller;

import com.example.library.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping("/check-out/{bookId}/{memberId}")
    public ResponseEntity<?> bookTransaction(@PathVariable(name = "bookId") Long bookId, @PathVariable(name = "memberId") Long memberId){
        String status = transactionService.bookCheckOut(bookId,memberId);
        if(!status.equals("SUCCESS"))
            return new ResponseEntity<>(status, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @PostMapping("/check-in/{bookId}/{memberId}")
    public ResponseEntity<?> bookInTransaction(@PathVariable(name = "bookId") Long bookId, @PathVariable(name = "memberId") Long memberId){
        String status = transactionService.bookCheckIn(bookId,memberId);
        if(!status.equals("SUCCESS"))
            return new ResponseEntity<>(status, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

}
