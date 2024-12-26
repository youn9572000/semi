package com.kh.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.admin.model.service.AdminDeleteService;

/**
 * Servlet implementation class NoticeDeleteController
 */
@WebServlet("/noticeDelete")
public class NoticeDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String eboardNo = request.getParameter("eboardNo");
        String fboardNo = request.getParameter("fboardNo");
        String mboardNo = request.getParameter("mboardNo");

        if (eboardNo != null) {
            System.out.println("Deleting Event Board: " + eboardNo);
            new AdminDeleteService().deleteEBoard(Integer.parseInt(eboardNo));
            response.sendRedirect(request.getContextPath() + "/admin/elist"); // 이벤트 게시판 목록으로 이동
        } else if (fboardNo != null) {
            System.out.println("Deleting Free Board: " + fboardNo);
            new AdminDeleteService().deleteFBoard(Integer.parseInt(fboardNo));
            response.sendRedirect(request.getContextPath() + "/admin/flist"); // 자유 게시판 목록으로 이동
        } else if (mboardNo != null) {
            System.out.println("Deleting Notice Board: " + mboardNo);
            new AdminDeleteService().deleteMBoard(Integer.parseInt(mboardNo));
            response.sendRedirect(request.getContextPath() + "/admin/mlist"); // 공지사항 목록으로 이동
        } else {
            // 삭제 대상이 없을 경우 기본 페이지로 이동
            response.sendRedirect(request.getContextPath() + "/admin/defaultList");
        }
    }
}