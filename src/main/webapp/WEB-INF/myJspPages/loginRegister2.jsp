<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="sprForm" uri="http://www.springframework.org/tags/form" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register/Login</title>

<link rel="stylesheet" href="cssFolder/loginRegisterCss.css">
<script src="jsFolder/loginRegisterJs.js"></script>

<link rel="icon" type="image/x-icon" href="myImages/wlj.png">


</head>
<body>
<p>Register/Login</p>


<button onclick="registe()">Register</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button onclick="logi()">Login</button>

<div id="reg">
<table border="1" style="width: 100%">
<sprForm:form modelAttribute="us" action="/register">
<tr><td>User Id </td><td><sprForm:input path="userId" type="number" required="true" placeholder="Enter User ID"/></td></tr>
<tr><td>User </td><td><sprForm:input path="user" type="text" required="true" placeholder="Enter User"/></td></tr>
<tr><td>Password </td><td><sprForm:input path="password" type="password" required="true" placeholder="Enter Password"/></td></tr>
<tr><td><input type="submit" value="Register">
</sprForm:form>
</table>
</div>

<div id="log">
<table border="1" style="width: 100%">
<sprForm:form modelAttribute="us" action="/login">
<tr><td>User Id </td><td><sprForm:input path="userId" type="number" required="true" placeholder="Enter User ID"/></td></tr>
<tr><td>User </td><td><sprForm:input path="user" type="text" required="true" placeholder="Enter User"/></td></tr>
<tr><td>Password </td><td><sprForm:input path="password" type="password" required="true" placeholder="Enter Password"/></td></tr>
<tr><td><input type="submit" value="Login">
</sprForm:form>
</table>
</div>
<br><br>
<a href="allUsers">Get All Users</a>




</body>
</html>