<%@page import="com.tryme.DaoClass"%>
<%@page import="com.tryme.LoginDao"%>
<%@page import="com.tryme.*"%>
<%@page import="com.tryme.GetLoginId"%>
<%@page import="java.util.*"%>
<%@page import= "java.util.Date"%>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<% 
  if(session.getAttribute("username")==null)
  {
	  response.sendRedirect("login.jsp");
  }
  %>


<%
String tod="";
//Instantiate a Date object
Date date = new Date();
tod=date.toString();
%>

<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<style>
body {
	background-image: url('./img/cat.jpg');
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
}
</style>
<meta charset="ISO-8859-1">
<title>login success</title>
</head>
<body>
	<div align="center">

		<h3>You have Logged in Successfully</h3>

	<!-- 	<a href="plan.jsp?name=${username}"><button>Please click
					here to go to your Plan</button> 
			<br></a> -->
			
			<h4>todays date : <%=tod%> </h4>
			
			
			<br> <br> <a href="aboutme.jsp?name=${username}">If
			you have not filled the about me form please click me </a> 
		
		<br> <br> <a href="manualupdate.jsp?name=${username}"> Update your meal and physical activity here 
			 </a>

	<form action="plan.jsp?name${username}&days=">
		<label for="days"> Today:</label> <select name="days" id="days">
			<option value="mon">Mon</option>
			<option value="tue">tue</option>
			<option value="wed">Wed</option>
			<option value="thu">Thu</option>
			<option value="fri">Fri</option>
			<option value="sat">Sat</option>
			<option value="sun">Sun</option>
		</select> <input type="submit" value="View your plan for today :)">
	</form>
 <form action="logout">
			<br> <input type="submit" value="logout">
		</form>
</div>
</body>
</html>