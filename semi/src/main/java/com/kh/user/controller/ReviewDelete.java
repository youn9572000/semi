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


@WebServlet("/review/delete")
public class ReviewDelete extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ReviewDelete() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 요청 파라미터에서 reviewNo와 productNo 가져오기
        int reviewNo = Integer.parseInt(request.getParameter("reviewNo")); // 삭제하려는 리뷰 번호
        int productNo = Integer.parseInt(request.getParameter("productNo")); // 해당 상품 번호

        // 세션에서 로그인 사용자 정보 가져오기
        HttpSession session = request.getSession();
        Member loginUser = (Member) session.getAttribute("loginUser"); // 세션에서 로그인 사용자 정보 가져오기

        if (loginUser == null) { // 로그인하지 않은 경우
            response.sendRedirect(request.getContextPath() + "/login"); // 로그인 페이지로 리다이렉트
            return;
        }

        int userNo = loginUser.getUserNo(); // 로그인한 사용자의 회원 번호

        // 리뷰 정보를 가져와서 작성자와 로그인한 사용자를 비교
        Review review = new ReviewService().selectOne(reviewNo); // 리뷰 정보를 가져오기

     // 리뷰가 존재하지 않거나, 리뷰 작성자가 현재 로그인한 사용자가 아닌 경우 처리
        if (review == null || !review.getReviewWriter().equals(loginUser.getUserId())) {
            // review가 null인지 확인
            // - 리뷰가 null이라면 데이터베이스에 해당 리뷰가 존재하지 않음
            // - 즉, 삭제할 대상이 없음을 의미

            // review.getReviewWriter(): 리뷰 작성자의 userId 반환
            // loginUser.getUserId(): 현재 로그인한 사용자의 userId 반환
            // !review.getReviewWriter().equals(loginUser.getUserId()): 
            // - 리뷰 작성자의 userId와 로그인한 사용자의 userId가 다를 경우 true
            // - 즉, 리뷰 작성자가 아닌 사용자가 삭제를 시도하면 true
            
            // 조건이 참일 경우, 상품 상세 페이지로 리다이렉트하며 "권한 없음" 에러 전달
            response.sendRedirect(request.getContextPath() + "/product/detail?productNo=" + productNo + "&error=noPermission");
            
            // 현재 메서드 실행 종료 (삭제 로직 실행되지 않음)
            return;
        }


        // 리뷰 삭제 처리
        int result = new ReviewService().deleteReview(reviewNo);

        if (result > 0) {
            // 삭제 성공: 리뷰 목록 페이지로 리다이렉트
            response.sendRedirect(request.getContextPath() + "/review/list");
        } else {
            // 삭제 실패: 상품 상세 페이지로 리다이렉트
            response.sendRedirect(request.getContextPath() + "/product/detail?productNo=" + productNo + "&error=deleteFailed");
        }
    }
}