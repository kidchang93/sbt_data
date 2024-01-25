package com.ckcloud.common.mapper;

import com.ckcloud.common.domain.ContentRequest;
import com.ckcloud.common.domain.ContentResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ContentMapper {


    /**
     * 게시글 저장
     * @param params - 게시글 정보
     */
    void save (ContentRequest params);

    /**
     * 게시글 상세정보 조회
     * @param id - pk
     * @return 게시글 상세정보
     */
    ContentResponse findById(int id);

    /**
     * 게시글 수정
     * @param params - 게시글 정보
     */
    void update (ContentRequest params);

    /**
     * 게시글 삭제
     * @param id - PK
     */
    void deleteById(int id);

    /**
     * 게시글 리스트 조회
     * @return - 게시글 리스트
     */
    List<ContentResponse> findAll();

    /**
     * 게시글 수 카운팅
     * @return 게시글 수
     */
    int count();
}
