package com.example.testprogect.service.impl;

import com.example.testprogect.dto.MemberDTO;
import com.example.testprogect.service.RestTemplateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class RestTemplateServiceImpl implements RestTemplateService {
    private final Logger LOGGER = LoggerFactory.getLogger(RestTemplateServiceImpl.class);

    @Override
    public String getCKHub() {
        URI uri =
                UriComponentsBuilder.fromUriString("http://localhost:9090")
                        .path("/api/server/ck-hub")
                        .encode()
                        .build()
                        .toUri();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);

        LOGGER.info("status code : {}", responseEntity.getStatusCode());
        LOGGER.info("body : {}", responseEntity.getBody());

        return responseEntity.getBody();
    }

    @Override
    public String getName() {

        URI uri =
                UriComponentsBuilder.fromUriString("http://localhost:9090")
                        .path("/api/server/name")
                        .queryParam("name", "ChangKyu")
                        .encode()
                        .build()
                        .toUri();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);

        LOGGER.info("status code : {}", responseEntity.getStatusCode());
        LOGGER.info("body : {}", responseEntity.getBody());

        return responseEntity.getBody();
    }

    @Override
    public String getName2() {
        URI uri =
                UriComponentsBuilder.fromUriString("http://localhost:9090")
                        .path("/api/server/path-variable/{name}")
                        .encode()
                        .build()
                        .expand("ChangKyu") // 복수의 값을 넣어야할 경우 , 를 추가하여 구분
                        .toUri();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);

        LOGGER.info("status code : {}", responseEntity.getStatusCode());
        LOGGER.info("body : {}", responseEntity.getBody());

        return responseEntity.getBody();
    }

    @Override
    public ResponseEntity<MemberDTO> postDTO() {
        URI uri =
                UriComponentsBuilder.fromUriString("http://localhost:9090")
                        .path("/api/server/member")
                        .queryParam("name", "ChangKyu")
                        .queryParam("email", "ckHub@ckmail.com")
                        .queryParam("organization", "CK Hub Studio")
                        .encode()
                        .build()
                        .toUri();

        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName("ChangKyu!!");
        memberDTO.setEmail("ckHub@ckmail.com");
        memberDTO.setOrganization("CK Hub Studio!!");

        // queryParam , memberDTO 의 값은 serverBox 에서 어떤 값을 body에 넣어주냐에 따라 다르게 나옴

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<MemberDTO> responseEntity =
                restTemplate.postForEntity(uri, memberDTO, MemberDTO.class);

        LOGGER.info("status code : {}", responseEntity.getStatusCode());
        LOGGER.info("body : {}", responseEntity.getBody());

        return responseEntity;
    }

    @Override
    public ResponseEntity<MemberDTO> addHeader() {
        URI uri =
                UriComponentsBuilder.fromUriString("http://localhost:9090")
                        .path("/api/server/add-header")
                        .encode()
                        .build()
                        .toUri();

        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName("ChangKyu");
        memberDTO.setEmail("ckHub@ckmail.com");
        memberDTO.setOrganization("CK Hub Studio");

        RequestEntity<MemberDTO> requestEntity =
                RequestEntity.post(uri).header("ck-header", "CK Hub Studio").body(memberDTO);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<MemberDTO> responseEntity =
                restTemplate.exchange(requestEntity, MemberDTO.class);

        LOGGER.info("status code : {}", responseEntity.getStatusCode());
        LOGGER.info("body : {}", responseEntity.getBody());

        return responseEntity;
    }
}
