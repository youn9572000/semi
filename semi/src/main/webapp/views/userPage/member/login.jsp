<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>편리하조 login page</title>
    <link rel="stylesheet" href="/semi/resources/css1/reset.css" type="text/css">
    <link rel="stylesheet" href="/semi/resources/css1/style.css" type="text/css">
</head>
<body>
    
    <%@ include file="/views/common/menubar.jsp"%>
        
    <!--sub_visual-->
    <div id="sub_visual" style="background:linear-gradient(90deg, #7040ff, #d588ff);">
        <h1>로그인</h1>
        <p>'편리' 사이트에 로그인 하시고 다양한 혜택을 찾아가세요.</p>
    </div>
    <!--//sub_visual-->

    <!--container-->
    <div id="sub_container">
        <form id="registrationForm" action="/semi/member/login" method="post">
            <label for="userId">아이디를 입력해주세요</label><br>
            <input type="text" id="userId" name="userId" placeholder="아이디를 입력해주세요" required><br><br>
            <label for="password">비밀번호를 입력해주세요</label><br>
            <input type="password" id="password" name="password" placeholder="비밀번호" required><br><br>
            <button type="submit">로그인</button>
        </form>
        <div class="user-login">
            <a href="#" class="icon login">비밀번호 찾기</a>
            <a href="<%=request.getContextPath()%>/views/userPage/member/idCheck.jsp" class="icon signup">아이디 찾기</a>
            <a href="#" class="icon mypage">회원가입</a>
         </div>
    </div>
    <!--//container-->

    <!--footer-->
    <div id="footer_wrap">
        <div id="footer">
            <p class="f_logo">
                <a href="#"><img src="/semi/resources/img1/편의점 로고 예시1.png" alt="logo"></a>
            </p>
            <div class="f_copyright">
                <ul class="menu">
                    <li><a href="#">회사소개</a></li>
                    <li><a href="#">고객센터</a></li>
                    <li><a href="#">IR</a></li>
                    <li><a href="#">인재채용</a></li>
                    <li><a href="#">찾아오시는길</a></li>
                    <li><a href="#" style="font-weight:bold;">개인정보처리방침</a></li>
                </ul>
                <p class="info">
                    서울특별시 강남구 테헤란로 130 호산빌딩, 5F, 6F<br>
                    사업자등록번호 : 487-86-00763│통신판매신고번호 : 851-87-00622<br>
                    고객만족센터 : 012-345-6789(무료상담전화)│대표전화 : 01-234-5678
                </p>
                <p class="copyright">
                    Copyright © 편리 Inc. All Rights Reserved.
                </p>
            </div>
            <div class="f_site">
                <select class="family">
                    <option value="">Family Site</option>
                    <option value="">CU</option>
                    <option value="">GS25</option>
                    <option value="">7-ELEVEN</option>
                </select>
                <div class="banner">
                    <img src="/semi/resources/img1/award_2017.jpg" alt="수상">
                </div>
            </div>
        </div>
    </div>
    <!--//footer-->
</body>
</html>