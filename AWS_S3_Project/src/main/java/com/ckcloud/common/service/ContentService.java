package com.ckcloud.common.service;

import com.ckcloud.common.domain.ContentRequest;
import com.ckcloud.common.domain.ContentResponse;
import com.ckcloud.common.domain.PagingResponse;
import com.ckcloud.common.dto.SearchDTO;
import com.ckcloud.common.mapper.ContentMapper;
import com.ckcloud.common.paging.Pagination;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.Collections;
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
     * @param params - search conditions
     * @return list & pagination information
     */
    public PagingResponse<ContentResponse> findAllContent(final SearchDTO params){

        // 조건에 해당하는 데이터가 없는 경우 , 응답 데이터에 비어있는 리스트와 null 을 담아 반환
        int count = contentMapper.count(params);
        if (count < 1){
            return new PagingResponse<>(Collections.emptyList(),null);
        }

        // Pagination 객체를 생성해서 페이지 정보를 계산 후 SearchDTO 타입의 객체인 params에 계산된 페이지 정보 저장
        Pagination pagination = new Pagination(count,params);
        params.setPagination(pagination);

        // 계산된 페이지 정보의 일부(limitStart, recordSize)를 기준으로 리스트 데이터 조회 후 응답 데이터 반환
        List<ContentResponse> list = contentMapper.findAllContent(params);
        log.info("리스트 넘어왔냐 "+list);

        return new PagingResponse<>(list,pagination);
    }



}
