package com.ckcloud.common.paging;

import com.ckcloud.common.dto.SearchDTO;
import lombok.Data;
import lombok.Getter;

@Getter

public class Pagination {
    private int totalRecordCount;     // 전체 데이터 수
    private int totalPageCount;       // 전체 페이지 수
    private int startPage;            // 첫 페이지 번호
    private int endPage;              // 끝 페이지 번호
    private int limitStart;           // LIMIT 시작 위치
    private boolean existPrevPage;    // 이전 페이지 존재 여부
    private boolean existNextPage;    // 다음 페이지 존재 여부


    /**
     * COUNT(*) 쿼리의 실행 결과, 즉 전체 게시글 개수를 의미합니다.
     * 당장은 테이블에서 삭제되지 않은 데이터를 기준으로 카운팅 하지만,
     * 검색 기능이 적용된 후에는 검색 조건의 유무에 따라 필터링해서 카운팅합니다.
     * @param totalRecordCount
     * @param params
     */
    public Pagination(int totalRecordCount, SearchDTO params){
        if (totalRecordCount > 0){
            this.totalRecordCount = totalRecordCount;
            calculation(params);
        }
    }

    // 계산식들
    public void calculation (SearchDTO params){
        /**
         * 페이지 하단에 출력할 전체페이지 개수를의미합니다.
         * 테이블에 1,000개의데이터(레코드)가 있고,
         * recordSize(페이지당 출력할 데이터 개수)가 10개라고 가정했을 때,
         * 전체 페이지 개수는 (1,000 / 10)의 결과인 100개가 됩니다.
         */
        // 전체 페이지 수 계산
        totalPageCount = ((totalRecordCount - 1 ) / params.getRecordSize()) + 1;

        // 현재 페이지 번호가 전체 페이지 수 보다 큰 경우 , 현재 페이지 번호에 전체 페이지 수 저장
        if (params.getPage() > totalPageCount){
            params.setPage(totalPageCount);
        }

        /**
         *
         * 현재 페이지네이션의 첫 페이지를 의미합니다. pageSize(화면 하단에 출력할 페이지 개수)가 10이고,
         * page(현재 페이지 번호)가 5라고 가정했을 때 1을 의미합니다. 다른 예로 page가 15일 때
         * startPage는 11이 되고, page가 29일 때 startPage는 21이 됩니다.
         */
        // 첫 페이지 번호 계산
        startPage = ((params.getPage() - 1) / params.getPageSize() * params.getPageSize() + 1);

        /**
         * 현재 페이지네이션의 끝 페이지를 의미합니다. pageSize(화면 하단에 출력할 페이지 개수)가 10이고,
         * page(현재 페이지 번호)가 5라고 가정했을 때 10을 의미합니다.
         * 다른 예로 page가 15일 때 endPage는 20이 되고, page가 29일 때
         * endPage는 30이 됩니다.
        */
        // 끝 페이지 번호 계산
        endPage = startPage + params.getPageSize() - 1;

        // 끝 페이지가 전체 페이지 수 보다 큰 경우 , 끝 페이지 전체 페이지 수 저장
        if (endPage > totalPageCount){
            endPage = totalPageCount;
        }

        /**
         * 현재 findAll 쿼리의 LIMIT 구문에 사용되는 offset과 동일한 기능을 하는 변수입니다.
         * SearchDto의 offset을 대신해서 LIMIT구문의 첫번째 인자로 사용됩니다.
         */

        // LIMIT 시작 위치 계산
        limitStart = (params.getPage() - 1) * params.getRecordSize();



        // 이전 페이지 존재 여부 확인
        existPrevPage = startPage != 1 ;

        /**
         * 다음 페이지의 존재 여부를 확인합니다.
         * recordSize(페이지당 출력할 데이터 개수)가 10개,
         * endPage(끝 페이지 번호)가 10이라고 가정했을 때
         * (10 * 10) = 100이라는 결과가 나오는데요.
         * 만약 totalRecordCount(전체 데이터 개수)가 105개라면,
         * 다음 페이지가 존재한다는 걸 의미합니다.
         */

        // 다음 페이지 존재 여부 확인
        existNextPage = (endPage * params.getRecordSize()) < totalRecordCount;
    }
}
