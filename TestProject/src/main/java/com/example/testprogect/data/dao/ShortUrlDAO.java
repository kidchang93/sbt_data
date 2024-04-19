package com.example.testprogect.data.dao;

import com.example.testprogect.data.entity.ShortUrlEntity;

public interface ShortUrlDAO {
    ShortUrlEntity saveShortUrl(ShortUrlEntity shortUrlEntity);

    ShortUrlEntity getShortUrl(String originalUrl);

    ShortUrlEntity getOriginalUrl(String shortUrl);
    ShortUrlEntity updateShortUrl(ShortUrlEntity newShortUrl);
    void deleteByShortUrl(String shortUrl);
    void deleteByOriginalUrl(String originalUrl);
}
