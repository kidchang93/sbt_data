package com.example.testprogect.service;

import com.example.testprogect.data.dto.ShortUrlResponseDTO;

public interface ShortUrlService {
    ShortUrlResponseDTO generateShortUrl(String clientId, String clientSecret, String originalUrl);
    ShortUrlResponseDTO getShortUrl(String clientId, String clientSecret, String originalUrl);
    ShortUrlResponseDTO updateShortUrl(String clientId, String clientSecret, String originalUrl);
    void deleteShortUrl(String url);
}
