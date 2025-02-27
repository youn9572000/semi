<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 페이지</title>
    <!-- 메인 콘텐츠 CSS 연결 -->
    <link rel="stylesheet" type="text/css"
     href="${pageContext.request.contextPath}/resources/css/adminCss/skin.css">
</head>
<body>
	
	<div class="container">
    <!-- 사이드바 Include -->
    
    <%@ include file="/views/common/AdminSidebar.jsp" %>
    <!-- 메인 콘텐츠 -->
   
        <!-- 메인 콘텐츠 -->
        <div class="main-content">
            <h1>관리자 페이지</h1>

            <!-- 스킨편집 섹션 -->
            <div class="section">
                <h3>스킨편집</h3>
                <div>
                    <h4>타이틀 헤더</h4>
                    <label for="logo-upload">로고(넓이 180px)</label>
                    <input type="file" id="logo-upload" name="logo-upload">
                </div>
                <div>
                    <h4>이벤트 배너 섹션</h4>
                    <label for="banner-upload">메인 이벤트 배너 이미지</label>
                    <input type="file" id="banner-upload" name="banner-upload">
                </div>
                <div>
                    <h4>메인 - SNS</h4>
                    <label for="youtube-link">유튜브 링크</label>
                    <input type="text" id="youtube-link" name="youtube-link" placeholder="예) https://www.youtube.com/embed/...">
                </div>
            </div>

            <!-- 추가된 COMMUNITY 섹션 -->
            <div class="section">
                <h3>COMMUNITY 섹션</h3>
                <div>
                    <h4>배너 1 배경 이미지</h4>
                    <input type="file" id="banner-bg" name="banner-bg">
                </div>
                <div>
                    <h4>배너 1 버튼가기 URL</h4>
                    <input type="text" id="banner-url" name="banner-url" placeholder="링크를 입력하세요.">
                </div>
                <div>
                    <h4>배너 1 문구</h4>
                    <input type="text" id="banner-text" name="banner-text" placeholder="문구를 입력하세요.">
                </div>
                <div>
                    <h4>배너 1 문구 색상</h4>
                    <input type="color" id="banner-color" name="banner-color">
                </div>
            </div>
        </div>
    </div>
</body>
</html>