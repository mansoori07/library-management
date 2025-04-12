package com.example.library.controller;

import com.example.library.model.Member;
import com.example.library.model.request.MemberRequest;
import com.example.library.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/members/saveAll")
    public ResponseEntity<?> saveAll(@RequestBody List<MemberRequest> members){
        try {
            log.info("saveAllRun");
            if(members == null || members.isEmpty())
                return new ResponseEntity<>("MemberRequest List cannot be empty", HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(memberService.saveAll(members), HttpStatus.CREATED);
        } catch(Exception ex){
            return new ResponseEntity<>(ex,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/members/save")
    public ResponseEntity<?> save(@RequestBody MemberRequest memberRequest){
        try {
            log.info("saveRun");
            if(memberRequest == null)
                return new ResponseEntity<>("Member cannot be empty", HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(memberService.save(memberRequest), HttpStatus.CREATED);
        } catch(Exception ex){
            return new ResponseEntity<>(ex,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/members/get/{id}")
    public ResponseEntity<?> findById(@PathVariable(name = "id") Long id){
        try {
            log.info("getRun");
            Member member = memberService.findById(id);
            if(member == null)
                return new ResponseEntity<>("Member not found with id : "+id,HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(member, HttpStatus.FOUND);
        } catch(Exception ex){
            return new ResponseEntity<>(ex,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("members/get/name/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name){
        log.info("get By name");
        try {
            List<Member> members = memberService.findByName(name);
            if (members == null || members.isEmpty())
                return new ResponseEntity<>("Member not found for name " + name, HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(members, HttpStatus.FOUND);
        }catch (Exception ex){
            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("members/get/number/{number}")
    public ResponseEntity<?> findByPhoneNumber(@PathVariable String number){
        log.info("get By genre");
        try {
            List<Member> members = memberService.findByPhoneNumber(number);
            if (members == null || members.isEmpty())
                return new ResponseEntity<>("Members not found for number " + number, HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(members, HttpStatus.FOUND);
        }catch (Exception ex){
            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("members/get/email/{email}")
    public ResponseEntity<?> findByEmail(@PathVariable String email){
        log.info("get By email");
        try {
            List<Member> members = memberService.findByEmail(email);
            if (members == null || members.isEmpty())
                return new ResponseEntity<>("Members not found for email " + email, HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(members, HttpStatus.FOUND);
        }catch (Exception ex){
            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/members/getAll")
    public ResponseEntity<?> findAll(){
        try {
            log.info("getAllRun");
            List<Member> members = memberService.findAll();
            if(members == null || members.isEmpty())
                return new ResponseEntity<>("Members not found", HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(members, HttpStatus.FOUND);
        } catch(Exception ex){
            return new ResponseEntity<>(ex,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/members/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable(name = "id") Long id){
        try {
            log.info("delete");
            int size = memberService.deleteById(id);
            if(size<=0)
                return new ResponseEntity<>("Members not found", HttpStatus.NOT_FOUND);
            return new ResponseEntity<>("Deleted "+size+" members with id "+id+".", HttpStatus.FOUND);
        } catch(Exception ex){
            return new ResponseEntity<>(ex,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
