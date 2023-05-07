<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="sprForm" uri="http://www.springframework.org/tags/form" %> 

<!DOCTYPE html>
<!-- Created By CodingLab - www.codinglabweb.com -->
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- <title>Login Form | CodingLab</title> -->
    <link rel="stylesheet" href="cssFolder/loginRegisterCss.css">
	<script src="jsFolder/loginRegisterJs.js"></script>
<link rel="icon" type="image/x-icon" href="myImages/wlj.png">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"/>
  </head>
  <body>
    <div class="container" id="reg">
      <div class="wrapper">
        <div class="title"><span>Register Form</span></div>
        <sprForm:form modelAttribute="us" action="/register">
          <%-- <div class="row">
            <i class="fas fa-user"></i>
            <sprForm:input path="userId" type="number" required="true" placeholder="Enter User ID"/>
          </div> --%>
          <div class="row">
            <i class="fas fa-user"></i>
            <sprForm:input path="user" type="text" required="true" placeholder="Enter User Name"/>
          </div>
          <div class="row">
            <i class="fas fa-lock"></i>
            <sprForm:input path="password" type="password" required="true" placeholder="Enter Password"/>
          </div>
          <!-- <div class="pass"><a href="#">Forgot password?</a></div> -->
          <div class="row button">
            <input type="submit" value="Register">
          </div>
          <div class="signup-link">Not a member? <a href="javascript:logi()">Signin now</a></div>
        </sprForm:form>
      </div>
      </div>
      <div class="container" id="log">
      <div class="wrapper">
        <div class="title"><span>Login Form</span></div>
        <sprForm:form modelAttribute="us" action="/login">
          <div class="row">
            <i class="fas fa-user"></i>
            <sprForm:input path="userId" type="number" required="true" placeholder="Enter User ID" value=""/>
          </div>
          <div class="row">
            <i class="fas fa-lock"></i>
            <sprForm:input path="password" type="password" required="true" placeholder="Enter Password"/>
          </div>
          <div class="pass"><a href="#">Forgot password?</a></div>
          <div class="row button">
            <input type="submit" value="Login">
          </div>
          <div class="signup-link" >Not a member? <a href="javascript:registe()">Signup now</a></div>
        </sprForm:form>
      </div>
      
    </div>

  </body>
</html>
