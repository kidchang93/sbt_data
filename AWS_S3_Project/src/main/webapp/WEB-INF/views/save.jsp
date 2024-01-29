<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>게시물 등록 폼</h1>

<form action="/content/save" method="post" autocomplete="off" enctype="multipart/form-data">
    <input type="text">
    <input type="submit" value="등록">
    <table>
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

    </table>
</form>

</body>
<script>
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
