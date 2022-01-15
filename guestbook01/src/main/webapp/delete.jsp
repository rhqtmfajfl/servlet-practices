<%@page import="com.poscoict.guestbook.dao.guestbookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String password = request.getParameter("password");
	//여기서 no를 강제 형변환 시킨다.
	int no = Integer.parseInt(request.getParameter("no"));

	
	new guestbookDao().delete(no, password);
	
	response.sendRedirect("/guestbook01.index.jsp");
	

%>
