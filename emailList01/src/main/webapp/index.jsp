<%@page import="com.poscoict.emaillist.vo.EmaillistVo"%>
<%@page import="com.poscoict.emaillist.dao.EmaillistDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
EmaillistDao dao = new EmaillistDao();  //EmaillistDao객체 dao로 생성
	List<EmaillistVo> list = new EmaillistDao().findAll();
	//빨간 줄 뜨는 import 부분에서 ctrl space 키를 누르면 내가 import 해야 될 것이 나온다.
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>메일 리스트에 가입되었습니다.</h1>
	<p>입력한 정보 내역입니다.</p>
	<!-- 메일정보 리스트 -->
	<%
	//list 개수 만큼 반복 된다.
		//데이터는 vo에 들어있는데 데이터를 찍어 낼때는 
			for(EmaillistVo vo : list) { //안에 들어있는 list 개수 만큼 반복 //EmaillistVo 객체에 들어있는 firstname과
		//lastName 그리고 // email 혀식으로 vo 가 타입이 된다.
	%>
		<table border="1" cellpadding="5" cellspacing="2">
			<tr>
				<td align=right>First name: </td>
				<td><%= vo.getFirstName() %></td>
			</tr>
			<tr>
				<td align=right width="110">Last name: </td>
				<td width=100><%= vo.getLastName() %></td>
							</tr>
			<tr>
				<td align=right>Email address: </td>
				<td><%= vo.getEmail() %></td>
			</tr>
		</table>
		<br>
	<%
		}
	%>
	<p>
		<a href="/emaillist01/form.jsp">추가메일 등록</a>
	</p>
	<br>
</body>
</html>