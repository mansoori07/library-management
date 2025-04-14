package com.example.library.repository;

import com.example.library.model.MemberBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberBookRepository extends JpaRepository<MemberBook, Long> {
    MemberBook findByMemberIdAndBookId(long memberId, Long bookId);

    void deleteByMemberIdAndBookId(Long id, Long id1);
}
