package com.example.testprogect.service;

import com.example.testprogect.dto.MemberDTO;
import org.springframework.http.ResponseEntity;

public interface RestTemplateService {
    public String getCKHub();

    public String getName();

    public String getName2();

    public ResponseEntity<MemberDTO> postDTO();

    public ResponseEntity<MemberDTO> addHeader();
}
