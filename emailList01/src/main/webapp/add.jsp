<%@page import="com.poscoict.emaillist.dao.EmaillistDao"%>
<%@page import="com.poscoict.emaillist.vo.EmaillistVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//= 이걸 사용하기 위해서 <% 사용 
	// 여기 부분들은 나중에 서블릿으로 들어가게 된다. (servlet의 코드)  request response 들이 들어있다.
	
	//값을 뽑을때  get 파라미터 사용  get 함수 안에는 name의 값
 	request.setCharacterEncoding("utf-8"); //바디부분을 인코딩 필요


	String firstName = request.getParameter("fn"); 
	String lastName = request.getParameter("ln"); 
 	String email = request.getParameter("email"); 

	EmaillistVo vo = new EmaillistVo();
	vo.setFirstName(firstName);
	vo.setLastName(lastName);
	vo.setEmail(email);
	
	new EmaillistDao().insert(vo);
	
	
	response.sendRedirect("/emaillist01");
%>
