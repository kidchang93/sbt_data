<%--
  Created by IntelliJ IDEA.
  User: Quzz
  Date: 2024-01-20
  Time: 오후 5:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>리스트 보기</title>
</head>
<body>

<table>
  <tr>
    <th>id</th>
    <th>제목</th>
    <th>내용</th>
    <th>게시날짜</th>
  </tr>
  <tr>
    <td>${boarList.id}</td>
    <td>${boarList.title}</td>
    <td>${boarList.contents}</td>
    <td>${boarList.regDate}</td>
  </tr>
</table>
</body>
</html>
