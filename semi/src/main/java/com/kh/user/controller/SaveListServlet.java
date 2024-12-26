package com.kh.user.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.user.model.service.SaveListService;
import com.kh.user.model.vo.Save;



@WebServlet("/kart/list")
public class SaveListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SaveListServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // SaveList.selectSaveListList() 메서드로 찜목록을 조회
            List<Save> saveList = new SaveListService().selectSaveListList();

            if (saveList == null || saveList.isEmpty()) {
                // 찜목록이 없을 경우 메시지 설정
                request.setAttribute("message", "찜목록이 비어 있습니다.");
            } else {
                // 찜목록이 있으면 리스트를 request에 설정
                request.setAttribute("saveList", saveList);
            }

            // /kart/savelist.jsp 페이지로 포워딩
            request.getRequestDispatcher("/kart/savelist.jsp").forward(request, response);
        } catch (Exception e) {
            // 예외 발생 시 로그 출력 및 오류 메시지 설정
            e.printStackTrace();
            request.setAttribute("errorMsg", "찜목록 조회 중 문제가 발생했습니다.");
            // 에러 페이지로 포워딩 (에러 메시지 출력)
            request.getRequestDispatcher("/kart/savelist.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // POST 요청은 GET 요청과 동일하게 처리
        doGet(request, response);
    }
}
