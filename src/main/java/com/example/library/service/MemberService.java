package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.model.Member;
import com.example.library.model.request.MemberRequest;
import com.example.library.repository.MemberRepository;
import com.example.library.utils.CommonUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member save(MemberRequest memberRequest){
        CommonUtils cu = new CommonUtils();
        Member member = cu.convertToMemberModel(memberRequest);
        return memberRepository.save(member);
    }

    public List<Member> saveAll(List<MemberRequest> members){
        CommonUtils cu = new CommonUtils();
        List<Member> memberList = members.stream()
                .map(cu::convertToMemberModel)
                .collect(Collectors.toList());
        return memberRepository.saveAll(memberList);
    }

    public Member findById(Long id){
        return memberRepository.findById(id).orElse(null);
    }

    public List<Member> findAll(){
        return memberRepository.findAll();
    }


    public List<Member> findByName(String name) {
        return memberRepository.findByName(name);
    }

    public List<Member> findByPhoneNumber(String number) {
        return memberRepository.findByPhoneNumber(number);
    }


    public List<Member> findByEmail(String email) {
        return memberRepository.findByEmail(email);
    }

    public int deleteById(Long id) {
        List<Member> members = memberRepository.findAll()
                .stream()
                .filter(member -> Objects.equals(id, member.getId()))
                .toList();
        log.info(members.toString());
        if(members.isEmpty()){
            return -1;
        }
        memberRepository.deleteById(id);
        return members.size();
    }
}
