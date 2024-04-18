package com.example.testprogect.data.repository;

import com.example.testprogect.data.entity.ShortUrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShortUrlRepository extends JpaRepository<ShortUrlEntity, Long> {

    ShortUrlEntity findByUrl(String url);
    ShortUrlEntity findByOrgUrl(String originalUrl);
}
