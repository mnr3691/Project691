<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="sprForm" uri="http://www.springframework.org/tags/form" %> 

<!DOCTYPE html>
<!-- Created By CodingLab - www.codinglabweb.com -->
<html lang="en" dir="ltr">
  <head>
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
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- <title>Login Form | CodingLab</title> -->
    <link rel="stylesheet" href="cssFolder/addProduct.css">
	<!-- <script src="jsFolder/loginRegisterJsS2.js"></script> -->
<link rel="icon" type="image/x-icon" href="myImages/wljS2.png">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"/>
  </head>
  <body>
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
  
    <div class="container">
      <div class="wrapper">
        <div class="title"><span>Add Product</span></div>
        <sprForm:form modelAttribute="pro" action="/addProduct">
          <div class="row">
            <i class="fa fa-window-maximize"></i>
            <sprForm:input path="productName" type="text" required="true" placeholder="Enter Product Name"/>
          </div>
          <div class="row">
            <i class="fa fa-window-restore"></i>
            <sprForm:input path="productDescription" type="text" required="true" placeholder="Enter Product Description"/>
          </div>
          <div class="row">
            <i class="fa fa-image"></i>
            <sprForm:input path="imageUrl" type="text" required="true" placeholder="Enter Image Url"/>
          </div>
          <div class="row">
          <i class="fas fa-dollar-sign"></i>
            <sprForm:input path="price" type="number" step="any" required="true" placeholder="Enter Price"/>
          </div>
          <div class="row">
          <i class="fas fa-object-ungroup"></i>
            <sprForm:input path="quantity" type="number" required="true" placeholder="Enter Quantity"/>
          </div>
          <div class="row button">
            <input type="submit" value="Add Product">
          </div>
        </sprForm:form>
      </div>
      </div>

  </body>
</html>
