<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>리스트 페이지</title>
</head>
<body>
<div class="page_tits">
    <h3>게시판 관리</h3>
    <p class="path"><strong>현재 위치 :</strong> <span>게시판 관리</span> <span>리스트형</span> <span>리스트</span></p>
</div>
<div class="content">
    <section>
        <%--검색--%>
        <div class="search_box">
            <form id="searchForm" onsubmit="return false;" autocomplete="off">
                <div class="sch_group fl">
                    <select title="검색 유형 선택">
                        <option value="">전체 검색</option>
                        <option value="">제목</option>
                        <option value="">내용</option>
                    </select>
                    <input type="text" placeholder="키워드를 입력해 주세요." title="키워드 입력"/>
                    <button type="button" class="bt_search"><i class="fas fa-search"></i><span class="skip_info">검색</span></button>
                </div>
            </form>
        </div>
    </section>
</div>
<%--리스트--%>
<table class="tb tb_col">
    <colgroup>
        <col style="width: 50px"/><col style="width:7.5%;"/><col style="width:auto;"/><col style="width:10%;"/><col style="width:15%;"/><col style="width:7.5%;"/>
    </colgroup>

    <c:choose>
        <c:when test="${empty contentList}">
            <tr>
                <td colspan="6">등록된 글이 없습니다.</td>
            </tr>
        </c:when>
            <c:otherwise>
                <thead>
                    <tr>
                        <th scope="col">번호</th>
                        <th scope="col">제목</th>
                        <th scope="col">내용</th>
                        <th scope="col">등록일</th>
                        <th scope="col">키워드</th>
                    </tr>
                </thead>
                    <tbody>
                    <%--<input type="hidden" name="contentList" value="${contentList}">--%>
                    <%--<c:forEach items="${contentList}" var="content">
                    </c:forEach>--%>
                        <div class="list">



                                            <%-- 자바 스크립트 리스트 영역--%>

                                    <%--<td>${content.id}</td>
                                    <td><a href="/content/view?id=${content.id}">${content.title}</a></td>
                                    <td>${content.description}</td>
                                    <td>${content.registDate}</td>
                                    <td>${content.keyword}</td>--%>


                        </div>
                    </tbody>
            </c:otherwise>
    </c:choose>
</table>


    <!--/* 페이지네이션 */-->
    <div class="paging">

    </div>
    <!--/* 버튼 */-->
    <p class="btn_set tr">
        <a href="/content/write" class="btns btn_st3 btn_mid">글쓰기</a>
    </p>
