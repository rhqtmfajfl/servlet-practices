package com.poscoict.guestbook.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class GuestbookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String actionName = request.getParameter("a");
		request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);

//		if("deleteform".equals(actionName)) {
//			request.setAttribute("no_test", actionName);
//			request.getRequestDispatcher("/guestbook02/index.jsp").forward(request, response);
//		}
		//여기서 actionName을 받으면 그 actionName을 어떻게 사용해야 할 까?
		
//		response.getWriter().println("<h1>Guestbook02!!!<h1>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
