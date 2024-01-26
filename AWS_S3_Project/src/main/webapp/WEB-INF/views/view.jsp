<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>상세정보조회</title>
</head>
<body>
<div class="page_tits">
    <h3>게시판 관리</h3>
    <p class="path"><strong>현재 위치 :</strong> <span>게시판 관리</span> <span>리스트형</span> <span>상세정보</span></p>
</div>

<div class="content">
    <section>
        <table class="tb tb_row">
            <colgroup>
                <col style="width:10%;" /><col style="width:23%;" /><col style="width:10%;" /><col style="width:23%;" />
            </colgroup>
            <tbody>
            <tr>
                <th scope="row">등록일</th>
                <td>${content.registDate}</td>
            </tr>
            <tr>
                <th scope="row">키워드</th>
                <td>${content.keyword}</td>
            </tr>
            <tr>
                <th scope="row">제목</th>
                <td>[[ ${content.title} ]]</td>

                <th scope="row">노출여부</th>
                <td colspan="3">[[ ${content.view} ]]</td>
            </tr>
            <tr>
                <th scope="row">이름</th>
                <td colspan="3">[[ ${content.userId} ]]</td>
            </tr>
            <tr>
                <th scope="row">내용</th>
                <td colspan="3">[[ ${content.description} ]]</td>
            </tr>
            </tbody>
        </table>
        <p class="btn_set">
            <a href="/write?update=${content.id}" class="btns btn_bdr4 btn_mid">수정</a>
            <button type="button" class="btns btn_bdr1 btn_mid">삭제</button>
            <a href="/content/list" class="btns btn_bdr3 btn_mid">뒤로</a>
        </p>
    </section>
</div> <!--/* .content */-->
</body>
</html>
