
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

<h1>ABOUT YOU :)</h1>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" ></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>



<style>
body {
background-image: url('./img/pencil.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed;  
  background-size: cover;
  
}
</style>
<meta charset="UTF-8">

<title>aboutme</title>
</head>
<body>

  <% 
  if(session.getAttribute("username")==null)
  {
	  response.sendRedirect("login.jsp");
  }
  %>



<form action="aboutme" method="post">
Current weight in kgs <input type="text" name="weight"> <br>
Height in cms <input type="text" name="height"> <br>
age <input type="text" name="age"> <br>
Goal Weight <input type="text" name="goal"> <br>

Ethnicity <input type="text" name="ethnicity"> <br>

 <p>How would you describe your activity today</p>
  <input type="radio" id="activities" name="activities" value="sedentary">
  <label for="sedentary">Sedentary/Lightly Active</label><br>

  <input type="radio" id="activities" name="activities" value="active">
  <label for="active">Active/ Moderately active</label><br>

  <input type="radio" id="activities" name="activities" value="vigorous">
  <label for="vigorous">Vigorous/ Vigorously active</label><br>
 


<p> Preferred Cuisine :</p>
 
<input type="radio" id="cuisine" name="cuisine" value="asian">
  <label for="asian">Asian</label><br>
  <input type="radio" id="cuisine" name="cuisine" value="english">
  <label for="english">English</label><br>
  <input type="radio" id="cuisine" name="cuisine" value="mixed">
  <label for="mixed">Mixed</label>

<br> <br>







 <input type="submit">
   

</form>


</body>
</html>