<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="admin_add_user">
		<table border="4">
			<tr>
				<th>Add User</th>
			</tr>
			
			<tr>
				<td>Enter Password</td>
				<td><input type="password" name="password" maxlength="20"></td>
			</tr>
			
			<tr>
				<td>Confirm Password</td>
				<td><input type="password" name="cnf_password" maxlength="20"></td>
			</tr>
			
			<tr>
				<td>Role</td>
				<td>
					<input type="radio" name="role" value="RM">Resource Manager
					<input type="radio" name="role" value="RME">RMG Executive
					<input type="radio" name="role" value="Admin">Admin 
				</td>
			</tr>
			
			<tr>
				<td></td>
				<td><input type="submit" value="Add User"></td>
			</tr>
		</table>
	</form>
</body>
</html>