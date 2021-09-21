<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@page import="na.ecomm.model.*"%>  

<!DOCTYPE html>
<html>

<head>
<title>dunmmy</title>

<%@include file="/includes/head.jsp"%>
</head>
<body>

<%@include file="/includes/navbar.jsp"%>
<h1> dummy login</h1>
<div class="container">
		<div class="card w-50 mx-auto my-5">
			<div class="card-header text-center">User Login</div>
			<div class="card-body">
				<form action="dummy-login" method="post">
					<div class="form-group">
						<label>User name</label> 
						<input type="email" name="login-email" class="form-control" placeholder="Enter user name">
					</div>
					<p><h1>dummy</h1></p>
					<div class="form-group">
						<label>Password</label> 
						<input type="password" name="login-password" class="form-control" placeholder="Password">
					</div>
					<div class="text-center">
						<button type="submit" class="btn btn-primary">Login</button>
					</div>
				</form>
			</div>
		</div>
	</div>

<%@include file="/includes/footer.jsp"%>
</body>
</html>