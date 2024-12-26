package com.kh.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.admin.model.service.BlockService;

/**
 * Servlet implementation class SearchUser
 */
@WebServlet("/admin/SearchUser")
public class SearchUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchUserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchId = request.getParameter("searchId");
		String filter = request.getParameter("filter");
		
		
		
	    if (searchId == null || searchId.trim().isEmpty()) {
	        searchId = null;
	        filter = "all";
	    }
		
		String result = new BlockService().selectSearchId(searchId); 
		
		request.setAttribute("searchId", searchId);
		request.setAttribute("result", result);
		request.setAttribute("filter", filter);
		
		System.out.println("Received searchId: " + searchId);
		
		request.getRequestDispatcher("/views/adminPage/admin/MemberBlock.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
