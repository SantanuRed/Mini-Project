<%@page import="com.cg.oirs.dto.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Remove user</h1>
	<%
		HttpSession sess = request.getSession(false);
		List<User> ulist = (List<User>)sess.getAttribute("ulist");
		for(User u:ulist){
	%>
		<table border="4">
			<tr>
				<td><%=u.getUser_id() %></td>
				<td><%=u.getRole() %></td>
				<td><a href="delete_user?user_id=<%=u.getUser_id()%>">Delete User</a></td>
			</tr>
		</table>
	<%} %>
</body>
</html>