<%@page import="com.tryme.DaoClass"%>
<%@page import="com.tryme.LoginDao"%>
<%@page import="com.tryme.*"%>
<%@page import="com.tryme.GetLoginId"%>
<%@page import="java.util.*"%>

 


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>




   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>dummy login success </title>
</head>
<body>
 <div align="center">
 
 
  <h1>LOGIN success / DASHBOARD</h1>
  
  <% 
  if(session.getAttribute("username")==null)
  {
	  response.sendRedirect("login.jsp");
  }
  %>
  ok Welcome <h5>${username} </h5>
  <a href="plan.jsp?name=${username}"> Check your Plan </a>
  
  <form action ="logout">
  <input type="submit" value="logout">
  </form>
 </div>
</body>
</html>