<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@page import= "SQL.*"%>      
     
  <%
 String tod=SQL.tod_date();
  SQL.get_htage();
%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" ></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<meta name="viewport" content="width=device-width,initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

<meta charset="UTF-8">
<title>Update</title>
<style>
.container
{
	position: relative;
	text-align: left;

	padding: 20px;
	margin: 20px;
}
body {
background-image: url('./img/beach.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed;  
  background-size: cover;
  
}
</style>


</head>

<body>


<div class=container>
<h1> Update please :) </h1>


<form action="update" method="post">


Please use the below app- calorie counter to find the calories spent and update it below:
<br> <br>

Morning meal calories <input type="text" name="morning"> <br>
Afternoon lunch calories<input type="text" name="lunch"> <br>
Dinner calories <input type="text" name="dinner"> <br>

<iframe src="https://www.nutracheck.co.uk/CaloriesIn/" style="width: 400px; height: 200px;"></iframe>

<p>How would you describe your activity today</p>
  <input type="radio" id="todayactivities" name="todayactivities" value="sedentary">
  <label for="sedentary">Sedentary/Lightly Active</label><br>

  <input type="radio" id="todayactivities" name="todayactivities" value="active">
  <label for="active">Active/ Moderately active</label><br>

  <input type="radio" id="todayactivities" name="todayactivities" value="vigorous">
  <label for="vigorous">Vigorous/ Vigorously active</label><br>

How long did you workout/walk today? (minutes) <input type="text" name="minutes"> <br>
Your current weight <input type="text" name="currentweight" > <br>
        
Your height <input type="text" name="height"  value="<%=SQL.ht %>" readonly >  <br>

Your age <input type="text" name="age" value="<%=SQL.ag %>"  > <br>
<input type="submit">



</form>

<br>

<a class="btn btn-light" href="home.jsp">Go back to Home</a>
</div>
</body>

</html>