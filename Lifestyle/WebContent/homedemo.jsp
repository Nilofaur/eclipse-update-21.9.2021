<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@ include file="links.jsp"%>

<!DOCTYPE html>
<html>
<head>


<meta charset="UTF-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta http-equiv="x-ua-compatible" content="ie=edge" />
<title>Lifestyle Home page</title>
<!-- MDB icon -->
<link rel="icon" href="img/mdb-favicon.ico" type="image/x-icon" />
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.2/css/all.css" />
<!-- Google Fonts Roboto -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" />
<!-- MDB -->
<link rel="stylesheet" href="css/mdb.min.css" />

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
	crossorigin="anonymous"></script>

<meta charset="UTF-8">
<title>Insert title here</title>

<style>
img {
	opacity: 0.2;
}
</style>
<style>
.box {
	background-color: white;
	width: 90%;
	border: 5px solid #FFFFCC;
	padding: 20px;
	margin: 50px;
}

.container {
	position: relative;
	text-align: center;
	color: black;
}

.bottom-left {
	position: absolute;
	bottom: 8px;
	left: 16px;
}

.top-left {
	position: absolute;
	top: 8px;
	left: 16px;
}

.top-right {
	position: absolute;
	top: 8px;
	right: 16px;
}

.bottom-right {
	position: absolute;
	bottom: 8px;
	right: 16px;
}

.centered {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
}
</style>
</head>

<body>

	<ul class="nav justify-content-end">
		<li class="nav-item"><a class="nav-link" href="register.jsp">Register</a>
		</li>
		<li class="nav-item"><a class="nav-link" href="login.jsp">Login</a>
		</li>
		<li class="nav-item"><a class="nav-link" href="login.jsp">Logout</a>
		</li>
		<li class="nav-item"><a class="nav-link"
			href="http://localhost:9091/">Payment</a></li>
	</ul>

	<div class="test">
		<h2>HOMEPAGE</h2>
		<p>Welcome to Lifestyle App</p>
	</div>

<div class="box">
			<p>
			<h1>INTRO</h1>
			<br>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
			Suspendisse interdum mi a dolor malesuada ultricies. Nullam venenatis
			ipsum nec leo accumsan, vitae blandit ex tempor. Aenean eleifend dui
			vitae enim vehicula, eget elementum dolor facilisis. Nulla gravida a
			augue sed ullamcorper. Maecenas at purus consectetur, viverra nisl
			condimentum, facilisis nisl
			</p>
		</div>



		<div class="box">
			<p>
			<h1>ABOUT</h1>
			<br>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
			Suspendisse interdum mi a dolor malesuada ultricies. Nullam venenatis
			ipsum nec leo accumsan, vitae blandit ex tempor. Aenean eleifend dui
			vitae enim vehicula, eget elementum dolor facilisis. Nulla gravida a
			augue sed ullamcorper. Maecenas at purus consectetur, viverra nisl
			condimentum, facilisis nisl
			</p>
		</div>


		<div class="box">
			<p>
			<h3>PRODUCTS</h3>
			<br>
			<iframe src="/shopping-cart/index.jsp"
				style="width: 90%; height: 70%;"></iframe>

		</div>




	<div class="container">
		<img src="./img/banana.jpg" alt="banana" width="100%" height="100%">

	</div>

</body>
</html>