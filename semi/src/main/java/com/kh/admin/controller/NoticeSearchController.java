package com.kh.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.admin.model.vo.Board;

/**
 * Servlet implementation class NoticeSearchController
 */
@WebServlet("/admin/search")
public class NoticeSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeSearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardType = request.getParameter("type"); // 게시판 종류 (e.g., "event", "free", "notice")
        String keyword = request.getParameter("keyword"); // 검색어
        List<Board> searchResults = null;
        String viewPath = null;

        AdminSearchService searchService = new AdminSearchService();

        // 게시판 종류에 따라 검색 로직 분기
        switch (boardType) {
            case "event":
                searchResults = searchService.searchEventBoards(keyword);
                viewPath = "/views/adminPage/notice/ManageEventBoard.jsp";
                break;
            case "free":
                searchResults = searchService.searchFreeBoards(keyword);
                viewPath = "/views/adminPage/notice/ManageFreeBoard.jsp";
                break;
            case "notice":
                searchResults = searchService.searchNoticeBoards(keyword);
                viewPath = "/views/adminPage/notice/ManageNotice.jsp";
                break;
            default:
                // 기본 처리: 잘못된 요청
                request.setAttribute("error", "잘못된 게시판 유형입니다.");
                viewPath = "/views/errorPage.jsp";
                break;
        }

        // 검색 결과를 JSP에 전달
        if (searchResults != null) {
            request.setAttribute("list", searchResults);
        }
        request.getRequestDispatcher(viewPath).forward(request, response);
    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
