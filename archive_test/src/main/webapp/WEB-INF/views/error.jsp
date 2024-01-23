<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" style="overflow:hidden;">
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
  <div class="wrap h100">
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
        <div class="error-cnt">
          <img src="../images/admin/error_img.png" alt="">
          <span class="tit">요청하신 페이지를 찾을 수 없습니다.</span>
          <span class="txt">요청하신 페이지가 사라졌거나 잘못된 경로로 접근하여<br>일시적으로 사용할 수 없습니다.</span>
          <span class="txt">입력하신 페이지 정보를 한번 더 확인해주길 바랍니다.</span>
          <a href="javascript:;" class="btn">이전페이지</a>
        </div>
      </div>
    </div>
  </div>
</body>
</html>