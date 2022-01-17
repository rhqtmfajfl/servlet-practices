<%@page import="com.poscoict.guestbook.dao.guestbookDao"%>
<%@page import="com.poscoict.guestbook.vo.guestbookVo"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
List<guestbookVo> list = (List<guestbookVo>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
	<form action="<%=request.getContextPath() %>/gb?a=add" method="post">
		<table border=1 width=500>
			<tr>
				<td>이름</td><td><input type="text" name="name"></td>
				<td>비밀번호</td><td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td colspan=4><textarea name="message" cols=60 rows=5></textarea></td>
			</tr>
			<tr>
				<td colspan=4 align=right><input type="submit" VALUE="등록"></td>
			</tr>
		</table>
	</form>
	
	<%
		int count = list.size();
		int index = 0;
		for(guestbookVo vo : list){
	%>
		<br>
		<table width=510 border=1>
			<tr>
				<td>[<%=count-index++ %>]</td>
				<td><%=vo.getName() %></td>
				<td><%=vo.getDate() %></td>
				<td><a href="<%=request.getContextPath() %>/gb?a=deleteform&no=<%=vo.getNo() %>">삭제</a></td>
			</tr>
			<tr>
				<td colspan=4><%=vo.getMessage().replaceAll("\n", "<br/>") %></td>
			<br>
			</tr>
		</table>
	<%
		}
	%>
</body>
</html>