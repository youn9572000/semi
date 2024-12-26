<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>관리자 메인 페이지</title>
<link rel="stylesheet" type="text/css" href="resources/css/common.css">
</head>
<body>
        

 <div class="container">
	<%@ include file="/views/common/AdminSidebar.jsp" %>
        <!-- 메인 컨텐츠 -->
        <main class="main-content">
            <header>
                <h1>방문자수 통계</h1>
                <div class="stats">
                    <div>
                        <span>전체 방문자</span>
                        <strong>2,504,002</strong>
                    </div>
                    <div>
                        <span>Today</span>
                        <strong>379</strong>
                    </div>
                    <div>
                        <span>Yesterday</span>
                        <strong>1,578</strong>
                    </div>
                </div>
            </header>

            <!-- 1:1 문의 -->
            <section class="inquiries">
                <h2>1:1 문의</h2>
                <table>
                    <thead>
                        <tr>
                            <th>번호</th>
                            <th>제목</th>
                            <th>작성자</th>
                            <th>작성일</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>1</td>
                            <td>안녕하세요</td>
                            <td>관리자</td>
                            <td>2024-12-16</td>
                        </tr>
                    </tbody>
                </table>
            </section>
        </main>
    </div>


</body>
</html>