package com.kh.user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.user.model.service.SaveListService;
import com.kh.user.model.vo.Member;
import com.kh.user.model.vo.Save;


/**
 * Servlet implementation class SaveDelete
 */
@WebServlet("/kart/delete")
public class SaveDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public SaveDelete() {
		super();
	}

	/**
	 * Handles GET requests.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect(request.getContextPath() + "/kart/savelist");
	}

	/**
	 * Handles POST requests for deleting an item from the save list.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member loginUser = (Member) session.getAttribute("loginUser");

		// 로그인 확인
		if (loginUser == null) {
			session.setAttribute("alertMsg", "로그인이 필요합니다.");
			response.sendRedirect(request.getContextPath() + "/views/userPage/member/login.jsp");
			return;
		}

		// 상품 번호 가져오기 및 유효성 검증
		String productNoStr = request.getParameter("productNo");
		if (productNoStr == null || productNoStr.trim().isEmpty()) {
			session.setAttribute("alertMsg", "상품 번호가 유효하지 않습니다.");
			response.sendRedirect(request.getContextPath() + "/kart/savelist");
			return;
		}

		int productNo = Integer.parseInt(productNoStr);

		// Save 객체 생성
		int userNo = loginUser.getUserNo();
		Save saveToDelete = Save.builder()
			.userId(userNo)
			.productNo(productNo)
			.build();

		// 찜 목록에서 삭제
		int result = new SaveListService().deleteSaveList(saveToDelete);

		// 결과 처리
		if (result > 0) {
			session.setAttribute("alertMsg", "상품이 찜목록에서 삭제되었습니다.");
		} else {
			session.setAttribute("alertMsg", "찜목록 삭제에 실패했습니다. 다시 시도해주세요.");
		}

		// 찜 목록 페이지로 리다이렉트
		response.sendRedirect(request.getContextPath() + "/kart/savelist");
	}
}
