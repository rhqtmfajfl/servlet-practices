<%@page import="com.poscoict.guestbook.dao.guestbookDao"%>
<%@page import="com.poscoict.guestbook.vo.guestbookVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("utf-8");

	String name = request.getParameter("name");
	String password = request.getParameter("password");
	String message = request.getParameter("message");
	
	guestbookVo vo = new guestbookVo();
	vo.setName(name);
	vo.setPassword(password);
	vo.setMessage(message);
	
	new guestbookDao().insert(vo);
	
	response.sendRedirect("/guestbook01/index.jsp");
%>
