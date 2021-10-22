<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>dashboard</title>
</head>
<body>



<div class="test">
  <h2>Dashboard ( VIEW )</h2>
  <p>
Usually your everyday_maxcalorie is (from plan.jsp) ${everyday_maxcalorie}
  <br>
  But today with the activity you did your max calorie for today should not exceed ${everyday_maxcalorie1} .
  <br>
  consumed calorie is  ${consumed_calories}
  <br>
  burnt_byworkout is ${burnt_byworkout}
  <br>
  eod you spent  ${eod_spent}
  <br>
  totalbalance left is (final)   ${totalbalanceleft}
  <br>
met1 is (final)   ${met1}
	  
 </p>

</div>






<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>


<!-- Background image -->
<div
  class="bg-image d-flex justify-content-center align-items-center"
  style="
    background-image: url('https://mdbootstrap.com/img/new/slides/001.jpg');
    height: 100vh;
  "
>
 <!-- Background image -->
   
  <div class="container px-4">
  <div class="row gx-5">
    <div class="col">
    
<div class="test1">
<p>This paragraph has an image as the background!</p>

   </div> 
      <h1 class="text-white">dashboard A</h1> <div class="text-white p-3">dashboard A</div>
    </div>
    
     
     
		
    <div class="col">
    <h1 class="text-white">dashboard B</h1>  <div class="text-white p-3">dashboard B</div>
     
    </div>
     
  </div>
</div>
  
  
  
	 

</div>

<div class="float-sm-start">Float start on viewports sized SM (small) or wider
<img src="santorini.jpg" class="img-thumbnail" >



</div><br>




<br>


<a class="btn btn-light" href="home.jsp">Go back to Home</a>

</body>
</html>