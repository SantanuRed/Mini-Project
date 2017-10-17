<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%HttpSession sess = request.getSession(false);  %>
	<h3>Welcome <%=sess.getAttribute("user_id") %></h3>
	<a href="admin_add_user.jsp">Add User</a><br>
	<a href="admin_remove?user_id=<%=sess.getAttribute("user_id")%>">Remove User</a>
</body>
</html>