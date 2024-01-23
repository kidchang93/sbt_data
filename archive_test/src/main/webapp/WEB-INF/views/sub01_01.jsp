<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>아카이브</title>
  <link rel="stylesheet" href="https://code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="../inc/css/reset.css">
  <link rel="stylesheet" href="../inc/css/admin.css">
  <script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ=" crossorigin="anonymous"></script>
  <script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/TableDnD/0.9.1/jquery.tablednd.js" integrity="sha256-d3rtug+Hg1GZPB7Y/yTcRixO/wlI78+2m08tosoRn7A=" crossorigin="anonymous"></script>
  <script src="../inc/js/admin.js"></script>
</head>
<body>
  <div id="wrap" class="page01_01">
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
      <div class="nav">
        <div class="inner">
          <ul class="nav-list">
            <li>
              <a href="javascript:;">콘텐츠 관리</a>
              <div class="depth2">
                <ul class="inner">
                  <li>
                    <a href="javascript:;">단건 관리</a>
                  </li>
                  <li>
                    <a href="javascript:;">일괄 관리</a>
                  </li>
                </ul>
              </div>
            </li>
            <li>
              <a href="javascript:;">카테고리 관리</a>
              <div class="depth2">
                <ul class="inner">
                  <li>
                    <a href="javascript:;">카테고리 관리</a>
                  </li>
                  <li>
                    <a href="javascript:;">내부용 출처 관리</a>
                  </li>
                </ul>
              </div>
            </li>
            <li>
              <a href="javascript:;">통계 관리</a>
            </li>
            <li>
              <a href="javascript:;">사용자 관리</a>
            </li>
            <li>
              <a href="javascript:;">서비스 관리</a>
            </li>
          </ul>
        </div>
      </div>
    </div>
    <div class="container">
      <div class="inner">
        <div class="table-cnt">
          <div class="search-wrap type02">
            <div class="searh-box">
              <div class="row">
                <div class="col">
                  <span class="tit">등록일</span>
                  <div class="date-wrap">
                    <div class="input-wrap">
                      <input type="text" id="from" name="from" disabled>
                    </div>
                    <span>~</span>
                    <div class="input-wrap">
                      <input type="text" id="to" name="to" disabled>
                    </div>
                  </div>
                </div>
                <div class="col">
                  <span class="tit">유형</span>
                  <!-- s: 20221130 수정 -->
                  <!-- <input type="checkbox" id="chk01_1" checked>
                  <label for="chk01_1">이미지</label>
                  <input type="checkbox" id="chk01_2" checked>
                  <label for="chk01_2">아이콘</label>
                  <input type="checkbox" id="chk01_3" checked>
                  <label for="chk01_3">캐릭터</label>
                  <input type="checkbox" id="chk01_4" checked>
                  <label for="chk01_4">동영상</label> -->
                  <select name="" id="">
                    <!-- s: 20221202 수정 -->
                    <option value="">전체</option>
                    <!-- e: 20221202 수정 -->
                    <option value="">이미지</option>
                    <option value="">아이콘</option>
                    <option value="">캐릭터</option>
                    <option value="">동영상</option>
                  </select>
                  <!-- e: 20221130 수정 -->
                </div>
              </div>
              <div class="row">
                <div class="col">
                  <span class="tit">검색</span>
                  <input type="text" maxlength="30">
                  <input type="radio" id="radio01_1" name="search" checked>
                  <label for="radio01_1">제목</label>
                  <input type="radio" id="radio01_2"  name="search">
                  <label for="radio01_2">게시자명</label>
                </div>
                <div class="col">
                  <span class="tit">상태</span>
                  <input type="checkbox" id="chk02_1" checked>
                  <label for="chk02_1">노출</label>
                  <input type="checkbox" id="chk02_2" checked>
                  <label for="chk02_2">미노출</label>
                </div>
              </div>
            </div>
            <div class="btn-wrap">
              <button type="button" class="btn">초기화</button>
              <button class="btn">검색</button>
            </div>
          </div>
          <div class="table-type01 cnt-type">
            <div class="table-top">
              <div class="select-box">
                <span>총 <em>00</em>개</span>
                <select name="" id="">
                  <option value="">10개 보기</option>
                  <option value="">30개 보기</option>
                  <option value="">50개 보기</option>
                </select>
              </div>
              <div class="btn-wrap">
                <!-- s: 20221121 수정 -->
                <button type="button" class="btn">엑셀파일 다운로드</button>
                <button type="button" class="btn w90">단건 등록</button>
                <!-- e: 20221121 수정 -->
              </div>
            </div>
            <table>
              <colgroup>
                <col width="4%">
                <col width="7%">
                <col width="19%">
                <col width="9%">
                <col width="*">
                <col width="7%">
                <col width="10%">
                <col width="10%">
                <col width="10%">
              </colgroup>
              <thead>
                <tr>
                  <th>
                    <input type="checkbox" name="" id="allchk" class="allCheck">
                    <label for="allchk">전체</label>
                  </th>
                  <th>ID</th>
                  <th>썸네일</th>
                  <th>유형</th>
                  <th>제목</th>
                  <th>상태</th>
                  <th>게시자</th>
                  <th>등록일</th>
                  <th>수정</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>
                    <input type="checkbox" id="chk03_1">
                    <label for="chk03_1"></label>
                  </td>
                  <td>1234</td>
                  <td>
                    <img src="../images/admin/thum_sample.png" alt="">
                  </td>
                  <td>이미지</td>
                  <td class="tit">
                    <button type="button" class="pop-btn" data-pop="detail-pop">바다에서 가족과 물놀이하는 모습</button>
                  </td>
                  <td>노출</td>
                  <td>고길동</td>
                  <td>YYYY-MM-DD</td>
                  <td>
                    <a href="javascript:;" class="link">수정</a>
                  </td>
                </tr>
                <tr>
                  <td>
                    <input type="checkbox" id="chk03_2">
                    <label for="chk03_2"></label>
                  </td>
                  <td>1234</td>
                  <td>
                    <img src="../images/admin/thum_sample.png" alt="">
                  </td>
                  <td>이미지</td>
                  <td class="tit">
                    <button type="button" class="pop-btn" data-pop="detail-pop">스쿨버스</button>
                  </td>
                  <td>미노출</td>
                  <td>마이콜</td>
                  <td>YYYY-MM-DD</td>
                  <td>
                    <a href="javascript:;" class="link">수정</a>
                  </td>
                </tr>
                <tr>
                  <td>
                    <input type="checkbox" id="chk03_3">
                    <label for="chk03_3"></label>
                  </td>
                  <td>1234</td>
                  <td>
                    <img src="../images/admin/thum_sample.png" alt="">
                  </td>
                  <td>이미지</td>
                  <td class="tit">
                    <button type="button" class="pop-btn" data-pop="detail-pop">실험하는 남자 아이</button>
                  </td>
                  <td>노출</td>
                  <td>도우너</td>
                  <td>YYYY-MM-DD</td>
                  <td>
                    <a href="javascript:;" class="link">수정</a>
                  </td>
                </tr>
                <tr>
                  <td>
                    <input type="checkbox" id="chk03_4">
                    <label for="chk03_4"></label>
                  </td>
                  <td>1234</td>
                  <td>
                    <img src="../images/admin/thum_sample.png" alt="">
                  </td>
                  <td>이미지</td>
                  <td class="tit">
                    <button type="button" class="pop-btn" data-pop="detail-pop">설명하는 여자 아이</button>
                  </td>
                  <td>노출</td>
                  <td>고길동</td>
                  <td>YYYY-MM-DD</td>
                  <td>
                    <a href="javascript:;" class="link">수정</a>
                  </td>
                </tr>
                <tr>
                  <td>
                    <input type="checkbox" id="chk03_5">
                    <label for="chk03_5"></label>
                  </td>
                  <td>1234</td>
                  <td>
                    <img src="../images/admin/thum_sample.png" alt="">
                  </td>
                  <td>동영상</td>
                  <td class="tit">
                    <button type="button" class="pop-btn" data-pop="detail-pop">책</button>
                  </td>
                  <td>미노출</td>
                  <td>둘리</td>
                  <td>YYYY-MM-DD</td>
                  <td>
                    <a href="javascript:;" class="link">수정</a>
                  </td>
                </tr>
                <tr>
                  <td>
                    <input type="checkbox" id="chk03_6">
                    <label for="chk03_6"></label>
                  </td>
                  <td>1234</td>
                  <td>
                    <img src="../images/admin/thum_sample.png" alt="">
                  </td>
                  <td>이미지</td>
                  <td class="tit">
                    <button type="button" class="pop-btn" data-pop="detail-pop">실험하는 남자 아이2</button>
                  </td>
                  <td>노출</td>
                  <td>또치</td>
                  <td>YYYY-MM-DD</td>
                  <td>
                    <a href="javascript:;" class="link">수정</a>
                  </td>
                </tr>
                <tr>
                  <td>
                    <input type="checkbox" id="chk03_7">
                    <label for="chk03_7"></label>
                  </td>
                  <td>1234</td>
                  <td>
                    <img src="../images/admin/thum_sample.png" alt="">
                  </td>
                  <td>이미지</td>
                  <td class="tit">
                    <button type="button" class="pop-btn" data-pop="detail-pop">설명하는 여자 아이2</button>
                  </td>
                  <td>노출</td>
                  <td>고길동</td>
                  <td>YYYY-MM-DD</td>
                  <td>
                    <a href="javascript:;" class="link">수정</a>
                  </td>
                </tr>
                <tr>
                  <td>
                    <input type="checkbox" id="chk03_8">
                    <label for="chk03_8"></label>
                  </td>
                  <td>1234</td>
                  <td>
                    <img src="../images/admin/thum_sample.png" alt="">
                  </td>
                  <td>동영상</td>
                  <td class="tit">
                    <button type="button" class="pop-btn" data-pop="detail-pop">바다에서 가족과 물놀이하는 모습</button>
                  </td>
                  <td>노출</td>
                  <td>마이콜</td>
                  <td>YYYY-MM-DD</td>
                  <td>
                    <a href="javascript:;" class="link">수정</a>
                  </td>
                </tr>
                <tr>
                  <td>
                    <input type="checkbox" id="chk03_9">
                    <label for="chk03_9"></label>
                  </td>
                  <td>1234</td>
                  <td>
                    <img src="../images/admin/thum_sample.png" alt="">
                  </td>
                  <td>이미지</td>
                  <td class="tit">
                    <button type="button" class="pop-btn" data-pop="detail-pop">스쿨버스</button>
                  </td>
                  <td>미노출</td>
                  <td>도우너</td>
                  <td>YYYY-MM-DD</td>
                  <td>
                    <a href="javascript:;" class="link">수정</a>
                  </td>
                </tr>
              </tbody>
            </table>
            <div class="paging-wrap">
              <a href="javascript:;" class="first"></a>
              <a href="javascript:;" class="prev"></a>
              <a href="javascript:;" class="page active">
                <span>1</span>
              </a>
              <a href="javascript:;" class="page">
                <span>2</span>
              </a>
              <a href="javascript:;" class="page">
                <span>3</span>
              </a>
              <a href="javascript:;" class="page">
                <span>4</span>
              </a>
              <a href="javascript:;" class="page">
                <span>5</span>
              </a>
              <a href="javascript:;" class="next"></a>
              <a href="javascript:;" class="last"></a>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="dim"></div>
    <div class="popup" data-pop="detail-pop">
      <div class="view-cnt">
        <div class="tit">
          <span>상세 보기</span>
          <div class="btn-wrap">
            <a href="javascript:;" class="link">수정</a>
            <button type="button" class="pop-close"></button>
          </div>
          
        </div>
        <div class="cnt">
          <div class="table-type02">
            <table>
              <colgroup>
                <col width="11%">
                <col width="*">
                <col width="11%">
                <col width="*">
              </colgroup>
              <tbody>
                <tr>
                  <th>ID</th>
                  <td>xxxx</td>
                  <th>유형</th>
                  <td>이미지</td>
                </tr>
                <tr>
                  <th>유/무료</th>
                  <td>무료</td>
                  <th>노출여부</th>
                  <td>노출</td>
                </tr>
                <tr>
                  <th>제목</th>
                  <td colspan="3">바다에서 가족과 물놀이하는 모습</td>
                </tr>
                <tr>
                  <th>키워드</th>
                  <td colspan="3">여름, 바다, 물놀이, 가족 여행</td>
                </tr>
                <tr>
                  <th>설명</th>
                  <td colspan="3">-</td>
                </tr>
                <tr>
                  <th>출처</th>
                  <td colspan="3">천재교육</td>
                </tr>
                <!-- s: 20221130 추가 -->
                <tr>
                  <th>내부 관리용 출처</th>
                  <td colspan="3">-</td>
                </tr>
                <!-- e: 20221130 추가 -->
                <tr>
                  <th>카테고리</th>
                  <td colspan="3">
                    [주제] 동물>포유류<br>[교과] 초등>1학년>1학기>국어>1. 국어는 내친구
                  </td>
                </tr>
                <tr>
                  <th>등록일</th>
                  <td colspan="3">YYYY-MM-DD</td>
                </tr>
                <tr>
                  <th>썸네일</th>
                  <td colspan="3"><img src="../images/admin/thum_sample.png" alt=""></td>
                </tr>
                <tr>
                  <th>미리보기</th>
                  <td colspan="3">
                    <!-- 이미지 -->
                    <img src="../images/admin/img_sample.png" alt="">
                    <!-- video -->
                    <div class="video-box" style="display: none;">
                      <video width="100%" height="auto" src="../images/admin/video_sample.mp4" autoplay loop></video>
                    </div>
                    <!-- youtube -->
                    <div class="video-box" style="display: none;">
                      <iframe width="325" height="165" src="https://www.youtube.com/embed/Ddt4p8CvjT4?autoplay=1&mute=1"></iframe>
                    </div>
                  </td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
<script>
  $(function(){
    var dateFormat = "yy-mm-dd",
    from = $( "#from" )
      .datepicker({
        defaultDate: "+1w",
        changeMonth: true,
        numberOfMonths: 1,
        dateFormat: "yy-mm-dd",
        showOn: "button",
        buttonImage: "../images/admin/ico_calendar.png",
        buttonImageOnly: true,
        buttonText: "Select date"
      })
      .on( "change", function() {
        to.datepicker( "option", "minDate", getDate( this ) );
      }),
    to = $( "#to" ).datepicker({
      defaultDate: "+1w",
      changeMonth: true,
      numberOfMonths: 1,
      dateFormat: "yy-mm-dd",
      showOn: "button",
      buttonImage: "../images/admin/ico_calendar.png",
      buttonImageOnly: true,
      buttonText: "Select date"
    })
    .on( "change", function() {
      from.datepicker( "option", "maxDate", getDate( this ) );
    });
 
    function getDate( element ) {
      var date;
      try {
        date = $.datepicker.parseDate( dateFormat, element.value );
      } catch( error ) {
        date = null;
      }
 
      return date;
    }

  })
  
  
</script>
</html>