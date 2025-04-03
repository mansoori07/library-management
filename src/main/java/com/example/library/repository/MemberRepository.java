package com.example.library.repository;

import com.example.library.model.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final IMemberRepository memberRepository;

    public Member findById(Long id){
        return memberRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("User not found"));
    }

    public List<Member> findAll(){
        return memberRepository.findAll();
    }

    public List<Member> findByName(String name){
        return memberRepository.findByName(name)
                .orElseThrow(()-> new RuntimeException("User with name "+name+" does not exists."));
    }

}
