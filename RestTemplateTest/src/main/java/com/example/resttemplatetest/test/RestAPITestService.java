package com.example.resttemplatetest.test;

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
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class RestAPITestService {
    private final RestAPITestMapper restAPITestMapper;

    @Value("${tsherpa.api.uri}")
    private String tsherpaURL;
    public List testPage(RestAPITestDTO restAPITestDTO) {
        String response = postRequest(restAPITestDTO);
        List list = ResponseEntityToDTOList(response);
        return list;
    }

    private String postRequest(RestAPITestDTO restAPITestDTO){

        URI uri = UriComponentsBuilder
                .fromUriString(tsherpaURL)
                .path("/item-img/chapters/item-list")
                .encode()
                .build()
                .toUri();

        HttpEntity<RestAPITestDTO> request = new HttpEntity<>(restAPITestDTO);
        log.info("postwithParamAndBody request : " + request);

        String response;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(uri,request,String.class);

        response = responseEntity.getBody();

        return response;
    }

    private List ResponseEntityToDTOList (String response) throws ParseException {
        JSONParser parser = new JSONParser();
        JsonObject data = (JsonObject) parser.parse(response);


    }
}
