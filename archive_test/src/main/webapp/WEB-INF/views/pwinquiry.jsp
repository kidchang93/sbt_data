<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>아카이브</title>
  <link rel="stylesheet" href="../inc/css/reset.css">
  <link rel="stylesheet" href="../inc/css/admin.css">
  <script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ=" crossorigin="anonymous"></script>
  <script src="../inc/js/admin.js"></script>
</head>
<body>
  <div class="wrap bg-gray h100">
    <div class="header">
      <div class="inner">
        <a href="javascript:;">
          <img src="../images/admin/logo.png" alt="아카이브">
        </a>
        <div class="select-wrap">
          <button type="button" class="select-btn">고길동</button>
          <div class="select-list">
            <a href="javascript:;">비밀번호 변경</a>
            <a href="javascript:;">로그아웃</a>
          </div>
        </div>
      </div>
    </div>
    <div class="container">
      <div class="inner">
        <div class="inquiry">
          <div class="title-wrap">
            <span class="title">비밀번호 수정</span>
            <span class="txt">새로운 비밀번호를 입력해주세요.</span>
          </div>
          <div class="box-pwinquiry">
            <div class="form-input">
              <div>
                <span class="sub-tit">기존 비밀번호</span>
                <input type="password">
              </div>
              <div>
                <span class="sub-tit">새 비밀번호</span>
                <input type="password">
              </div>
              <div>
                <span class="sub-tit">비밀번호 확인</span>
                <input type="password">
                <em class="error">＊ 비밀번호를 다시 한번 입력해주세요.</em>
              </div>
            </div>
          </div>
          <button class="btn size01">확인</button>
        </div>
      </div>
    </div>
  </div>
</body>
</html>