<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>글 작성 페이지</title>
</head>
<body>
<form id="saveForm" method="post" action="/content/save">
    <div class="page_tits">
        <h3>게시판 관리</h3>
        <p class="path"><strong>현재 위치 :</strong> <span>게시판 관리</span> <span>리스트형</span> <span>글작성</span></p>
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
                    <td colspan="3"><input type="text" id="title" name="title" maxlength="50" placeholder="제목을 입력해 주세요." /></td>
                </tr>

                <tr>
                    <th>키워드 <span class="es">필수 입력</span></th>
                    <td colspan="3"><input type="text" id="keyword" name="keyword" maxlength="10" placeholder="이름을 입력해 주세요." /></td>
                </tr>

                <tr>
                    <th>내용 <span class="es">필수 입력</span></th>
                    <td colspan="3"><textarea id="description" name="description" cols="50" rows="10" placeholder="내용을 입력해 주세요."></textarea></td>
                </tr>
                </tbody>
            </table>
            <input type="submit" value="작성">
        </section>
    </div>
</form>

<%--<p class="btn_set">
    <button type="button" id="saveBtn" onclick="savePost();" class="btns btn_st3 btn_mid">저장</button>
    <a href="#" class="btns btn_bdr3 btn_mid">뒤로</a>
</p>--%>
</body>
<script>
    window.onload = () => {
        initCreatedDate();
    }
    // 게시글 상세정보 렌더링
        /*function renderPostInfo() {
        const content = [[ ${content} ]];

        if ( !content ) {
            initCreatedDate();
            return false;
        }

        const form = document.getElementById('saveForm');
        const fields = ['id', 'title', 'content', 'keyword', 'description'];
        form.isNotice.checked = content.noticeYn;
        form.createdDate.value = dayjs(content.createdDate).format('YYYY-MM-DD HH:mm');

        fields.forEach(field => {
            form[field].value = content[field];
        })
    }*/

    // 등록일 초기화
    function initCreatedDate() {
        document.getElementById('createdDate').value = dayjs().format('YYYY-MM-DD');
    }


    // 게시글 저장(수정)
/*    function savePost() {
        const form = document.getElementById('saveForm');
        const fields = [form.title, form.keyword, form.description];
        const fieldNames = ['제목', '키워드', '내용'];

        for (let i = 0, len = fields.length; i < len; i++) {
            isValid(fields[i], fieldNames[i]);
        }

        document.getElementById('saveBtn').disabled = false;
        form.action = [[ ${content != null} ]] ? '/content/save' : '/content/update';
        form.submit();
    }*/

</script>
</html>
