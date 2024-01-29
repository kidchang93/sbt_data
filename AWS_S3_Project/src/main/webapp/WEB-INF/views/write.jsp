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
                <tr>
                    <th>첨부파일</th>
                    <td colspan="3">
                        <div class="file_list">
                            <div>
                                <div class="file_input">
                                    <input type="text" readonly/>
                                    <label>첨부파일
                                        <input type="file" name="files" onchange="selectFile(this);"/>
                                    </label>
                                </div>
                                <button type="button" onclick="removeFile(this);" class="btn del_btn"><span>삭제</span></button>
                                <button type="button" onclick="addFile();" class="btns fn_add_btn"><span>파일 추가</span></button>
                            </div>
                        </div>
                    </td>
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
    // 파일 선택
    function selectFile(element) {

        const file = element.files[0];
        const filename = element.closest('.file_input').firstElementChild;

        // 1. 파일 선택 창에서 취소 버튼이 클릭된 경우
        if ( !file ) {
            filename.value = '';
            return false;
        }

        // 2. 파일 크기가 10MB를 초과하는 경우
        const fileSize = Math.floor(file.size / 1024 / 1024);
        if (fileSize > 10) {
            alert('10MB 이하의 파일로 업로드해 주세요.');
            filename.value = '';
            element.value = '';
            return false;
        }

        // 3. 파일명 지정
        filename.value = file.name;
    }


    // 파일 추가
    function addFile() {
        const fileDiv = document.createElement('div');
        fileDiv.innerHTML =`
            <div class="file_input">
                <input type="text" readonly />
                <label> 첨부파일
                    <input type="file" name="files" onchange="selectFile(this);" />
                </label>
            </div>
            <button type="button" onclick="removeFile(this);" class="btns del_btn"><span>삭제</span></button>
        `;
        document.querySelector('.file_list').appendChild(fileDiv);
    }


    // 파일 삭제
    function removeFile(element) {
        const fileAddBtn = element.nextElementSibling;
        if (fileAddBtn) {
            const inputs = element.previousElementSibling.querySelectorAll('input');
            inputs.forEach(input => input.value = '')
            return false;
        }
        element.parentElement.remove();
    }
</script>
</html>
