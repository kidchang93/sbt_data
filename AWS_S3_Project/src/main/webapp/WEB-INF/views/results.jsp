<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-01-24
  Time: 오후 4:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--<ul>
    <c:forEach items="${fileList}" var="file">
    <li>
        <span>${file.id}</span>
        <a href="../download?fileName=${file.originalName}"> [download] </a> <br />
        <a href="../display?filename=${file.savedName}">
            <img src="../display?filename=${file.savedName}" alt="이미지 확인하기" width="300px" />
        </a><br />
    </li>
    </c:forEach>

</ul>--%>

<table>

    <tr>
        <th>파일아이디</th>
        <th>파일 다운로드 </th>
        <th>파일 이미지 확인</th>
    </tr>
<c:forEach items="${fileList}" var="file" varStatus="loop">
    <tr>
        <td>${file.id}</td>
        <td><a href="../download?fileName="+${file.originalPath}+${file.originalName}> [download] </a></td>
        <td>
            <a href="../display?filename="${file.savedPath}+${file.savedName}>
                <img src="../display?filename="+${file.savedPath}+${file.savedName} alt="이미지 확인하기" width="300px" />
            </a>
        </td>
    </tr>
</c:forEach>
</table>
</body>
</html>
