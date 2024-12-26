package com.kh.user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.user.model.service.SaveListService;
import com.kh.user.model.vo.Member;
import com.kh.user.model.vo.Save;

@WebServlet("/kart/insert")
public class SaveInsert extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SaveInsert() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        List<Save> saveList = new SaveListService().selectSaveListList();
        request.setAttribute("saveList", saveList);
        request.getRequestDispatcher("/kart/savelist.jsp").forward(request, response);
    }

    @Override
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

        // 상품 번호 가져오기
        String productNoStr = request.getParameter("productNo");
        if (productNoStr == null || productNoStr.trim().isEmpty()) {
            session.setAttribute("alertMsg", "상품 번호가 유효하지 않습니다.");
            response.sendRedirect(request.getContextPath() + "/kart/list");
            return;
        }

        int productNo;
        try {
            productNo = Integer.parseInt(productNoStr);
        } catch (NumberFormatException e) {
            session.setAttribute("alertMsg", "상품 번호가 잘못되었습니다.");
            response.sendRedirect(request.getContextPath() + "/kart/list");
            return;
        }

        // 상품 이름 가져오기
        String productName = request.getParameter("productName");
        if (productName == null || productName.trim().isEmpty()) {
            productName = "이름 없음"; // 기본값 설정
        }

        // Save 객체 생성
        int userNo = loginUser.getUserNo();
        Save s = Save.builder()
                     .userId(userNo)
                     .productNo(productNo)
                     .productName(productName)
                     .build();

        // 데이터베이스에 추가
        int result = new SaveListService().insertSaveList(s);

        // 결과 처리
        if (result > 0) {
            session.setAttribute("alertMsg", "상품이 찜목록에 추가되었습니다.");
            response.sendRedirect(request.getContextPath() + "/kart/list");
        } else {
            session.setAttribute("alertMsg", "찜목록 추가에 실패했습니다. 다시 시도해주세요.");
            response.sendRedirect(request.getContextPath() + "/kart/savelist");
        }
    }
}
