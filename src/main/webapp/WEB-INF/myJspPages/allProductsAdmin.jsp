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
.topnav a.addProduct {
  background-color: green;
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
  <a class="addProduct" href="addProductForm">Add Product</a>
  <a class="profilePage" href="redirectToProfilePageAdmin">Profile Page</a>
</div>


<h1 style="color: white;">All Products</h1>

<table border="1" style="width: 100%; background-color: #16a085; color: white" >
<tr style="color: yellow;"><th>Image</th><th>Product Name</th><th>Product Description</th><th>Price</th><th>Quantity</th>
<th>Delete</th></tr>
<coreTag:forEach items="${products }" var="pro">

<tr>
<td><img alt="" src="<coreTag:url value="${pro.imageUrl }"></coreTag:url>" width="50" height="50"></td>
<td><coreTag:out value="${pro.productName }"></coreTag:out></td>
<td><coreTag:out value="${pro.productDescription }"></coreTag:out></td>
<td><coreTag:out value="${pro.price }"></coreTag:out></td>
<td><coreTag:out value="${pro.quantity }"></coreTag:out></td>
<td><a href="<coreTag:url value="deleteProduct"><coreTag:param name="productName" value="${pro.productName}"></coreTag:param></coreTag:url>" style="color: red;">Delete Product</a></td>
</tr>

</coreTag:forEach>
</table>

<br>
</body>
</html>