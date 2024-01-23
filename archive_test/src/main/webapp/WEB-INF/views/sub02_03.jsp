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
  <div id="wrap" class="page02_03">
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
        <div class="table-cnt">
          <div class="search-wrap">
            <input type="text">
            <button class="btn">검색</button>
          </div>
          <div class="table-type01">
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
                <button type="button" class="btn">엑셀파일 다운로드</button>
                <button type="button" class="pop-btn btn w90" data-pop="registration-pop">등록</button>
              </div>
            </div>
            <table>
              <colgroup>
                <col width="70%">
                <col width="10%">
                <col width="10%">
                <col width="10%">
              </colgroup>
              <thead>
                <tr>
                  <th>내부 출처명</th>
                  <th>수량</th>
                  <th>사용여부</th>
                  <th>수정</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>똑똑한 하루 도형 3단계</td>
                  <td>000개</td>
                  <td>사용</td>
                  <td>
                    <button type="button" class="btn pop-btn" data-pop="modify-pop">수정</button>
                  </td>
                </tr>
                <tr>
                  <td>검정교과서 사회(김정인) 4학년 2학기</td>
                  <td>000개</td>
                  <td>사용</td>
                  <td>
                    <button type="button" class="btn pop-btn" data-pop="modify-pop">수정</button>
                  </td>
                </tr>
                <tr>
                  <td>T셀파 수업연구소 클립아트 교과서삽화</td>
                  <td>000개</td>
                  <td>미사용</td>
                  <td>
                    <button type="button" class="btn pop-btn" data-pop="modify-pop">수정</button>
                  </td>
                </tr>
                <tr>
                  <td>검정교과서 사회(박용조) 4학년 2학기</td>
                  <td>000개</td>
                  <td>사용</td>
                  <td>
                    <button type="button" class="btn pop-btn" data-pop="modify-pop">수정</button>
                  </td>
                </tr>
                <tr>
                  <td>유튜브 가리봉특파원</td>
                  <td>000개</td>
                  <td>사용</td>
                  <td>
                    <button type="button" class="btn pop-btn" data-pop="modify-pop">수정</button>
                  </td>
                </tr>
                <tr>
                  <td>유튜브 밀크티타임</td>
                  <td>000개</td>
                  <td>미사용</td>
                  <td>
                    <button type="button" class="btn pop-btn" data-pop="modify-pop">수정</button>
                  </td>
                </tr>
                <tr>
                  <td>검정교과서 과학(이상원) 4학년 1학기</td>
                  <td>000개</td>
                  <td>사용</td>
                  <td>
                    <button type="button" class="btn pop-btn" data-pop="modify-pop">수정</button>
                  </td>
                </tr>
                <tr>
                  <td>검정교과서 수학(한대희) 3학년 1학기</td>
                  <td>000개</td>
                  <td>사용</td>
                  <td>
                    <button type="button" class="btn pop-btn" data-pop="modify-pop">수정</button>
                  </td>
                </tr>
                <tr>
                  <td>똑똑한 하루 사회 5학년 1학기</td>
                  <td>000개</td>
                  <td>미사용</td>
                  <td>
                    <button type="button" class="btn pop-btn" data-pop="modify-pop">수정</button>
                  </td>
                </tr>
                <tr>
                  <td>똑똑한 하루 사회 5학년 2학기</td>
                  <td>000개</td>
                  <td>사용</td>
                  <td>
                    <button type="button" class="btn pop-btn" data-pop="modify-pop">수정</button>
                  </td>
                </tr>
                <tr>
                  <td>똑똑한 하루 한자 C단계</td>
                  <td>000개</td>
                  <td>사용</td>
                  <td>
                    <button type="button" class="btn pop-btn" data-pop="modify-pop">수정</button>
                  </td>
                </tr>
                <tr>
                  <td>사진영상자료실</td>
                  <td>000개</td>
                  <td>미사용</td>
                  <td>
                    <button type="button" class="btn pop-btn" data-pop="modify-pop">수정</button>
                  </td>
                </tr>
                <tr>
                  <td>T셀파 쉬는 시간 사회랑 역사랑</td>
                  <td>000개</td>
                  <td>사용</td>
                  <td>
                    <button type="button" class="btn pop-btn" data-pop="modify-pop">수정</button>
                  </td>
                </tr>
                <tr>
                  <td>T셀파 쉬는 시간 안전한 생활</td>
                  <td>000개</td>
                  <td>사용</td>
                  <td>
                    <button type="button" class="btn pop-btn" data-pop="modify-pop">수정</button>
                  </td>
                </tr>
                <tr>
                  <td>똑똑한 하루 사회 6학년 2학기</td>
                  <td>000개</td>
                  <td>미사용</td>
                  <td>
                    <button type="button" class="btn pop-btn" data-pop="modify-pop">수정</button>
                  </td>
                </tr>
                <tr>
                  <td>똑똑한 하루 사회 6학년 1학기</td>
                  <td>000개</td>
                  <td>사용</td>
                  <td>
                    <button type="button" class="btn pop-btn" data-pop="modify-pop">수정</button>
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
    <div class="popup" data-pop="registration-pop">
      <div class="source-cnt">
        <div class="tit">
          <span>내부 출처명 등록</span>
          <button type="button" class="pop-close"></button>
        </div>
        <div class="cnt">
          <div class="table-type02">
            <table>
              <colgroup>
                <col width="18%">
                <col width="*">
              </colgroup>
              <tbody>
                <tr>
                  <th>내부 출처명</th>
                  <td><input type="text" placeholder="내부 출처명을 입력해주세요."></td>
                </tr>
                <tr>
                  <th>사용여부</th>
                  <td>
                    <input type="radio" id="radio01_1" name="use">
                    <label for="radio01_1">사용</label>
                    <input type="radio" id="radio01_2" name="use" checked="">
                    <label for="radio01_2">미사용</label>
                  </td>
                </tr>
              </tbody>
            </table>
          </div>
          <div class="btn-wrap">
            <button class="btn size03">저장</button>
          </div>
        </div>
      </div>
    </div>
    <div class="popup" data-pop="modify-pop">
      <div class="source-cnt">
        <div class="tit">
          <span>내부 출처명 수정</span>
          <button type="button" class="pop-close"></button>
        </div>
        <div class="cnt">
          <div class="table-type02">
            <table>
              <colgroup>
                <col width="18%">
                <col width="*">
              </colgroup>
              <tbody>
                <tr>
                  <th>내부 출처명</th>
                  <td><input type="text" placeholder="내부 출처명을 입력해주세요."></td>
                </tr>
                <tr>
                  <th>사용여부</th>
                  <td>
                    <input type="radio" id="radio01_1" name="use">
                    <label for="radio01_1">사용</label>
                    <input type="radio" id="radio01_2" name="use" checked="">
                    <label for="radio01_2">미사용</label>
                  </td>
                </tr>
              </tbody>
            </table>
          </div>
          <div class="btn-wrap">
            <button class="btn size03">저장</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
</html>