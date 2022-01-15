<%@page import="com.poscoict.guestbook.vo.guestbookVo"%>
<%@page import="java.util.List"%>
<%@page import="com.poscoict.guestbook.dao.guestbookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	guestbookDao dao = new guestbookDao();  //EmaillistDao객체 dao로 생성
	List<guestbookVo> list = new guestbookDao().findAll();
	//빨간 줄 뜨는 import 부분에서 ctrl space 키를 누르면 내가 import 해야 될 것이 나온다.
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
	<form action="<%= request.getContextPath() %>/add.jsp" method="post">
	<table border=1 width=500>
		<tr>
			<td>이름</td><td><input type="text" name="name"></td>
			<td>비밀번호</td><td><input type="password" name="password"></td>
		</tr>
		<tr>
			<td colspan=4><textarea name="message" cols=60 rows=5></textarea></td>
		</tr>
		<tr>
			<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
		</tr>
	</table>
	</form>
	<br>
	<%
		int count=list.size();
		int index = 0;
		for(guestbookVo vo : list){
			
		
	%>
	<table width=510 border=1>
		<tr>
			<td>[<%= count-index++ %>]</td>
			<td><%= vo.getName() %></td>
			<td><%= vo.getReg_date() %></td>
			<td><a href="<%= request.getContextPath() %>/deleteform.jsp?no=<%=vo.getNo() %>">삭제</a></td>
		</tr>
		<tr>
			<td colspan=4><%= vo.getMessage().replaceAll("\n","<br/>") %> </td>
			<br>
		</tr>
	</table>
	<%
		}
	%>
</body>
</html>