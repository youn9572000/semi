<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.List, com.kh.admin.model.vo.Board, com.kh.common.model.vo.PageInfo"%>
<%
	List<Board> list = (List<Board>)request.getAttribute("list");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>공지사항</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/board.css"
	type="text/css">
<style>
button {
	width: 100px !important;
	height: 40px !important;
	font-size: 14px;
}

.page-btn {
	width: 50px !important;
	height: 40px !important;
}
</style>

</head>
<body>
	<%@ include file="/views/common/menubar.jsp"%>

	<main>
		<section class="notice-section">
			<h2>공지사항</h2>

			<!-- 검색 및 정렬 -->
			<div class="search-bar">
				<div class="sort-dropdown">
					<button class="sort-icon-btn">정렬 ▼</button>
					<div class="sort-options">
						<a href="<%= request.getContextPath() %>/board/notice?cpage=1&sort=date">날짜순</a>
    					<a href="<%= request.getContextPath() %>/board/notice?cpage=1&sort=count">조회수순</a>
    					<a href="<%= request.getContextPath() %>/board/notice?cpage=1&sort=plus">추천순</a>
					</div>
				</div>
				<input type="text" id="searchInput" placeholder="검색어를 입력하세요" />
				<button onclick="filterTable()">🔍 검색</button>
			</div>

			<!-- 공지사항 테이블 -->
			<table class="notice-table">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>날짜</th>
						<th>추천수</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody id="noticeTableBody">
					<!-- JSP로 공지사항 데이터를 렌더링 -->


					<%if(list.isEmpty()){ %>
					<tr>
						<td colspan="6">조회된 리스트가 없습니다.</td>
					</tr>
					<%} else {%>
					<%for(Board b : list){ %>
					<tr>
						<td><%= b.getBoardNo() %></td>
						<td><%= b.getBoardTitle() %></td>
						<td><%= b.getBoardWriter() %></td>
						<td><%= b.getCreateDate() %></td>
						<td><%= b.getPlus() %></td>
						<td><%= b.getCount() %></td>
					</tr>
						<%} %>
					<%} %>
				</tbody>
			</table>

			<!-- 페이지네이션 -->
			<div class="pagination">
				<% if (currentPage > 1) { %>
			        <!-- 이전 페이지 이동 -->
			        <button class="page-btn" onclick="location.href='<%= request.getContextPath() %>/board/notice?cpage=1'">&lt;&lt;</button>
			        <button class="page-btn" onclick="location.href='<%= request.getContextPath() %>/board/notice?cpage=<%= (currentPage > 1) ? (currentPage - 1) : 1 %>'"<%= (currentPage <= 1) ? "disabled" : "" %>>&lt;</button>
			    <% } %>
			
			    <% for (int p = startPage; p <= endPage; p++) { %>
			    <button class="page-btn <%= (currentPage == p) ? "active" : "" %>" 
        			onclick="location.href='<%= request.getContextPath() %>/board/notice?cpage=<%= p %>'">
    			<%= p %>
				</button>
			    
			    <!-- <a href="<%= request.getContextPath() %>/board/notice?cpage=<%= p %>"
			           class="<%= (currentPage == p) ? "active" : "" %>">
			            <%= p %>
			    </a>-->
			    
			    <% } %>
			
			    <% if (currentPage < maxPage) { %>
			        <!-- 다음 페이지 이동 -->
			        <button class="page-btn" onclick="location.href='<%= request.getContextPath() %>/board/notice?cpage=<%= (currentPage < maxPage) ? (currentPage + 1) : maxPage %>'"<%= (currentPage >= maxPage) ? "disabled" : "" %>>&gt;</button>
			        <button class="page-btn" onclick="location.href='<%= request.getContextPath() %>/board/notice?cpage=<%= maxPage %>'">&gt;&gt;</button>
			    <% } %>
				<!-- <button class="page-btn">&lt;</button>
				<button class="page-btn active">1</button>
				<button class="page-btn">2</button>
				<button class="page-btn">3</button>
				<button class="page-btn">4</button>
				<button class="page-btn">5</button>
				<button class="page-btn">&gt;</button> -->
			</div>

		</section>
	</main>

	<script>
		
		function movePage(cpage){
			location.assign('<%= request.getContextPath() %>/board/notice/list?cpage='+cpage);
		}
		
		// 드롭다운 토글 (선택 사항)
		document.addEventListener('DOMContentLoaded', () => {
		    const dropdownButton = document.querySelector('.sort-icon-btn');
		    const dropdownMenu = document.querySelector('.sort-options');

		    dropdownButton.addEventListener('click', (event) => {
		        event.stopPropagation(); // 이벤트 버블링 방지
		        dropdownMenu.classList.toggle('show');
		    });

		    document.addEventListener('click', (event) => {
		        if (!dropdownMenu.contains(event.target)) {
		            dropdownMenu.classList.remove('show');
		        }
		    });
		});
        

        // 검색 기능
        function filterTable() {
            const searchInput = document.getElementById("searchInput").value.toLowerCase();
            const rows = document.querySelectorAll("#noticeTableBody tr");
            
            rows.forEach(row => {
                const title = row.children[1].innerText.toLowerCase();
                const author = row.children[2].innerText.toLowerCase();
                if (title.includes(searchInput) || author.includes(searchInput)) {
                    row.style.display = ""; // 표시
                } else {
                    row.style.display = "none"; // 숨김
                }
            });
        }
    </script>
</body>
</html>
