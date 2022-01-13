package com.poscoict.emaillist.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poscoict.emaillist.dao.EmaillistDao;
import com.poscoict.emaillist.vo.EmaillistVo;


public class EmailllistController extends HttpServlet {
	private static final long serialVersionUID = 1L;

 
  


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 	request.setCharacterEncoding("utf-8"); //바디부분을 인코딩 필요

		String actionName = request.getParameter("a");
		
		if("form".equals(actionName)) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/form.jsp"); //
			//여기서 부터는 jsp에서 제어권이 넘어감
			rd.forward(request, response);
		}else if("add".equals(actionName)) {


			String firstName = request.getParameter("fn"); 
			String lastName = request.getParameter("ln"); 
		 	String email = request.getParameter("email"); 

			EmaillistVo vo = new EmaillistVo();
			vo.setFirstName(firstName);
			vo.setLastName(lastName);
			vo.setEmail(email);
			
			new EmaillistDao().insert(vo);
			
			
			response.sendRedirect(request.getContextPath() + "/el");
		}else {
			EmaillistDao dao = new EmaillistDao();  //EmaillistDao객체 dao로 생성
			List<EmaillistVo> list = new EmaillistDao().findAll();
			
			request.setAttribute("list", list);
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/index.jsp"); //
			//여기서 부터는 jsp에서 제어권이 넘어감
			rd.forward(request, response);
			
		}
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}