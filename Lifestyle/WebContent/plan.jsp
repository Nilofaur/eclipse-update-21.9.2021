<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    <%@ include file="links.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
<style>
.test1 {
  background-image: url("santorini.jpg");
}
</style>

<style>

.test {
  background-image: url("diet.jpg");
  background-repeat: no-repeat;
  background-position: right top;
}
</style>
</head>
<body>

  <% 
  if(session.getAttribute("username")==null)
  {
	  response.sendRedirect("login.jsp");
  }
  %>

<div class="test">
  <h2>Paris</h2>
  <p>Paris is the capital of France.</p>
</div>






<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>


<!-- Background image -->
<div
  class="bg-image d-flex justify-content-center align-items-center"
  style="
    background-image: url('https://mdbootstrap.com/img/new/slides/033.jpg');
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
      <h1 class="text-white">Plan A</h1> <div class="text-white p-3">PLAN A</div>
    </div>
    <div class="col">
    <h1 class="text-white">Plan B</h1>  <div class="text-white p-3">PLAN B</div>
     
    </div>
  </div>
</div>
  
  
  
	 

</div>

<div class="float-sm-start">Float start on viewports sized SM (small) or wider
<img src="santorini.jpg" class="img-thumbnail" >



</div><br>




<br>




</body>
</html>