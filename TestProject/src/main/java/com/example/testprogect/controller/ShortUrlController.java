package com.example.testprogect.controller;

import com.example.testprogect.data.dto.ShortUrlResponseDTO;
import com.example.testprogect.service.ShortUrlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/short-url")
public class ShortUrlController {

    private final Logger LOGGER = LoggerFactory.getLogger(ShortUrlController.class);

    @Value("${ck.hub.short.url.id}")
    private String CLIENT_ID;

    @Value("${ck.hub.short.url.secret}")
    private String CLIENT_SECRET;


    ShortUrlService shortUrlService;

    @Autowired
    public ShortUrlController(ShortUrlService shortUrlService){
        this.shortUrlService = shortUrlService;
    }

    @PostMapping()
    public ShortUrlResponseDTO generateShortUrl(String originalUrl){
        LOGGER.info("[generateShortUrl] perform API. CLIENT_ID : {} , CLIENT_SECRET : {}",CLIENT_ID,CLIENT_SECRET);
        return shortUrlService.generateShortUrl(CLIENT_ID,CLIENT_SECRET,originalUrl);
    }

    @GetMapping
    public ShortUrlResponseDTO getShortUrl(String originalUrl){
        /*long startTime = System.currentTimeMillis();
        ShortUrlResponseDTO shortUrlResponseDTO = shortUrlService.getShortUrl(CLIENT_ID,CLIENT_SECRET,originalUrl);
        long endTime = System.currentTimeMillis();

        LOGGER.info("[getShortUrl] response Time : {}ms",(endTime - startTime));
        return shortUrlResponseDTO;*/


        ShortUrlResponseDTO shortUrlResponseDTO = new ShortUrlResponseDTO("ss","ss");
        return shortUrlService.getShortUrl(CLIENT_ID,CLIENT_SECRET,originalUrl);
    }

    @PutMapping("/")
    public ShortUrlResponseDTO updateShortUrl(String originalUrl){
        return null;
    }

    @DeleteMapping("/")
    public ResponseEntity<String> deleteShortUrl(String url){
        try{
            shortUrlService.deleteShortUrl(url);
        } catch (RuntimeException e){
            e.printStackTrace();
        }

        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제 되었습니다.");

    }
}
