package com.example.library.repository;

import com.example.library.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IMemberRepository extends JpaRepository<Member, Long> {

    Optional<List<Member>> findByName(String name);


}
