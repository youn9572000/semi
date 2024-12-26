package com.kh.user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.kh.user.model.service.ReviewService;
import com.kh.user.model.vo.Review;

/**
 * Servlet implementation class ReviewUpdate
 */
@WebServlet("/review/update")
public class ReviewUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int reviewNo = Integer.parseInt(request.getParameter("reviewNo")); // reviewNo 파라미터를 정수로 변환

		Review r = new ReviewService().selectOne(reviewNo); // reviewNo로 특정 리뷰 조회

		request.setAttribute("r", r); // 조회된 리뷰 데이터를 request에 저장
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Review r = Review.builder()
				.reviewNo(Integer.parseInt(request.getParameter("reviewNo")))
				.reviewContent(request.getParameter("content"))
				.reviewScore(Integer.parseInt(request.getParameter("reviewScore")))
				.build();
		int result = new ReviewService().updateReview(r);
		if(result > 0) {
			response.sendRedirect(request.getContextPath() + "/review/detail?reviewNo=" + r.getReviewNo());
		}else {
			request.setAttribute("errorMsg", "리뷰 수정 실패!! 권한이 없습니다!");
			
		}
	}

}
