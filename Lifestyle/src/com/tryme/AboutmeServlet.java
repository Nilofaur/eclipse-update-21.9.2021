package com.tryme;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.tryme.DaoClass;
import com.tryme.LoginDao;

//NEW
@WebServlet(urlPatterns = {"/aboutme/*"})
//@WebServlet("/aboutme")
public class AboutmeServlet extends HttpServlet {
	static int age;
	static double weight;
	static double height;
static double goal;
static String ethnicity;
static String cuisine;
	static double met;
	static String activity;
    
//static double everyday_maxcalorie=MethodServlet.everyday_maxcaloriemethod();

	
	//METHOD 14
  
  //IDEAL WEIGHT  45.5 + (0.91 × [height in centimeters − 152.4])
  
//METHOD 15
 // Decreasing your caloric intake by 500-1000 calories per day, 
  //should result in an approximate 1-2 pound weight loss per week.

	public static boolean sql()
	{
		

    DaoClass ld ;
	try {

		ld = new DaoClass(Dbcon.getConnection());

		System.out.println("INSERT 1 method " +" "+ld.insert1());

	} catch (ClassNotFoundException ee) {
		// TODO Auto-generated catch block
		ee.printStackTrace();
	} catch (SQLException ee) {
		// TODO Auto-generated catch block
		ee.printStackTrace();
	}
	return false;
	}
	
	
	
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException 
	{
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		PrintWriter out=res.getWriter();
	
	//GET ALL THE PARAMETERS FROM aboutme.jsp
	     age= Integer.parseInt(req.getParameter("age"));
		 weight= Double.parseDouble(req.getParameter("weight"));
		 height= Double.parseDouble(req.getParameter("height"));
		 activity= req.getParameter("activities");
		 goal=Double.parseDouble(req.getParameter("goal"));
		 ethnicity=req.getParameter("ethnicity");
		 cuisine=req.getParameter("cuisine");
		 
		 met =MethodServlet.MET(activity);
	
		 
	      //CALL
		MethodServlet.eligibility(age);
		//MethodServlet.everyday_maxcaloriemethod();
		

		 // store the values from the methods 

 
      String printeligibility=MethodServlet.eligibility(age);
      System.out.println( "plan variable = "+MethodServlet.plan);
      String plan=MethodServlet.plan;
      
      // TRY SESSION - set value so it can be forwarded to JSP
       HttpSession sess = req.getSession(); 
     
      sess.setAttribute("height", height);
      sess.setAttribute("age", age);
    //sess.setAttribute("everyday_maxcalorie",everyday_maxcalorie);
	  sess.setAttribute("printeligibility", printeligibility);
	  sess.setAttribute("plan", plan);
     
	    // forward it to JSP
	          
	          RequestDispatcher disp = req.getRequestDispatcher("/plan.jsp");
	          RequestDispatcher disp1 = req.getRequestDispatcher("/dashboard.jsp");
	          try {
	        	 System.out.println("calling sql()"+" "+sql());
				disp.forward(req, res);
				disp1.forward(req, res);
				
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch bloc
				e.printStackTrace();
			}
	

	       
}
}