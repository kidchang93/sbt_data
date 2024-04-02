package com.example.testprogect.controller;

import com.example.testprogect.dto.MemberDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {

    @PutMapping(value = "/default")
    public String putMethod(){
        return "Hello putWorld";
    }

    @PutMapping(value = "/member")
    public String postMember(@RequestBody Map<String,Object> postData){
        StringBuilder sb = new StringBuilder();

        postData.entrySet().forEach(map ->{
            sb.append(map.getKey() + " : " + map.getValue() + "\n");

        });
        return sb.toString();
    }

    @PutMapping(value = "/member1")
    public String postMemberDTO1(@RequestBody MemberDTO memberDTO){
        return memberDTO.toString();
    }
    @PutMapping("/member2")
    public MemberDTO postMemberDTO2(@RequestBody MemberDTO memberDTO){
        return memberDTO;
    }
    @PutMapping("/member3")
    public ResponseEntity<MemberDTO> postMemberDTO3(@RequestBody MemberDTO memberDTO){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(memberDTO);
    }
}

