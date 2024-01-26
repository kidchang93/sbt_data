<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>리스트 페이지</title>
</head>
<body>
<div class="page_tits">
    <h3>게시판 관리</h3>
    <p class="path"><strong>현재 위치 :</strong> <span>게시판 관리</span> <span>리스트형</span> <span>리스트</span></p>
</div>
<div class="content">
    <section>
        <%--검색--%>
        <div class="search_box">
            <form id="searchForm" onsubmit="return false;" autocomplete="off">
                <div class="sch_group fl">
                    <select title="검색 유형 선택">
                        <option value="">전체 검색</option>
                        <option value="">제목</option>
                        <option value="">내용</option>
                    </select>
                    <input type="text" placeholder="키워드를 입력해 주세요." title="키워드 입력"/>
                    <button type="button" class="bt_search"><i class="fas fa-search"></i><span class="skip_info">검색</span></button>
                </div>
            </form>
        </div>
    </section>
</div>
<%--리스트--%>
<table class="tb tb_col">
    <colgroup>
        <col style="width: 50px"/><col style="width:7.5%;"/><col style="width:auto;"/><col style="width:10%;"/><col style="width:15%;"/><col style="width:7.5%;"/>
    </colgroup>
    <c:choose>
        <c:when test="${empty contentList}">
            <tr>
                <td colspan="6">등록된 글이 없습니다.</td>
            </tr>
        </c:when>
        <c:otherwise>
        <thead>
            <tr>
                <th scope="col">번호</th>
                <th scope="col">제목</th>
                <th scope="col">키워드</th>
                <th scope="col">등록일</th>
                <th scope="col">내용</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${contentList}" var="content" varStatus="status">
                <tr>
                    <td>${content.id}</td>
                    <td>${content.title}</td>
                    <td>${content.keyword}</td>
                    <td>${content.registDate}</td>
                    <td>${content.description}</td>
                </tr>
            </c:forEach>
        </tbody>
        </c:otherwise>
    </c:choose>
</table>
    <!--/* 페이지네이션 */-->
    <div class="paging">
        <a href="#" class="page_bt first">첫 페이지</a><a href="#" class="page_bt prev">이전 페이지 그룹</a>
        <p><span class="on">1</span><a href="#">2</a><a href="#">3</a><a href="#">4</a><a href="#">5</a><a href="#">6</a><a href="#">7</a><a href="#">8</a><a href="#">9</a><a href="#">10</a></p>
        <a href="#" class="page_bt next">다음 페이지 그룹</a><a href="#" class="page_bt last">마지막 페이지</a>
    </div>
    <!--/* 버튼 */-->
    <p class="btn_set tr">
        <a href="/post/write" class="btns btn_st3 btn_mid">글쓰기</a>
    </p>
</body>
</html>
