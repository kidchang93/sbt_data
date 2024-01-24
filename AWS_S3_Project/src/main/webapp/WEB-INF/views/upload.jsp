<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-01-24
  Time: 오후 4:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <form method="post" action="/boot/upload" enctype="multipart/form-data">
        <input type="file" name="uploadFile" multiple="multiple"/>
        <input type="submit" value="결과 확인"/>
    </form>

    <%--<form method="post" action="/upload" enctype="multipart/form-data">
        <input th:field="*{file}" type="file" name="uploadfile" multiple="multiple"/>
        <input type="submit" value="결과 확인"/>
    </form>--%>
</div>
</body>
</html>
