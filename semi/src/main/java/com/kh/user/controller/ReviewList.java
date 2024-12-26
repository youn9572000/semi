package com.kh.user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.common.model.vo.PageInfo;
import com.kh.user.model.service.ReviewService;
import com.kh.user.model.vo.Review;


@WebServlet("/review/list")
public class ReviewList extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ReviewList() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        int listCount; // 리뷰 총 개수
        int currentPage; // 요청한 페이지
        int pageLimit; // 페이징 바에 표시할 최대 페이지 수
        int reviewLimit; // 한 페이지당 보여질 리뷰 개수

        int startPage; // 페이징 바의 시작 수
        int endPage; // 페이징 바의 끝 수
        int maxPage; // 가장 마지막 페이지

        // 1. 리뷰 총 개수 조회 (productNo를 요청에서 가져옴)
        int productNo = request.getParameter("productNo") == null 
                        ? 1 
                        : Integer.parseInt(request.getParameter("productNo"));

        listCount = new ReviewService().selectReviewCount(productNo);

        // 2. 현재 페이지 설정
        currentPage = request.getParameter("cpage") == null 
                      ? 1 
                      : Integer.parseInt(request.getParameter("cpage"));

        // 3. 페이지 제한 및 리뷰 제한 설정
        pageLimit = 10;
        reviewLimit = 10;

        // 4. 페이징 계산
        maxPage = (int) Math.ceil((double) listCount / reviewLimit); // 총 페이지 수
        startPage = (currentPage - 1) / pageLimit * pageLimit + 1; // 페이징 바 시작 번호
        endPage = startPage + pageLimit - 1; // 페이징 바 끝 번호

        if (endPage > maxPage) {
            endPage = maxPage;
        }

        // PageInfo 객체 생성
        PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, reviewLimit, startPage, endPage, maxPage);

        // 5. 리뷰 리스트 가져오기
        List<Review> list = new ReviewService().selectReviewList(productNo);

        // 6. 가져온 데이터 요청에 저장
        request.setAttribute("list", list);
        request.setAttribute("pi", pi);

        // 7. 요청 전달 (product.jsp로 포워딩)
        request.getRequestDispatcher("/views/product/product.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doGet(request, response);
    }
}
