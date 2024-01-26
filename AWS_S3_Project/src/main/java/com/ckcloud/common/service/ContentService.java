package com.ckcloud.common.service;

import com.ckcloud.common.domain.ContentRequest;
import com.ckcloud.common.domain.ContentResponse;
import com.ckcloud.common.mapper.ContentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ContentService {

    private final ContentMapper contentMapper;


    /**
     * 게시글 저장
     * @param params - 게시글 정보
     * @return Generated PK
     */
    @Transactional
    public int saveContent(ContentRequest params) {
        contentMapper.save(params);
        return params.getId();
    }

    /**
     * 게시글 상세 정보 조회
     * @param id - PK
     * @return 게시글 상세 정보
     */
    public ContentResponse findContentById(final int id){
        return contentMapper.findById(id);
    }

    /**
     * 게시글 수정
     * @param contentResponse - 게시글 정보
     * @return PK
     */
    public void updateContent(ContentResponse contentResponse){
        contentMapper.update(contentResponse);
        log.info("=== contentResponse === "+contentResponse);

    }

    /**
     * 게시글 삭제
     * @param id - PK
     * @return PK
     */
    public void deleteContent(final int id){
        contentMapper.deleteById(id);
    }

    /**
     * 게시물 리스트 전체 보기
     * @return
     */
    public List<ContentResponse> findAllContent(Model model){
        return contentMapper.findAllContent(model);
    }

}
