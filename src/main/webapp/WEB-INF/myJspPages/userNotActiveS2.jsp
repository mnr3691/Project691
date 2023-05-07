<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="coreTag" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Profile is currently <% if(session.getAttribute("userType").equals("R")){
	out.print(" Admin Access Rejected");
}
else if(session.getAttribute("userType").equals("D")){
	out.print(" Deactivated");
}
else if(session.getAttribute("userType").equals("P")){
	out.print(" Pending under Admin Approval ");	
}
else{
	out.print(" Not Active");
}
%>. Please contact admin +(331) 425-12345</h1>
<a href="http://localhost:7070/">Click here for Register or Login</a>
</body>
</html>