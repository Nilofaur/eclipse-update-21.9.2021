<%@page import="com.tryme.DaoClass"%>
<%@page import="com.tryme.LoginDao"%>
<%@page import="com.tryme.*"%>
<%@page import="com.tryme.GetLoginId"%>
<%@page import="java.util.*"%>

 


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>


  <% 
  if(session.getAttribute("username")==null)
  {
	  response.sendRedirect("login.jsp");
  }
  %>

<% 
DaoClass ld = new DaoClass(Dbcon.getConnection());
List<GetLoginId> details = ld.getsqlName("name");
%>  

<%@  taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>



   
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
<title> login success </title>
</head>
<body>
 <div align="center">
 
 <%
             out.println("PRINT: "+details);

			if (!details.isEmpty()) {
				for (GetLoginId p : details) {
			%>
			
			
			<a href="plan.jsp?name=<%=p.getName()%>"><button>Link Text</button></a>
			<%
			}
			} else {


			out.println(":(");
			}
			%>
  <h1>LOGIN success / DASHBOARD</h1>
  
  <% 
  if(session.getAttribute("username")==null)
  {
	  response.sendRedirect("login.jsp");
  }
  %>
  ok Welcome <h5>${username} </h5>
  <a href="plan.jsp?name=${username}"> Check your Plan </a>
  <a href="aboutme.jsp?name=${username}"> About You  </a>
  <form action ="logout">
  <input type="submit" value="logout">
  </form>
 </div>
</body>
</html>