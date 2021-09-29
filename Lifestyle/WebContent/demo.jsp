<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="com.tryme.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>demo</title>
</head>
<body>

<body> 
   <form action="demo" method="post">
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

How long did you do today? <input type="text" name="minutes"> <br>

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
</body> 
<p> hi ${everyday_calorie}
${consumed_calorie}
${activities_calorie}</p>

</body>
</html>