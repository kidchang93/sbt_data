<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title> 예시를 위한 화면 입니다.</title>
</head>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
        crossorigin="anonymous"></script>
<script>
  let checkFlag = false; //중복 확인 기본값 false

  /**
   * WITH ModelAttribute (form), Valid
   * */
  function idcheck() {
    let id = $("#id").val();
    let data = {
      id: id
    }

    //서버로 id 전송.
    $.ajax({
      url: "all/check/id",
      type: "get",
      data: data,
      success: function (response) {
        if (response) {
          checkFlag = true;
          alert("사용 가능한 id입니다.");
        } else {
          checkFlag = false;
          alert("중복된 아이디입니다.");
        }
      },
      error: function (data, status, errorThrown) {
        /**
         * validation error catch
         * */
        if (data.responseJSON.errors[0].length !== 0) {
          let validationMessage = data.responseJSON.errors[0].defaultMessage;
          let where = data.responseJSON.errors[0].field;
          console.log(where + "는 " +validationMessage);
        }
      },
    });
  }

  /**
   * WITH : RequestParam (url), NO Valid
   * */
  function idcheck2() {
    let id = $("#id").val();

    $.ajax({
      url: "all/find/pass",
      type: "get",
      data: {
        id : id
      },
      success: function (response) {
        if (response.result === 'fail') {
          console.log("사용자를 찾지 못했습니다.");
        } else {
          alert("비밀번호 : " + response.result);
        }
      },
    });
  }

  /**
   * WITH  RequestBody(json), Valid
   * */
  function signIn() {
    let data = {
      id: $("#id").val(),
      password: $("#password").val(),
      name: $("#name").val(),
      email: $("#email").val(),
      phone: $("#phone").val()
    }

    if (checkFlag) {
      $.ajax({
        type: "POST",
        url: "/all/join",
        data: JSON.stringify(data),
        contentType: 'application/json; charset=utf-8',
        success: function (data) {
          console.log(data);
          if (data.flag === true) {
            alert("가입성공");
          } else {
            alert("오류가 발생했습니다. 다시 시도해주세요.");
          }
        },
        error: function (data) {
          /**
           * validation error catch
           * */
          if (data.responseJSON.errors[0].length !== 0) {
            let validationMessage = data.responseJSON.errors[0].defaultMessage;
            let where = data.responseJSON.errors[0].field;
            console.log(where + "는 " +validationMessage);
          }
        },
      });
    } else {
      alert("중복확인을 진행해주세요.");
      return false;
    }

  }
</script>
<body>
<h2>회원 가입</h2>
<input type="text" class="login-input" id="id" title="아이디" autofocus placeholder="아이디 (5-20)">
<button onclick="idcheck()">중복확인</button>
<button onclick="idcheck2()">비밀번호 확인</button>
<div><input type="password" class="login-input" id="password" title="비밀번호" placeholder="비밀번호 (4-20)"></div>
<div><input type="text" class="login-input" id="name" title="이름" placeholder="이름 (1-20)"></div>
<div><input type="email" class="login-input" id="email" title="이메일" placeholder="이메일 (5-50)"></div>
<div><input type="text" class="login-input" id="phone" title="연락처" placeholder="연락처 (11-13)"></div>
<button onclick="signIn()"> 가입하기</button>
</body>
</html>