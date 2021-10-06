<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.tryme.*"%>
<%
//String id = request.getParameter("userid");
String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String database = "userdb";
String db = "root";
String password = "secret";

String name="";
String name1="";
int userid=0;
double weight =0;
String cuisine = "";
	

try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>



    
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
  
  


<%

//SESSION
HttpSession sess1 = request.getSession(false); //use false to use the existing session
sess1.getAttribute("everyday_maxcalorie");//this will return username anytime in the session
sess1.getAttribute("printeligibility");//this will return password Any time in the session

%>
<div class="test">
  <h2>Paris</h2>
  <p>
 everyday_maxcalorie is  ${everyday_maxcalorie}
  
  <br>
  print eligibility is ${printeligibility} <br>
  
  Recommended Plan  is ${plan}
 </p>

</div>

<%
try{
connection = DriverManager.getConnection(connectionUrl+database, db, password);
statement=connection.createStatement();
//SELECT registeruser.name, aboutme.* FROM registeruser INNER JOIN aboutme ON registeruser.userid=aboutme.userid;
String sql ="SELECT registeruser.name, aboutme.* FROM registeruser INNER JOIN aboutme ON registeruser.userid=aboutme.userid";
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>

<%
name=resultSet.getString("name");
name1=LoginServlet.un;
 userid=resultSet.getInt("userid") ;
 weight=resultSet.getDouble("weight") ;
cuisine=resultSet.getString("cuisine") ;
	
%>


<tr>
<%if(name.equalsIgnoreCase(name1)){ %> 
   
    <table border="1">
<tr>
<td>user id</td>
<td>weight</td>
<td>name</td>
<td>cuisine</td>

</tr>
    
<td><%=userid%></td>
<td><%=weight %></td>
<td><%=name %></td>
<td><%=cuisine %></td>
</tr>

<%} %>






<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</table>

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
      <h1 class="text-white"><%=cuisine %>  <%=name%> <%=userid %>  <%=name1 %> <%=weight %></h1> <div class="text-white p-3">PLAN A</div>
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