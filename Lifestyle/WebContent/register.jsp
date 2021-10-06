<html>  
<head>

<meta name="viewport" content="width=device-width,initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	
<h1>Registration</h1>
<title>Register</title>
<style>
body {
background-image: url('./img/surf.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed;  
  background-size: cover;
  
}
</style>
</head>
<body> 



<ul class="nav nav-pills">

  <li class="nav-item">
    <a class="nav-link"  href="login.jsp"><h4>Already registered?</h4></a>
  </li>


</ul>



<form action="servlet/Register" method="post">  
  
<h2>Name:</h2><input type="text" name="userName"/><br/><br/>  
<h2>Password:</h2><input type="password" name="userPass"/><br/><br/>  
<h2>Email Id:</h2><input type="text" name="userEmail"/><br/><br/>  

  
<br/><br/>  
<input type="submit" value="register"/>  
  
</form>  
</body>  
</html>  