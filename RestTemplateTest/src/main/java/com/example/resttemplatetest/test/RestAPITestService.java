package com.example.resttemplatetest.test;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class RestAPITestService {

    private final RestAPITestMapper restAPITestMapper;


    @Value("${tsherpa.api.uri}")
    private String tsherpaURL;


    public String fetchData(String requestData) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(tsherpaURL, requestData, String.class);
    }
}
