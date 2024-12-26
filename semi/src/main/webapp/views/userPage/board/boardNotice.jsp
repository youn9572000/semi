<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>공지사항</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/board.css"
	type="text/css">
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
					<ul class="sort-options">
						<li onclick="sortNotices('추천')">추천순</li>
						<li onclick="sortNotices('조회')">조회순</li>
						<li onclick="sortNotices('최신')">최신순</li>
					</ul>
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
						<th>조회수</th>
					</tr>
				</thead>
				<tbody id="noticeTableBody">
					<!-- JSP로 공지사항 데이터를 렌더링 -->
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
				</tbody>
			</table>
			
			<!-- 페이지네이션 -->
      <div class="pagination">
        <button class="page-btn">&lt;</button>
        <button class="page-btn active">1</button>
        <button class="page-btn">2</button>
        <button class="page-btn">3</button>
        <button class="page-btn">4</button>
        <button class="page-btn">5</button>
        <button class="page-btn">&gt;</button>
      </div>


		</section>
	</main>

	<script>
	
	
        // 정렬 기능
        function sortNotices(criteria) {
            const rows = Array.from(document.querySelectorAll("#noticeTableBody tr"));
            const sortedRows = rows.sort((rowA, rowB) => {
                const getValue = (row, index) => row.children[index].innerText;

                if (criteria === "추천") {
                    return parseInt(getValue(rowB, 4)) - parseInt(getValue(rowA, 4)); // 추천순
                } else if (criteria === "조회") {
                    return parseInt(getValue(rowB, 4)) - parseInt(getValue(rowA, 4)); // 조회순
                } else if (criteria === "최신") {
                    return new Date(getValue(rowB, 3)) - new Date(getValue(rowA, 3)); // 최신순
                }
            });

            const tableBody = document.getElementById("noticeTableBody");
            tableBody.innerHTML = "";
            sortedRows.forEach(row => tableBody.appendChild(row));
        }

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
