# 💻 ThymeLeaf * SpringBoot 게시판 프로젝트

#### I am continuing to develop this project.

### INDEX
- [프로젝트 소개](#프로젝트-소개)
1. [개발 환경](#1-개발-환경)
2. [개발 기간 및 작업 관리](#2-개발-기간-및-작업-관리)
3. [구현 기능](#3-구현-기능)
4. [개인 회고](#4-개인-회고)

<br>

## 프로젝트 소개

### 👨‍🏫 목표
- 그동안 JSP만 사용해서 다른 web 구현 방식인 ThymeLeaf 를 사용해보고 
<br> springBoot에서 자주 사용하는 RestApi 방식도 경험.
- JavaScript 배운 내용 토대로 ajax 사용과 SPA 까진 아니더라도
<br> 댓글 기능을 구현하면서 조금이라도 SPA 맛보기.
### 🔍 특징
- 전체적인 layout 구성.
- RestApi 부분 적용
- ThymeLeaf / 사용
- AOP 적용 (Log Interceptor)
- 공통 메서드 분리
- jQuery를 적극사용하기보단 JavaScript문법을 많이 사용
- DTO 분리 사용
- Service 단에서 최대한 로직 수행.



<br>

## 1. 개발 환경

**Back-End**
<div>
<img src="https://img.shields.io/badge/springboot-6CB52D?style=for-the-badge&logo=springboot&logoColor=white">
<img src="https://img.shields.io/badge/Java-664B00?style=for-the-badge&logo=Java&logoColor=white">
<img src="https://img.shields.io/badge/Servlet-e42c2e?style=for-the-badge&logo=servlet&logoColor=white"><br>
<img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white">
<img src="https://img.shields.io/badge/MariaDB-003545?style=for-the-badge&logo=mariadb&logoColor=white"> 
<img src="https://img.shields.io/badge/Mybatis-000000?style=for-the-badge&logo=Fluentd&logoColor=fff"/><br>
<img src="https://img.shields.io/badge/SPRING_SECURITY-6CB52D?style=for-the-badge&logo=SPRINGSECURITY&logoColor=white"/>
</div>
<br>

**Front-End**
<div>
<img src="https://img.shields.io/badge/thymeleaf-005C0F?style=for-the-badge&logo=thymeleaf&logoColor=white">
<img src="https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=HTML5&logoColor=fff"/>
<img src="https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=CSS3&logoColor=fff"/>
<img src="https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=JavaScript&logoColor=fff"/><br>
<img src="https://img.shields.io/badge/bootstrap-7952B3?style=for-the-badge&logo=bootstrap&logoColor=fff"/>
<img src="https://img.shields.io/badge/jquery-0769AD?style=for-the-badge&logo=jquery&logoColor=fff"/>
<img src="https://img.shields.io/badge/ajax-0B2343?style=for-the-badge&logo=ajax&logoColor=fff"/>
</div> 
<br>

**Tools**
<div>
<img src="https://img.shields.io/badge/IntelliJIDEA-000000?style=for-the-badge&logo=intellijidea&logoColor=white">
<img src="https://img.shields.io/badge/DBeaver-362822?style=for-the-badge&logo=dbeaver&logoColor=white"><br>  
<img src="https://img.shields.io/badge/AWS-232F3E?style=for-the-badge&logo=amazonaws&logoColor=white">
<img src="https://img.shields.io/badge/RDS-527FFF?style=for-the-badge&logo=amazonrds&logoColor=white">
<img src="https://img.shields.io/badge/EC2-FF9900?style=for-the-badge&logo=amazonec2&logoColor=white">
<img src="https://img.shields.io/badge/S3-3DB7CC?style=for-the-badge&logo=amazons3&logoColor=white">
</div>  
<br>

**Collaboration**
<div>
<img src="https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=GitHub&logoColor=white">
<img src="https://img.shields.io/badge/Notion-000000?style=for-the-badge&logo=Notion&logoColor=white">
</div>
<br>

## 2. 개발 기간 및 작업 관리

### 개발 기간

<details>
  <summary>전체 개발 기간 : 2024-01-27 ~ ing </summary>

</details>

<br>

### 작업 관리

- GitHub로 코드 형상관리.

<br>


## 3. 구현 기능

### [ 메인 페이지 리스트 ]
- 메인 페이지 레이아웃과 리스트 출력
<br>
![(타임리프)메인페이지리스트](https://github.com/kidchang93/sbt_data/assets/145524731/a04a83f2-1e2c-41ee-b5f1-6370cbc53cb9)

### [ 게시글 작성 ]
- 게시글 작성 / 유효성 검사
  <br>
![(타임리프)게시글작성](https://github.com/kidchang93/sbt_data/assets/145524731/26e50776-6b3a-47e8-b4a0-db96bff2ebc2)

### [ 게시글 상세보기 ]
- 게시글 조회 / 댓글 기능 포함
  <br>
![(타임리프)게시글상세보기](https://github.com/kidchang93/sbt_data/assets/145524731/0abb6c75-71e8-4b6a-90a5-170cd0131c29)

### [ 게시글 수정 ]
- 게시글 수정 / 유효성 검사
  <br>
![(타임리프)게시글수정](https://github.com/kidchang93/sbt_data/assets/145524731/6df7c972-0ee7-4df2-a8c7-b36a0c52162f)
![(타임리프)게시글수정1](https://github.com/kidchang93/sbt_data/assets/145524731/1e8a1ecf-c0c9-4b12-8f55-f978758de064)

### [ 댓글 작성 ]
- 댓글 작성 / 하단 글자수 count
  <br>
![(타임리프)댓글작성](https://github.com/kidchang93/sbt_data/assets/145524731/08569593-43a4-4384-a1d6-5d6b8c10c05e)

### [ 댓글 수정 ]
- 댓글 수정 Modal 화면
  <br>
![(타임리프)댓글수정](https://github.com/kidchang93/sbt_data/assets/145524731/19bd7da2-5724-49e0-ba5f-52a9ff6ebf1a)

### [ 댓글 RestApi 적용 ]
- RestApi 적용
  <br>
![(타임리프)댓글RESTAPI방식적용](https://github.com/kidchang93/sbt_data/assets/145524731/76c153b2-ea6c-4cf7-8fce-d08c1722df89)

### [ 공통 Ajax 함수 분리 ]
- 공통 Ajax 함수 분리
  <br>
![(타임리프)공통Ajax함수분리](https://github.com/kidchang93/sbt_data/assets/145524731/a5a3f649-d67b-496b-bfa1-e272dba3bcc1)

### [ ajax 새로고침 문제 해결 ]
- 새로고침 문제 해결 ( 강제 uri 변경 )
  <br>
![(타임리프)ajax새로고침문제해결](https://github.com/kidchang93/sbt_data/assets/145524731/d0b8b111-2535-44fd-9d28-b8f69d92959b)

### [ 새로고침시 댓글 페이지 번호 유지 ]
- 댓글 페이지 번호 유지
  <br>
![(타임리프)새로고침시댓글페이지번호유지](https://github.com/kidchang93/sbt_data/assets/145524731/5375eb99-bf4d-40ba-a40d-3a76599eedbe)







## 4. 개인 회고
### 😎 이창규
    생각보다 ThymeLeaf 문법들이 복잡했지만 
    JavaScript 문법을 통해 풀어가다보니
    어떤 web 구현 방식이라도 불가능하진 않을 것 같다.
    RestApi 는 알고나니 생각보다 편리했다.
    ajax 활용도 이제 점차 적응이 되는것 같다.
    앞으로 회원기능도 추가하고 파일 업로드도 진행할 예정이다.
    개인 프로젝트 하나 더 준비하는게 있는데 해당 기능을 함께 적용할지는 미지수.