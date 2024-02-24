package com.study.domain.member;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.thymeleaf.util.StringUtils;

import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberRequest {

    // 회원가입(INSERT)과 회원정보 수정(UPDATE)에 사용될 요청 클래스입니다.

    private Long id;                // 회원 번호 (PK)
    private String loginId;         // 로그인 ID
    private String password;        // 비밀번호
    private String name;            // 이름
    private Gender gender;          // 성별
    private LocalDate birthday;     // 생년월일

/*    public void encodingPassword(PasswordEncoder passwordEncoder){
        if (StringUtils.isEmpty(password)){
            return;
        }
        password = passwordEncoder.encode(password);
    }*/
}

