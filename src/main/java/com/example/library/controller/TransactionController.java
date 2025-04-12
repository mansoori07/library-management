package com.example.library.controller;

import com.example.library.model.Member;
import com.example.library.service.TransactionService;
import com.example.library.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping("/checkout/{bookId}/{memberId}")
    public ResponseEntity<?> bookTransaction(@PathVariable(name = "bookId") Long bookId, @PathVariable(name = "memberId") Long memberId){
        String status = transactionService.bookCheckout(bookId,memberId);
        if(!status.equals("SUCCESS"))
            return new ResponseEntity<>(status, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

}
