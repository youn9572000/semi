<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page
	import="java.util.List, com.kh.admin.model.vo.Member, com.kh.common.model.vo.PageInfo"%>
<%
	List<Member> list = (List<Member>)request.getAttribute("list");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원삭제 페이지</title>
</head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/adminCss/delete.css">
<body>
	<div class="container">

		<%@ include file="/views/common/AdminSidebar.jsp"%>

		<div class="main-content">
			<header>
				<h1>회원삭제</h1>
				<div class="admin-icons">
					<a href="#" class="tooltip" id="logout-btn"> <img
						src="<%=contextPath%>/resources/logout이미지.png" alt="로그아웃">
					</a> <a href="<%= contextPath %>/views/adminPage/admin/MainPage.jsp" class="tooltip" id="home-btn"> <img
						src="<%=contextPath%>/resources/mainPage이동.png" alt="메인페이지 이동"
						id="home">
					</a>
				</div>
				<script>
					document.getElementById('logout-btn').setAttribute(
							'data-tooltip', '로그아웃');
					document.getElementById('home-btn').setAttribute(
							'data-tooltip', '메인페이지 이동');
				</script>
			</header>

			<form action="deleteMember" method="post">
				<div class="search-box">
					<input type="text" name="search" placeholder="검색">
					<button type="submit">조회</button>
				</div>
				<table>
					<thead>
						<tr>
							<th>번호</th>
							<th>아이디</th>
							<th>가입일</th>
							<th>체크박스</th>
							<th>회원삭제</th>
							<th>기타</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="member" items="${memberList}">
							<tr>
								<td>${member.index}</td>
								<td>${member.id}</td>
								<td>${member.joinDate}</td>
								<td><input type="checkbox" name="deleteCheckbox"
									value="${member.id}"></td>
								<td><button type="button" class="delete-btn"
										onclick="deleteMember('${member.id}')">회원삭제</button></td>
								<td></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="pagination">
					<a href="#">&lt;</a> <a href="#">1</a> <a href="#">2</a> <a
						href="#">3</a> <a href="#">&gt;</a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
