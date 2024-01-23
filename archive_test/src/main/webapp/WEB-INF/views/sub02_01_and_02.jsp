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
  <div id="wrap" class="page02_01">
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
        <div class="category-cnt">
          <div class="left-nav">
            <div class="btn-wrap">
              <a href="javascript:;" class="btn">엑셀파일 다운로드</a>
            </div>
            <div class="scroll-inner">
              <ul class="depth depth1 active">
                <li>
                  <div class="link-wrap">
                    <a href="javascript:;">주제</a>
                  </div>
                  <ul class="depth depth2">
                    <li>
                      <div class="link-wrap">
                        <a href="javascript:;">교통</a>
                      </div>
                      <ul class="depth depth3">
                        <li>
                          <div class="link-wrap">
                            <a href="javascript:;">육상교통수단</a>
                          </div>
                        </li>
                      </ul>
                    </li>
                    <li>
                      <div class="link-wrap">
                        <a href="javascript:;">예술</a>
                      </div>
                      <ul class="depth depth3">
                        <li>
                          <div class="link-wrap">
                            <a href="javascript:;">음악</a>
                          </div>
                        </li>
                      </ul>
                    </li>
                  </ul>
                </li>
                <li>
                  <div class="link-wrap">
                    <a href="javascript:;">교과</a>
                  </div>
                  <ul class="depth depth2">
                    <li>
                      <div class="link-wrap">
                        <a href="javascript:;">초등</a>
                      </div>
                      <ul class="depth depth3">
                        <li>
                          <div class="link-wrap">
                            <a href="javascript:;">1학년</a>
                          </div>
                          <ul class="depth depth4">
                            <li>
                              <div class="link-wrap">
                                <a href="javascript:;">1학기</a>
                              </div>
                              <ul class="depth depth5">
                                <li>
                                  <div class="link-wrap">
                                    <a href="javascript:;">국어</a>
                                  </div>
                                  <ul class="depth depth6">
                                    <li>
                                      <div class="link-wrap">
                                        <a href="javascript:;">1. 바른 자세로 읽고 쓰기</a>
                                      </div>
                                    </li>
                                  </ul>
                                </li>
                              </ul>
                            </li>
                          </ul>
                        </li>
                        <li>
                          <div class="link-wrap">
                            <a href="javascript:;">4학년</a>
                          </div>
                          <ul class="depth depth4">
                            <li>
                              <div class="link-wrap">
                                <a href="javascript:;">2학기</a>
                              </div>
                              <ul class="depth depth5">
                                <li>
                                  <div class="link-wrap">
                                    <a href="javascript:;">사회</a>
                                  </div>
                                  <ul class="depth depth6">
                                    <li>
                                      <div class="link-wrap">
                                        <a href="javascript:;">1. 촌락과 도시의 생활 모습</a>
                                      </div>
                                      <ul class="depth depth7">
                                        <li>
                                          <div class="link-wrap">
                                            <a href="javascript:;">1) 촌락과 도시의 특징</a>
                                          </div>
                                        </li>
                                      </ul>
                                    </li>
                                  </ul>
                                </li>
                              </ul>
                            </li>
                          </ul>
                        </li>
                      </ul>
                    </li>
                  </ul>
                </li>
              </ul>
            </div>
          </div>
          <div class="right-section">
            <div class="table-type01">
              <div class="table-top">
                <span>총 <em>00</em>개</span>
                <div class="btn-wrap">
                  <button type="button" class="btn ui-sec">
                    분류 추가
                    <img src="/../images/admin/ico_add.png" alt="">
                  </button>
                  <button type="button" class="btn w90 ui-sec02">
                    수정
                    <img src="/../images/admin/ico_modify.png" alt="">
                  </button>
                </div>
              </div>
              <!-- s: 20221220 수정 -->
              <div class="scroll-inner">
                <table id="table-1" class="table">
                  <colgroup>
                    <col width="6%">
                    <col width="11%">
                    <col width="9%">
                    <col width="5%">
                    <col width="*">
                    <col width="5%">
                    <col width="8%">
                    <col width="10%">
                  </colgroup>
                  <thead>
                    <tr>
                      <th>이동</th>
                      <th>상위 분류 이름</th>
                      <th>순서</th>
                      <th>ID</th>
                      <th>이름</th>
                      <th>수량</th>
                      <th>사용여부</th>
                      <th>History</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td class="dragHandle">
                        <img src="../images/admin/ico_move.png" alt="">
                      </td>
                      <td>일반</td>
                      <td>1</td>
                      <td>00</td>
                      <td>주제</td>
                      <td>000개</td>
                      <td>사용</td>
                      <td class="btn-box">
                        <button type="button" class="btn size02">보기</button>
                      </td>
                    </tr>
                    <tr>
                      <td class="dragHandle">
                        <img src="../images/admin/ico_move.png" alt="">
                      </td>
                      <td>생물</td>
                      <td>2</td>
                      <td>00</td>
                      <td>주제</td>
                      <td>000개</td>
                      <td>미사용</td>
                      <td class="btn-box">
                        <button type="button" class="btn size02">보기</button>
                      </td>
                    </tr>
                    <tr>
                      <td class="dragHandle">
                        <img src="../images/admin/ico_move.png" alt="">
                      </td>
                      <td>자연</td>
                      <td>3</td>
                      <td>00</td>
                      <td>주제</td>
                      <td>000개</td>
                      <td>사용</td>
                      <td class="btn-box">
                        <button type="button" class="btn size02">보기</button>
                      </td>
                    </tr>
                    <tr>
                      <td class="dragHandle">
                        <img src="../images/admin/ico_move.png" alt="">
                      </td>
                      <td>생활</td>
                      <td>4</td>
                      <td>00</td>
                      <td>주제</td>
                      <td>000개</td>
                      <td>사용</td>
                      <td class="btn-box">
                        <button type="button" class="btn size02">보기</button>
                      </td>
                    </tr>
                    <tr>
                      <td class="dragHandle">
                        <img src="../images/admin/ico_move.png" alt="">
                      </td>
                      <td>역사</td>
                      <td>5</td>
                      <td>00</td>
                      <td>주제</td>
                      <td>000개</td>
                      <td>미사용</td>
                      <td class="btn-box">
                        <button type="button" class="btn size02">보기</button>
                      </td>
                    </tr>
                    <tr>
                      <td class="dragHandle">
                        <img src="../images/admin/ico_move.png" alt="">
                      </td>
                      <td>지리</td>
                      <td>6</td>
                      <td>00</td>
                      <td>주제</td>
                      <td>000개</td>
                      <td>사용</td>
                      <td class="btn-box">
                        <button type="button" class="btn size02">보기</button>
                      </td>
                    </tr>
                    <tr>
                      <td class="dragHandle">
                        <img src="../images/admin/ico_move.png" alt="">
                      </td>
                      <td>사회/문화</td>
                      <td>7</td>
                      <td>00</td>
                      <td>주제</td>
                      <td>000개</td>
                      <td>사용</td>
                      <td class="btn-box">
                        <button type="button" class="btn size02">보기</button>
                      </td>
                    </tr>
                    <tr>
                      <td class="dragHandle">
                        <img src="../images/admin/ico_move.png" alt="">
                      </td>
                      <td>경제</td>
                      <td>8</td>
                      <td>00</td>
                      <td>주제</td>
                      <td>000개</td>
                      <td>미사용</td>
                      <td class="btn-box">
                        <button type="button" class="btn size02">보기</button>
                      </td>
                    </tr>
                    <tr>
                      <td class="dragHandle">
                        <img src="../images/admin/ico_move.png" alt="">
                      </td>
                      <td>교통</td>
                      <td>9</td>
                      <td>00</td>
                      <td>주제</td>
                      <td>000개</td>
                      <td>사용</td>
                      <td class="btn-box">
                        <button type="button" class="btn size02">보기</button>
                      </td>
                    </tr>
                    <tr>
                      <td class="dragHandle">
                        <img src="../images/admin/ico_move.png" alt="">
                      </td>
                      <td>예술</td>
                      <td>10</td>
                      <td>00</td>
                      <td>주제</td>
                      <td>000개</td>
                      <td>사용</td>
                      <td class="btn-box">
                        <button type="button" class="btn size02">보기</button>
                      </td>
                    </tr>
                    <tr>
                      <td class="dragHandle">
                        <img src="../images/admin/ico_move.png" alt="">
                      </td>
                      <td>스포츠</td>
                      <td>11</td>
                      <td>00</td>
                      <td>주제</td>
                      <td>000개</td>
                      <td>미사용</td>
                      <td class="btn-box">
                        <button type="button" class="btn size02">보기</button>
                      </td>
                    </tr>
                    <tr>
                      <td class="dragHandle">
                        <img src="../images/admin/ico_move.png" alt="">
                      </td>
                      <td>수학</td>
                      <td>12</td>
                      <td>00</td>
                      <td>주제</td>
                      <td>000개</td>
                      <td>사용</td>
                      <td class="btn-box">
                        <button type="button" class="btn size02">보기</button>
                      </td>
                    </tr>
                    <tr>
                      <td class="dragHandle">
                        <img src="../images/admin/ico_move.png" alt="">
                      </td>
                      <td>과학</td>
                      <td>13</td>
                      <td>00</td>
                      <td>주제</td>
                      <td>000개</td>
                      <td>사용</td>
                      <td class="btn-box">
                        <button type="button" class="btn size02">보기</button>
                      </td>
                    </tr>
                    <tr>
                      <td class="dragHandle">
                        <img src="../images/admin/ico_move.png" alt="">
                      </td>
                      <td>인체</td>
                      <td>14</td>
                      <td>00</td>
                      <td>주제</td>
                      <td>000개</td>
                      <td>사용</td>
                      <td class="btn-box">
                        <button type="button" class="btn size02">보기</button>
                      </td>
                    </tr>
                  </tbody>
                </table>
              </div>
              <!-- e: 20221220 수정 -->
              <!-- s: 20221220 삭제 -->
              <!-- <div class="paging-wrap">
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
              </div> -->
              <!-- e: 20221220 삭제 -->
            </div>
            <!-- 분류추가 -->
            <!-- s: 20221220 수정 -->
            <div class="table-type02 ui-sec-cnt01">
              <div class="table-top">
                <span class="tit">분류 추가</span>
                <div class="btn-wrap">
                  <button type="button" class="btn ui-sec01">저장</button>
                  <button type="button" class="btn ui-sec01">닫기</button>
                </div>
              </div>
              <table>
                <colgroup>
                  <col width="20%">
                  <col width="*">
                </colgroup>
                <tbody>
                  <tr>
                    <th>상위 분류</th>
                    <td>
                      <span class="fix">1학기</span>
                      <button type="button" class="btn">분류 선택</button>
                    </td>
                  </tr>
                  <tr>
                    <th>
                      <span>
                        <em>＊</em>이름
                      </span>
                    </th>
                    <td>
                      <input type="text">
                    </td>
                  </tr>
                  <tr>
                    <th>
                      <span>
                        <em>＊</em>사용여부
                      </span>
                    </th>
                    <td>
                      <input type="radio" id="radio01_1" name="use">
                      <label for="radio01_1">사용</label>
                      <input type="radio" id="radio01_2"  name="use" checked>
                      <label for="radio01_2">미사용</label>
                    </td>
                  </tr>
                  <tr>
                    <th>키워드</th>
                    <td>
                      <input type="text">
                    </td>
                  </tr>
                </tbody>
              </table>
            </div>
            <!-- e: 20221220 수정 -->

            <!-- 수정 -->
            <!-- s: 20221220 추가 -->
            <div class="table-type02 ui-sec-cnt02">
              <div class="table-top">
                <span class="tit">수정</span>
                <div class="btn-wrap">
                  <button type="button" class="btn ui-sec01">저장</button>
                  <button type="button" class="btn ui-sec01">닫기</button>
                </div>
              </div>
              <table>
                <colgroup>
                  <col width="20%">
                  <col width="*">
                </colgroup>
                <tbody>
                  <tr>
                    <th>상위 분류</th>
                    <td>
                      <span class="fix">1학기</span>
                      <button type="button" class="btn">분류 선택</button>
                    </td>
                  </tr>
                  <tr>
                    <th>
                      <span>
                        <em>＊</em>이름
                      </span>
                    </th>
                    <td>
                      <input type="text">
                    </td>
                  </tr>
                  <tr>
                    <th>
                      <span>
                        <em>＊</em>사용여부
                      </span>
                    </th>
                    <td>
                      <input type="radio" id="radio01_1" name="use">
                      <label for="radio01_1">사용</label>
                      <input type="radio" id="radio01_2"  name="use" checked>
                      <label for="radio01_2">미사용</label>
                    </td>
                  </tr>
                  <tr>
                    <th>키워드</th>
                    <td>
                      <input type="text">
                    </td>
                  </tr>
                </tbody>
              </table>
            </div>
            <!-- e: 20221220 추가 -->
            
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
<!-- s: 20221122 추가 -->
<script>
  $('.table-type02').hide();

  // s: 20221220 수정
  $('.ui-sec').on('click', function(){
    $('.table-type01').hide();
    $('.ui-sec-cnt02').hide();
    $('.ui-sec-cnt01').show();
  });

  $('.ui-sec01').on('click', function(){
    $('.table-type01').show();
    $('.ui-sec-cnt01').hide();
    $('.ui-sec-cnt02').hide();
  })

  $('.ui-sec02').on('click', function(){
    $('.ui-sec-cnt02').show();
    $('.ui-sec-cnt01').hide();
    $('.table-type01').hide();
  })
  // e: 20221220 수정


</script>
<!-- e: 20221122 추가 -->
</html>