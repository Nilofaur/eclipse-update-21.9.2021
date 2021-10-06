package com.tryme;

import java.io.*;  
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
  
public class Register extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
String n=request.getParameter("userName");  
String p=request.getParameter("userPass");  
String e=request.getParameter("userEmail");  

String success="You are successfully registered...";
RequestDispatcher disp = null;         
try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/userdb", "root", "secret");  


PreparedStatement ps=con.prepareStatement(  
"insert into registeruser (name,pass,email) values(?,?,?)");  
  


ps.setString(1,n);  
ps.setString(2,p);  
ps.setString(3,e);  
  
          
int i=ps.executeUpdate();  


//TRY SESSION
HttpSession sess = request.getSession(); 

//send user name n success msg
sess.setAttribute("success", success);
sess.setAttribute("n", n);

if(i>0)  
System.out.print(success);  
	  disp = request.getRequestDispatcher("/login.jsp");

try {
	disp.forward(request, response);
	
} catch (ServletException | IOException ee) {
	// TODO Auto-generated catch bloc
	ee.printStackTrace();
}   
          
}catch (Exception e2) {System.out.println(e2);}  
          
out.close(); 
  // forward it to JSP
        
      

}  
  
}  