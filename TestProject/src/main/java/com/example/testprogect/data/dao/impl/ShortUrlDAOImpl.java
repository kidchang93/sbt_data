package com.example.testprogect.data.dao.impl;

import com.example.testprogect.data.dao.ShortUrlDAO;
import com.example.testprogect.data.entity.ShortUrlEntity;
import com.example.testprogect.data.repository.ShortUrlRepository;
import org.springframework.stereotype.Component;

@Component
public class ShortUrlDAOImpl implements ShortUrlDAO {

    private final ShortUrlRepository shortUrlRepository;

    public ShortUrlDAOImpl(ShortUrlRepository shortUrlRepository) {
        this.shortUrlRepository = shortUrlRepository;
    }

    @Override
    public ShortUrlEntity saveShortUrl(ShortUrlEntity shortUrlEntity) {
        ShortUrlEntity foundShortUrl = shortUrlRepository.save(shortUrlEntity);
        return foundShortUrl;
    }

    @Override
    public ShortUrlEntity getShortUrl(String originalUrl) {
        ShortUrlEntity foundShortUrl = shortUrlRepository.findByOrgUrl(originalUrl);
        return foundShortUrl;
    }
}
