<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="coreTag" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.topnav {
  overflow: hidden;
  background-color: #333;
}

.topnav a {
  float: right;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
}

.topnav a.active {
  background-color: blue;
  color: white;
}
.topnav a.profilePage {
  background-color: green;
  color: white;
}
</style>
</head>
<!-- <body style="background-image: url(../myImages/bgimage1.jpg); background-color: #1abc9c" > -->
<body style="background-color: #1abc9c" >
<%response.setHeader("cache-control", "no-cache, no-store, must-revalidate");
response.setHeader("pragma", "no-cache");
response.setDateHeader("Expires", 0);
if(session.getAttribute("loggedIn")==null){
	%>
	<coreTag:redirect url="http://localhost:7070/"></coreTag:redirect>
	<%
}

%>
<div class="topnav">
  <a class="active" href="logout">Logout</a>
  <a class="profilePage" href="redirectToProfilePageAdmin">Profile Page</a>
</div>


<h1 style="color: white;">All Users</h1>

<table border="1" style="width: 100%; background-color: #16a085; color: white" >
<tr><th>Email ID</th><th>User Name</th><th>User Type</th></tr>
<coreTag:forEach items="${userListS2 }" var="us">

<tr>
<td><coreTag:out value="${us.email }"></coreTag:out></td>
<td><coreTag:out value="${us.user }"></coreTag:out></td>
<td><coreTag:if test="${us.userType=='P' }"><a href="<coreTag:url value="approveAdmin"><coreTag:param name="aEmail" value="${us.email }"></coreTag:param></coreTag:url>" style="color: yellow;">Approve Admin Access</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="<coreTag:url value="rejectAdmin"><coreTag:param name="rEmail" value="${us.email }"></coreTag:param></coreTag:url>" style="color: orange;">Reject Admin Access</a></coreTag:if>
<coreTag:if test="${us.userType=='A' }">Admin&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="<coreTag:url value="deactivateAccount"><coreTag:param name="dEmail" value="${us.email }"></coreTag:param></coreTag:url>" style="color: red;">Deactivate Account</a> </coreTag:if>
<coreTag:if test="${us.userType=='G' }">General&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="<coreTag:url value="deactivateAccount"><coreTag:param name="dEmail" value="${us.email }"></coreTag:param></coreTag:url>" style="color: red;">Deactivate Account</a> </coreTag:if>
<coreTag:if test="${us.userType=='R' }">Admin Access Rejected&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="<coreTag:url value="activateAdminAccount"><coreTag:param name="aEmail" value="${us.email }"></coreTag:param></coreTag:url>" style="color: red;">Activate as Admin Account</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="<coreTag:url value="activateGeneralAccount"><coreTag:param name="aEmail" value="${us.email }"></coreTag:param></coreTag:url>" style="color: red;">Activate as General Account</a></coreTag:if>
<coreTag:if test="${us.userType=='D' }">Account Deactivated&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="<coreTag:url value="activateAdminAccount"><coreTag:param name="aEmail" value="${us.email }"></coreTag:param></coreTag:url>" style="color: red;">Activate as Admin Account</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="<coreTag:url value="activateGeneralAccount"><coreTag:param name="aEmail" value="${us.email }"></coreTag:param></coreTag:url>" style="color: red;">Activate as General Account</a></coreTag:if>
</td>
</tr>

</coreTag:forEach>
</table>

<br>
</body>
</html>