<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/board/save" method="post">
  <p>제목 : <input type="text" name="title" placeholder="제목을 입력하세요."/></p>
  <p>내용 : <textarea name="contents" id="contents" cols="30" rows="10" placeholder="내용을 입력하세요."></textarea></p>
  <p>작성자 : <input type="text" name="id" placeholder="작성자를 입력하세요."></p>
  <input type="submit" value="작성하기">
</form>
</body>
</html>
