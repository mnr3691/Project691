<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Hello <%=session.getAttribute("userS2Name")%>.Logged-in Successfully. Welcome to Project 689 Admin</h1>

<a href="allUsersForAdminS2">List All Users</a>
</body>
</html>