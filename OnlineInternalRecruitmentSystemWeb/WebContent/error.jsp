<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h5>Error occured</h5>

<c:if test="${exception!=null}">
<c:out value="${exception.getMessage() }"></c:out>
</c:if>

<c:if test="${sessionScope.errorMsg!=null}">
<c:out value="${sessionScope.errorMsg }"></c:out>
</c:if>

</body>
</html>