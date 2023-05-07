<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="coreTag" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<!-- <body style="background-image: url(../myImages/bgimage1.jpg); background-color: #1abc9c" > -->
<body style="background-color: #1abc9c" >
<h1 style="color: white;">All Users</h1>

<table border="1" style="width: 100%; background-color: #16a085; color: white" >
<tr><th>User ID</th><th>User Name</th></tr>
<coreTag:forEach items="${userList }" var="us">

<tr>
<td><coreTag:out value="${us.userId }"></coreTag:out></td>
<td><coreTag:out value="${us.user }"></coreTag:out></td>
</tr>

</coreTag:forEach>
</table>

<br>
</body>
</html>