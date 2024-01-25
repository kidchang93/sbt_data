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
    void save(){
        ContentRequest params = new ContentRequest();
        params.setTitle("1번게시글 제목");
        params.setDescription("1번게시글 내용");

        int id = contentService.saveContent(params);
        System.out.println("생성된 게시글 ID : " + id);
    }
}
