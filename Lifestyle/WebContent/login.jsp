<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login.jsp</title>
</head>
<style>
body {
background-image: url('./img/lemon.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed;  
  background-size: cover;
  
}
</style>
<body>

<%

//SESSION
HttpSession sess = request.getSession(false); //use false to use the existing session
Object n=sess.getAttribute("n");//this will return username anytime in the session
Object success=sess.getAttribute("success");//this will return password Any time in the session

%>

  <% 
  if(success!=null)
  {
	  out.println("Welcome"+" "+n);
  }
  %>

	<div align="center">
		<h1>Login Form</h1>
		<form action="<%=request.getContextPath()%>/login" method="post">
			<table style="with: 100%">
				<tr>
					<td><h2>UserName</h2></td>
					<td><input type="text" name="username" /></td>
				</tr>
				<tr>
					<td><h2>Password</h2></td>
					<td><input type="password" name="password" /></td>
				</tr>

			</table>
			<input type="submit" value="Submit" />
			 <a href="#">I forgot my password</a>
		</form>
	</div>
	
</body>
</html>