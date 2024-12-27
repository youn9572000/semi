package com.kh.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.admin.model.service.AdminDeleteService;
import com.kh.admin.model.vo.Member;
import com.kh.common.model.vo.PageInfo;

/**
 * Servlet implementation class MemberDeleteController
 */
@WebServlet("/MemberDeleteController")
public class MemberDeleteController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AdminDeleteService adminDeleteService = new AdminDeleteService(); // 인스턴스 생성

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int currentPage = 1; // 기본 페이지
        int pageLimit = 10; // 페이징바에 표시할 최대 개수
        int boardLimit = 10; // 한 페이지당 보여질 게시글의 최대 개수

        // 현재 페이지 번호 처리
        if (request.getParameter("currentPage") != null) {
            currentPage = Integer.parseInt(request.getParameter("currentPage"));
        }

        // 전체 회원 수 조회
        int listCount = adminDeleteService.getMemberCount();

        // 페이징 계산
        int maxPage = (int) Math.ceil((double) listCount / boardLimit);
        int startPage = ((currentPage - 1) / pageLimit) * pageLimit + 1;
        int endPage = startPage + pageLimit - 1;
        if (endPage > maxPage) endPage = maxPage;

        // PageInfo 객체 생성
        PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, startPage, endPage, maxPage);


        // 회원 목록 조회
        int startRow = (currentPage - 1) * boardLimit + 1;
        int endRow = currentPage * boardLimit;
        List<Member> memberList = adminDeleteService.getMemberList(startRow, endRow);

        // 데이터 설정
        request.setAttribute("pi", pi);
        request.setAttribute("memberList", memberList);

        // JSP로 포워딩
        
        request.getRequestDispatcher("/views/adminPage/admin/MemberDelete.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response); // POST 요청도 GET 처리 방식으로
    }
}
