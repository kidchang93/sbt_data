package com.study.domain.member;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class MemberResponse {

    // 회원 데이터 조회에 사용될 응답 클래스입니다.
    private Long id;                // 회원 번호 (PK)
    private String loginId;         // 로그인 (ID)
    private String password;        // 비밀 번호
    private String name;            // 이름
    private Gender gender;          // 성별
    private LocalDate birthday;     // 생년월일
    private Boolean deleteYn;       // 삭제여부
    private LocalDateTime createdDate;  // 생성일시
    private LocalDateTime modifiedDate; // 최종 수정일시

    public void clearPassword(){
        this.password = "";
    }
    
}
