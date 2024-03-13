package com.example.resttemplatetest.test;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


@Service
@RequiredArgsConstructor
@Log4j2
public class RestAPITestService {


    @Value("${tsherpa.api.url}")
    private String tsherpaURL;


    public ResponseEntity<RestAPITestDTO> postResponse() {

        URI uri = UriComponentsBuilder
                .fromUriString(tsherpaURL)
                .path("/item-img/chapters/item-list")
                .encode()
                .build()
                .toUri();

        RestTemplate restTemplate = new RestTemplate();
        return null;
    }
}