</body>
<script>
    window.onload = () => {
        // 페이지가 로드되었을 때, 딱 한 번만 함수를 실행
        findAllPost();
    }




    // 게시글 리스트 조회
    function findAllPost() {

        // 1. PagingResponse의 멤버인 List<T> 타입의 list를 의미
        const list = ${contentList.list};

        console.log(list);
        // 2. 리스트가 비어있는 경우, 행에 "검색 결과가 없다"는 메시지를 출력하고, 페이지 번호(페이지네이션) HTML을 제거(초기화)한 후 로직을 종료
        if (list == null){
        document.getElementById('list').innerHTML ='<td colspan="6"><div className="no_data_msg">검색된 결과가 없습니다.</div></td>';
        drawPage();
        }

        // 3. PagingResponse의 멤버인 pagination을 의미
        const pagination = ${getPagination};
        console.log(pagination);

        // 4. @ModelAttribute를 이용해서 뷰(HTML)로 전달한 SearchDto 타입의 객체인 params를 의미
        const params = ${params};
        console.log(params);

        // 5. 리스트에 출력되는 게시글 번호를 처리하기 위해 사용되는 변수 (리스트에서 번호는 페이지 정보를 이용해서 계산해야 함)
        let num = pagination.totalRecordCount - ((params.page - 1) * params.recordSize);
        console.log(num);
        // 6. 리스트 데이터 렌더링
        drawList(list, num);

        // 7. 페이지 번호 렌더링
        drawPage(pagination, params);
    }

    // 리스트 HTML draw
    function drawList(list, num) {

        // 1. 렌더링 할 HTML을 저장할 변수
        let html = '';

        /*
         * 2. 기존에 타임리프(Thymeleaf)를 이용해서 리스트 데이터를 그리던 것과 유사한 로직
         *    기존에는 게시글 번호를 (전체 데이터 수 - loop의 인덱스 번호)로 처리했으나, 현재는 (전체 데이터 수 - ((현재 페이지 번호 - 1) * 페이지당 출력할 데이터 개수))로 정밀히 계산
         * <td><input type="text" /></td>
         *  <td></td>
         */

        list.forEach(row => {
            html += `<tr>
                        <td class="tl"><a href="/content/view?id=${row.id}">${row.title}</a></td>
                        <td>${row.userId}</td>
                        <td>${row.registDate}</td>
                        <td>${row.view}</td>
                    </tr>`
        });

        // 3. id가 "list"인 요소를 찾아 HTML을 렌더링
        // 3. 클래스가 "list"인 요소를 찾아 HTML을 렌더링
        /*document.getElementById('list').innerHTML = html;*/
        document.querySelector('.list').innerHTML = html;
    }

    // 페이지 HTML draw
    function drawPage(pagination, params) {

        // 1. 필수 파라미터가 없는 경우, 페이지 번호(페이지네이션) HTML을 제거(초기화)한 후 로직 종료
        if ( !pagination || !params ) {
            document.querySelector('.paging').innerHTML = '';
            throw new Error('Missing required parameters...');
        }

        // 2. 렌더링 할 HTML을 저장할 변수
        let html = '';

        // 3. 이전 페이지가 있는 경우, 즉 시작 페이지(startPage)가 1이 아닌 경우 첫 페이지 버튼과 이전 페이지 버튼을 HTML에 추가
        if (pagination.existPrevPage) {
            html += `
                        <a href="javascript:void(0);" onclick="movePage(1)" class="page_bt first">첫 페이지</a>
                        <a href="javascript:void(0);" onclick="movePage(${pagination.startPage - 1})" class="page_bt prev">이전 페이지</a>
                    `;
        }

        /*
         * 4. 시작 페이지(startPage)와 끝 페이지(endPage) 사이의 페이지 번호(i)를 넘버링 하는 로직
         *    페이지 번호(i)와 현재 페이지 번호(params.page)가 동일한 경우, 페이지 번호(i)를 활성화(on) 처리
         */
        html += '<p>';
        for (let i = pagination.startPage; i <= pagination.endPage; i++) {
            html += (i !== params.page)
                ? `<a href="javascript:void(0);" onclick="movePage(${i});">${i}</a>`
                : `<span class="on">${i}</span>`
        }
        html += '</p>';

        // 5. 현재 위치한 페이지 뒤에 데이터가 더 있는 경우, 다음 페이지 버튼과 끝 페이지 버튼을 HTML에 추가
        if (pagination.existNextPage) {
            html += `
                        <a href="javascript:void(0);" onclick="movePage(${pagination.endPage + 1});" class="page_bt next">다음 페이지</a>
                        <a href="javascript:void(0);" onclick="movePage(${pagination.totalPageCount});" class="page_bt last">마지막 페이지</a>
                    `;
        }

        // 6. class가 "paging"인 요소를 찾아 HTML을 렌더링
        document.querySelector('.paging').innerHTML = html;
    }
    // 페이지 이동
    function movePage(page) {

        // 1. drawPage( )의 각 버튼에 선언된 onclick 이벤트를 통해 전달받는 page(페이지 번호)를 기준으로 객체 생성
        const queryParams = {
            page: (page) ? page : 1,
            recordSize: 10,
            pageSize: 10
        }

        /*
         * 2. location.pathname : 리스트 페이지의 URI("/post/list.do")를 의미
         *    new URLSearchParams(queryParams).toString() : queryParams의 모든 프로퍼티(key-value)를 쿼리 스트링으로 변환
         *    URI + 쿼리 스트링에 해당하는 주소로 이동
         *    (해당 함수가 리턴해주는 값을 브라우저 콘솔(console)에 찍어보시면 쉽게 이해하실 수 있습니다.)
         */
        location.href = location.pathname + '?' + new URLSearchParams(queryParams).toString();
    }
</script>
</html>
