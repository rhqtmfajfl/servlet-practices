
<%@page import="com.poscoict.guestbook.dao.guestbookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	String password = request.getParameter("password");
	Long no = Long.parseLong(request.getParameter("no"));
	
	new guestbookDao().delete(no,password);
	
	response.sendRedirect("/guestbook01/index.jsp");

%>
