<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-01-26
  Time: 오전 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form id="updateForm" method="post" action="/content/update" enctype="application/x-www-form-urlencoded">
    <div class="page_tits">
        <h3>게시판 관리</h3>
        <p class="path"><strong>현재 위치 :</strong> <span>게시판 관리</span> <span>리스트형</span> <span>글작성</span></p>
        <input type="hidden" name="id" value="${contents.id}">
        <c:out value="${contents.id}"/>
        <input type="hidden" value="${contents.title}">
    </div>
    <div class="content">
        <section>
            <table class="tb tb_row">
                <colgroup>
                    <col style="width:15%;" /><col style="width:35%;" /><col style="width:15%;" /><col style="width:35%;" />
                </colgroup>
                <tbody>
                <tr>
                    <th scope="row">등록일</th>
                    <td colspan="3"><input type="text" id="createdDate" name="createdDate" readonly /></td>
                </tr>

                <tr>
                    <th>제목 <span class="es">필수 입력</span></th>
                    <td colspan="3"><input type="text" id="title" name="title" maxlength="50" value="${contents.title}" /></td>
                </tr>

                <tr>
                    <th>키워드 <span class="es">필수 입력</span></th>
                    <td colspan="3"><input type="text" id="keyword" name="keyword" maxlength="10" value="${contents.keyword}" /></td>
                </tr>

                <tr>
                    <th>내용 <span class="es">필수 입력</span></th>
                    <td colspan="3"><textarea id="description" name="description" cols="50" rows="10"></textarea></td>
                </tr>
                </tbody>
            </table>
            <input type="submit" value="수정">
        </section>
    </div>
</form>
</body>
</html>
