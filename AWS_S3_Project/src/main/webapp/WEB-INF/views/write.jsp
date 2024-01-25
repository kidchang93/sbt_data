<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>글 작성 페이지</title>
</head>
<body>
<form id="saveForm" method="post" autocomplete="off" action="/content/save">
    <!--/* 게시글 수정인 경우, 서버로 전달할 게시글 번호 (PK) */-->
    <input type="hidden" name="${content.id}">

    <!--/* 서버로 전달할 공지글 여부 */-->
    <%--<input type="hidden" value="${content.description}" />--%>
    <table class="tb tb_row">
        <colgroup>
            <col style="width:15%;" />
            <col style="width:35%;" />
            <col style="width:15%;" />
            <col style="width:35%;" />
        </colgroup>
        <tbody>
        <tr>
            <th scope="row">공지글</th>
            <td><span class="chkbox"><input type="checkbox" id="isNotice" name="isNotice" class="chk" />
                <i></i><label for="isNotice"> 설정</label></span></td>

            <th scope="row">등록일</th>
            <td colspan="3"><input type="text" id="createdDate" name="createdDate" readonly /></td>
        </tr>

        <tr>
            <th>제목 <span class="es">필수 입력</span></th>
            <td colspan="3"><input type="text" id="title" name="title" maxlength="50" placeholder="제목을 입력해 주세요." /></td>
        </tr>

        <tr>
            <th>이름 <span class="es">필수 입력</span></th>
            <td colspan="3"><input type="text" id="writer" name="writer" maxlength="10" placeholder="이름을 입력해 주세요." /></td>
        </tr>

        <tr>
            <th>내용 <span class="es">필수 입력</span></th>
            <td colspan="3"><textarea id="content" name="content" cols="50" rows="10" placeholder="내용을 입력해 주세요."></textarea></td>
        </tr>
        </tbody>
    </table>
</form>
<p class="btn_set">
    <button type="button" id="saveBtn" onclick="savePost();" class="btns btn_st3 btn_mid">저장</button>
    <a href="#" class="btns btn_bdr3 btn_mid">뒤로</a>
</p>
</body>
<script>
    window.onload = () => {
        initCreatedDate();
    }


    // 등록일 초기화
    function initCreatedDate() {
        document.getElementById('createdDate').value = dayjs().format('YYYY-MM-DD');
    }


    // 게시글 저장(수정)
    function savePost() {
        const form = document.getElementById('saveForm');
        const fields = [form.title, form.writer, form.content];
        const fieldNames = ['제목', '이름', '내용'];

        for (let i = 0, len = fields.length; i < len; i++) {
            isValid(fields[i], fieldNames[i]);
        }

        document.getElementById('saveBtn').disabled = true;
        form.noticeYn.value = form.isNotice.checked;
        form.action = [[ ${content == null} ]] ? '/save' : '/update';
        form.submit();
    }
</script>
</html>
