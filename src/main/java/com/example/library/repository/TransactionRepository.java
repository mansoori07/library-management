package com.example.library.repository;

import com.example.library.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    Transaction findByBookNameAndMemberMobile(String name, String phoneNumber);

    Transaction findByBookNameAndMemberMobileAndReturnDate(String name, String phoneNumber, Object o);
}
