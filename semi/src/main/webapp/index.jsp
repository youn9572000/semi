<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>

	<!-- visual -->
	<div id="visual">
		<img src="resources/img1/편리하조 메인 배너.png" alt="메인 배너">
	</div>
	<!-- //visual -->

	<!-- container -->
	<div id="container">
		<div id="brand">
			<div class="title">
				<h1>편의점 상품</h1>
				<br>
				<p>
					GS25부터 7_ELEVEN까지<br> 궁금했던 모든 상품을 한번에 보기
				</p>
			</div>
			<ul class="category">
				<li><a href="#">간편식사</a></li>
				<li><a href="#">즉석조리</a></li>
				<li><a href="#">과자류</a></li>
				<li><a href="#">아이스크림</a></li>
				<li><a href="#">식품</a></li>
				<li><a href="#">음료</a></li>
			</ul>
			<div class="product">
				<ul class="product_list">
					<li><a href="#"> <img src="resources/img1/product1.jpg"
							alt="제품1">
							<p>샌)맛폴리피스타치오딸기1</p>
					</a></li>
					<li><a href="#"> <img src="resources/img1/product2.jpg"
							alt="제품2">
							<p>면)머쉬룸빠네파스타1</p>
					</a></li>
					<li><a href="#"> <img src="resources/img1/product3.jpg"
							alt="제품3">
							<p>도)급식대가소불고기1</p>
					</a></li>
					<li><a href="#"> <img src="resources/img1/product4.jpg"
							alt="제품4">
							<p>주)급식대가소고기야채1</p>
					</a></li>
				</ul>
				<a href="#">
					<div class="more">more</div>
				</a>

				<!-- 모달을 실행할 버튼 -->
				<div class="modal-btn-container"
					style="display: flex; justify-content: center;">
					<button type="button" class="btn btn-primary"
						data-bs-toggle="modal" data-bs-target="#exampleModal"
						style="width: 250px; height: 50px; background-color: pink; border: none;">
						누르면 혜택 팡팡 ♥</button>
				</div>

				<!-- 모달 -->
				<div class="modal fade" id="exampleModal" tabindex="-1"
					aria-labelledby="exampleModalLabel" aria-hidden="true">
					<div class="modal-dialog modal-lg modal-dialog-centered">
						<div class="modal-content">
							<div class="modal-header">
								<h1 class="modal-title fs-5" id="exampleModalLabel">나는 찬둥
									회원님 ♥</h1>
								<button type="button" class="btn-close" data-bs-dismiss="modal"
									aria-label="Close"></button>
							</div>
							<div class="modal-body">찜목록에 담으신 상품이 '1+1' 이래요 ♥</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-bs-dismiss="modal">장바구니</button>
								<button type="button" class="btn btn-primary">행사 게시판 이동</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div id="video">
			<iframe
				src="https://www.youtube.com/embed/vJhw_06LlQM?si=iBp6R9l9aL4pRz6-"
				title="Food of Convenient Store: The Founders" frameborder="0"
				allow="accelerometer; autoplay; clipboard-write;
            encrypted-media; gyroscope; picture-in-picture; web-share"
				referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
		</div>
		<div id="community">
			<div class="title">
				<h1>COMMUNITY</h1>
				<p>
					자유 게시판, 공지사항, 베스트 조합등 <br> 편의점과 관련된 다양한 게시판을 연동합니다.
				</p>
			</div>
			<div class="commu">
				<div class="block1">
					<iframe
						src="https://www.facebook.com/plugins/post.php?href=https%3A%2F%2Fwww.facebook.com%2F7elevenkorea%2Fposts%2Fpfbid0wjZHo6jQi4RZaTLTCC6qSWbRe44cYDBu7UBjVQr4cjKL3dMAsgHrb6NyKHGfKAApl&show_text=true&width=500"
						width="300" height="600" style="border: none; overflow: hidden"
						scrolling="no" frameborder="0" allowfullscreen="true"
						allow="autoplay; clipboard-write; encrypted-media; picture-in-picture; web-share"></iframe>
				</div>
				<div class="block2">
					<div class="block_video">
						<h3 class="block_title">게시판1</h3>
						<p class="block_text">
							게시판1 영역<br> 입니다.
						</p>
						<a href="#" class="block_btn">자세히 보기</a>
					</div>
					<div class="block_story">
						<h3 class="block_title">고객센터</h3>
						<p class="block_text">
							이 사이트에<br> 여러분의 다양한 의견을 남겨주세요.
						</p>
						<a href="#" class="block_btn">자세히 보기</a>
					</div>
				</div>
				<div class="block3">
					<div class="block_recipe">
						<h3 class="block_title">게시판 2</h3>
						<p class="block_text">게시판 2 영역입니다.</p>
						<a href="#" class="block_btn">자세히 보기</a>
					</div>
					<div class="block_notice">
						<h3 class="block_title">공지사항</h3>
						<p class="block_text">편의점 리뷰의 개인정보취급방침 개정 안내</p>
						<a href="#" class="block_btn">자세히 보기</a>
					</div>
					<div class="block_shop">
						<h3 class="block_title">편의점 공식몰</h3>
						<p class="block_text">
							편의점의<br> 다양한 제품을 만나보세요.
						</p>
						<a href="https://cu.bgfretail.com" class="block_btn">자세히 보기</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- //container -->

	<!-- footer -->
	<div id="footer_wrap">
		<div id="footer">
			<p class="f_logo">
				<a href="#"><img src="resources/img1/편의점 로고 예시1.png" alt="logo"></a>
			</p>
			<div class="f_copyright">
				<ul class="menu">
					<li><a href="#">회사소개</a></li>
					<li><a href="#">고객센터</a></li>
					<li><a href="#">IR</a></li>
					<li><a href="#">인재채용</a></li>
					<li><a href="#">찾아오시는길</a></li>
					<li><a href="#" style="font-weight: bold;">개인정보처리방침</a></li>
				</ul>
				<p class="info">
					서울특별시 강남구 테헤란로 130 호산빌딩, 5F, 6F<br> 사업자등록번호 :
					487-86-00763│통신판매신고번호 : 851-87-00622<br> 고객만족센터 :
					012-345-6789(무료상담전화)│대표전화 : 01-234-5678
				</p>
				<p class="copyright">Copyright © 편리 Inc. All Rights Reserved.</p>
			</div>
			<div class="f_site">
				<select class="family">
					<option value="">Family Site</option>
					<option value="">CU</option>
					<option value="">GS25</option>
					<option value="">7-ELEVEN</option>
				</select>
				<div class="banner">
					<img src="resources/img1/award_2017.jpg" alt="수상">
				</div>
			</div>
		</div>
	</div>
	<!-- //footer -->
	
	<script>// 대메뉴와 소메뉴 매핑
	const menuData = {
		    "게시판": [
		        { name: "공지사항", url: "<%=request.getContextPath()%>/board/notice" },
		        { name: "자유게시판", url: "<%=request.getContextPath()%>/views/userPage/board/boardFree.jsp" },
		        { name: "행사게시판", url: "<%=request.getContextPath()%>/views/userPage/board/boardEvent.jsp" }
		    ],
		    "고객센터": [
		        { name: "자주 묻는 질문", url: "<%=request.getContextPath()%>/views/userPage/board/serviceFAQ.jsp" },
		        { name: "1:1 문의", url: "<%=request.getContextPath()%>/views/userPage/board/serviceInquiry.jsp" }
		    ]
		};

		// 대메뉴에 소메뉴 동적 추가
		document.querySelectorAll('.menu-item').forEach(menuItem => {
		    const submenuData = menuData[menuItem.dataset.menu];

		    if (submenuData) {
		        // 소메뉴 생성
		        const submenu = document.createElement('ul');
		        submenu.classList.add('submenu');

		        submenuData.forEach(subItem => {
		            const li = document.createElement('li');
		            const a = document.createElement('a');
		            a.textContent = subItem.name;
		            a.href = subItem.url;
		            li.appendChild(a);
		            submenu.appendChild(li);
		        });

		        // 대메뉴 아래에 소메뉴 추가
		        menuItem.appendChild(submenu);
		    }
		});
	</script>
	
</body>
</html>