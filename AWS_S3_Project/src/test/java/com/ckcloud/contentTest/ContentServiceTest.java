package com.ckcloud.contentTest;

import com.ckcloud.common.domain.ContentRequest;
import com.ckcloud.common.service.ContentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ContentServiceTest {
    @Autowired
    ContentService contentService;

    @Test
    void saveByForeach(){
        for (int i = 1; i <= 1000; i++) {
            ContentRequest params = new ContentRequest();
            params.setTitle("번 게시글 제목");
            params.setDescription("번 게시글 내용");
            params.setUserId(i);
            params.setKeyword("번째 키워드");
            params.setView(1);
            contentService.saveContent(params);
        }
    }
}
