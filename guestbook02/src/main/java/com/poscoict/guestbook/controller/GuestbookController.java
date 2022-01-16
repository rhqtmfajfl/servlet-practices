package com.poscoict.guestbook.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poscoict.guestbook.dao.guestbookDao;
import com.poscoict.guestbook.vo.guestbookVo;


public class GuestbookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String actionName = request.getParameter("a");
		
		guestbookDao dao = new guestbookDao();
		guestbookVo vo  = new guestbookVo();
		
		if("deleteform".equals(actionName)) {
			String no = request.getParameter("no");

			request.setAttribute("delete_test", no);
			request.getRequestDispatcher("/WEB-INF/views/deleteform.jsp").forward(request, response);
		}else if("delete".equals(actionName)) {
			String password = request.getParameter("password");
			int no = Integer.parseInt(request.getParameter("no"));
			
			dao.delete(no, password);
			
			response.sendRedirect("/guestbook02/gb");
		}
		else if("add".equals(actionName)) {
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String message = request.getParameter("message");
			
			vo.setName(name);
			vo.setPassword(password);
			vo.setMessage(message);
			
			dao.insert(vo);
			
			response.sendRedirect("/guestbook02/gb");
			
		}
		else {
			request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);

		}
		//여기서 actionName을 받으면 그 actionName을 어떻게 사용해야 할 까?
		
//		response.getWriter().println("<h1>Guestbook02!!!<h1>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
