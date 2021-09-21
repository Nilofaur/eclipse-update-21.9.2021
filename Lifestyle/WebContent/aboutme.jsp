
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<h1>ABOUT YOU :)</h1>




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
Goal Weight <input type="text" name="goal "> <br>

Ethnicity <input type="text" name="ethnicity"> <br>

  <p>How would you describe your normal activities</p>
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
Please use the below app- calorie counter to find the calories spent and update it below:
<br> <br>

Morning meal calories <input type="text" name="morning"> <br>
Afternoon lunch calories<input type="text" name="lunch"> <br>
Dinner calories <input type="text" name="dinner"> <br>





 <input type="submit">
 
 

</form>
<iframe src="https://www.nutracheck.co.uk/CaloriesIn/" style="width: 400px; height: 200px;"></iframe>


</body>
</html>