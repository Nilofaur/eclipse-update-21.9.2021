package com.tryme;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tryme.*;;

/**
 * Servlet implementation class DemoServlet
 */
@WebServlet("/demo")
public class DemoServlet extends HttpServlet {
	static int age;
	static double weight;
	static double height;
	static String activity;
	static double morning;
	static double lunch;
	static double dinner;
	static int minutes;
	static double met;
	static int x;
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException 
	{
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		PrintWriter out=res.getWriter();
		
		
		 age= Integer.parseInt(req.getParameter("age"));
		 weight= Double.parseDouble(req.getParameter("weight"));
		 height= Double.parseDouble(req.getParameter("height"));
		// activity= req.getParameter("activities");
		 activity="active";
		 morning= Double.parseDouble(req.getParameter("morning"));	
		 lunch= Double.parseDouble(req.getParameter("lunch"));	
		 dinner= Double.parseDouble(req.getParameter("dinner"));	
		 minutes= Integer.parseInt(req.getParameter("minutes"));	
		 
		
		//call
		//AboutmeServlet.tee();
		//AboutmeServlet.consumed_calories(morning, lunch, dinner);
		//AboutmeServlet.activities_calories(minutes, weight);
		
		
		
		 
		 // store the values of methods 
	          
	         // double everyday_calorie= Integer.parseInt((df.format(AboutmeServlet.tee())));
	        //  double consumed_calorie= Integer.parseInt((df.format(AboutmeServlet.consumed_calories(morning,lunch,dinner))));
	       //  double activities_calorie= Integer.parseInt((df.format(AboutmeServlet.activities_calories(minutes,weight))));
		 
		// set value so it can be forwarded to JSP
	          
	        // req.setAttribute("everyday_calorie",everyday_calorie);
	       //  req.setAttribute("consumed_calorie",consumed_calorie);
	       //  req.setAttribute("activities_calorie",activities_calorie);
		 
	    // forward it to JSP
	          
	          RequestDispatcher disp = req.getRequestDispatcher("/plan.jsp");
	          try {
				disp.forward(req, res);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	}
	


