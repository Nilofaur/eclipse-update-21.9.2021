package com.tryme;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UpdateServlet
 */
//@WebServlet(urlPatterns = {"/update/*"})
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	
	static String Todayactivity;
	static double morning;
	static double lunch;
	static double dinner;
	static int minutes;
	static double currentweight;
	static double height;
	static int age;
	static double met1;
	
	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		 Todayactivity= req.getParameter("todayactivities");
		 morning= Double.parseDouble(req.getParameter("morning"));	
		 lunch= Double.parseDouble(req.getParameter("lunch"));	
		 dinner= Double.parseDouble(req.getParameter("dinner"));	
		 minutes= Integer.parseInt(req.getParameter("minutes"));	
		 currentweight= Double.parseDouble(req.getParameter("currentweight"));	
		height= Double.parseDouble(req.getParameter("height"));	
		age= Integer.parseInt(req.getParameter("age"));
		 met1 =MethodServlet.MET(Todayactivity); 
		 
		 //PRINT IN CONSOLE
		System.out.println( "Today's max calories youre allowed = " +MethodServlet.everyday_maxcaloriemethod1());
		System.out.println( "consumed calories= " +MethodServlet.consumed_caloriesmethod(morning, lunch, dinner));
		System.out.println( "you burnt by workout = "+ MethodServlet.burnt_byworkoutmethod(minutes, currentweight));
		System.out.println( "You spent eod"+ MethodServlet.eod_spentmethod());
		System.out.println( "you re left only with "+ MethodServlet.totalbalanceleft_method());
		
		
		//STORE VALUES FROM METHOD
		double everyday_maxcalorie1=MethodServlet.everyday_maxcaloriemethod1();
		double consumed_calories=MethodServlet.consumed_caloriesmethod(morning, lunch, dinner);
		double burnt_byworkout=MethodServlet.burnt_byworkoutmethod(minutes, currentweight);
		double eod_spent=MethodServlet.eod_spentmethod();
		double totalbalanceleft= MethodServlet.totalbalanceleft_method();
		double met1=MethodServlet.MET(Todayactivity);
		
		//TRY SESSION
		
		HttpSession sess = req.getSession(false); //use false to use the existing session
		//sess.getAttribute("weight");//this will return username anytime in the session
		sess.getAttribute("height");//this will return password Any time in the session
		sess.getAttribute("age");
		//SET VALUE TO BE FORWARDED TO JSP
		   req.setAttribute("everyday_maxcalorie1",everyday_maxcalorie1);
		   req.setAttribute("consumed_calories",consumed_calories);
	       req.setAttribute("burnt_byworkout",burnt_byworkout);
		   req.setAttribute("eod_spent", eod_spent);
		   req.setAttribute("totalbalanceleft", totalbalanceleft);
		   req.setAttribute("met1", met1);
		   
		   //FORWARD TO JSP
	          
	          RequestDispatcher disp = req.getRequestDispatcher("/dashboard.jsp");
	          try {
				disp.forward(req, res);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch bloc
				e.printStackTrace();
			}
	}

}
