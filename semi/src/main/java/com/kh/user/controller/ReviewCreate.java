package com.kh.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.user.model.service.ReviewService;
import com.kh.user.model.vo.Member;
import com.kh.user.model.vo.Review;



@WebServlet("/review/create")
public class ReviewCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewCreate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/views/product/product.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    int productNo = Integer.parseInt(request.getParameter("productNo")); // 상품 번호
	    String reviewWriter = request.getParameter("reviewWriter");         // 리뷰 작성자 (userId)
	    String reviewContent = request.getParameter("reviewContent");       // 리뷰 내용
	    int reviewScore = Integer.parseInt(request.getParameter("reviewScore")); // 리뷰 별점

	    HttpSession session = request.getSession();
	    Member loginUser = (Member) session.getAttribute("loginUser");
	    int userNo = loginUser.getUserNo(); // 로그인한 사용자의 회원 번호

	    // 작성자 검증
	    if (!reviewWriter.equals(loginUser.getUserId())) {
	        request.setAttribute("errorMsg", "잘못된 접근입니다.");
	        request.getRequestDispatcher("/views/common/errorPage.jsp").forward(request, response);
	        return;
	    }

	    // Review 객체 생성
	    Review r = Review.builder()
	            .productNo(productNo)
	            .reviewWriter(reviewWriter)
	            .reviewContent(reviewContent)
	            .reviewScore(reviewScore)
	            .build();

	    // 리뷰 등록 처리
	    int result = new ReviewService().insertReview(r);

	    if (result > 0) {
	        // 등록 성공: 리뷰 목록 페이지로 이동
	        response.sendRedirect(request.getContextPath() + "/review/list?productNo=" + productNo);
	    } else {
	        // 등록 실패: 리뷰 작성 페이지로 이동
	        request.setAttribute("errorMsg", "리뷰 등록에 실패했습니다.");
	        request.setAttribute("productNo", productNo); // 상품 번호 유지
	        request.setAttribute("reviewContent", reviewContent); // 입력한 리뷰 내용 유지
	        request.setAttribute("reviewScore", reviewScore); // 입력한 별점 유지
	        request.getRequestDispatcher("/views/product/product.jsp").forward(request, response);
	    }
	}
}
