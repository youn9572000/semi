<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품관리 페이지</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/adminCss/product.css">
</head>

<body>
	<div class="container">

		<%@ include file="/views/common/AdminSidebar.jsp"%>
		<div class="main-content">
			<div class="header">
				<h1>상품관리</h1>
				<div class="admin-icons">
					<a href="#" class="tooltip" id="logout-btn"> <img
						src="<%= contextPath %>/resources/logout이미지.png" alt="로그아웃">
					</a> <a href="#" class="tooltip" id="home-btn"> <img
						src="<%= contextPath %>/resources/mainPage이동.png" alt="메인페이지 이동"
						id="home">
					</a>
				</div>
			</div>

			<script>
				document.getElementById('logout-btn').setAttribute('data-tooltip', '로그아웃');
				document.getElementById('home-btn').setAttribute('data-tooltip', '메인페이지 이동');
			</script>



			<div class="search-bar">
				<input type="text" placeholder="검색">
				<button>검색</button>
			</div>

			<div class="main-content">
				<div class="action-buttons-wrapper">
					<button class="add-btn" onclick="showModal()">추가</button>
					<button class="delete-btn">삭제</button>
				</div>
				<div class="header">
					<div class="nav-bar">
						<button class="store-btn" data-store="all"
							onclick="filterStore('all')">전체상품</button>
						<button class="store-btn" data-store="cu"
							onclick="filterStore('cu')">CU</button>
						<button class="store-btn" data-store="7eleven"
							onclick="filterStore('7eleven')">7-Eleven</button>
						<button class="store-btn" data-store="gs25"
							onclick="filterStore('gs25')">GS25</button>
					</div>
				</div>

				<div class="content">
					<div class="product-list">
						<!-- 상품 목록 예시 -->
						<div class="product-item cu">
							<p>CU 상품 1</p>
						</div>
						<div class="product-item cu">
							<p>CU 상품 2</p>
						</div>
						<div class="product-item 7eleven">
							<p>7-Eleven 상품 1</p>
						</div>
						<div class="product-item 7eleven">
							<p>7-Eleven 상품 2</p>
						</div>
						<div class="product-item gs25">
							<p>GS25 상품 2</p>
						</div>
						<div class="product-item gs25">
							<p>GS25 상품 2</p>
						</div>
					</div>
				</div>

				<script>
				    function filterStore(store) {
				        const products = document.querySelectorAll('.product-item');
				        products.forEach(product => {
				            if (store === 'all' || product.classList.contains(store)) {
				                product.style.display = 'block';
				            } else {
				                product.style.display = 'none';
				            }
				        });
				    }
				</script>

				<!-- 상품 추가 모달 창 -->
				<div id="modal" class="modal" style="display: none;">
					<div class="modal-content">
						<h2>상품 추가</h2>
						<select>
							<option>편의점 이름 선택</option>
						</select> <select>
							<option>상품 선택</option>
						</select>
						<div class="modal-buttons">
							<button class="confirm-btn">추가하기</button>
							<button class="cancel-btn" onclick="closeModal()">취소</button>
						</div>
					</div>
				</div>

				<script>
			        // 모달 열기
			        function showModal() {
			            document.getElementById('modal').style.display = 'block';
			        }
			
			        // 모달 닫기
			        function closeModal() {
			            document.getElementById('modal').style.display = 'none';
			        }
			    </script>
			</div>
			<div class="more-btn">
				<button>더보기</button>
			</div>
		</div>
	</div>
</body>
</html>
