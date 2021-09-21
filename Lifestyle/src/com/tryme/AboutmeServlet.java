package com.tryme;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//NEW
@WebServlet(urlPatterns = {"/aboutme/*"})
//@WebServlet("/aboutme")
public class AboutmeServlet extends HttpServlet {
	static int age;
	static double weight;
	static double height;
	static String activity;
	static double morning;
	static double lunch;
	static double dinner;
	
	static int x;
	//METHOD 1
	static boolean betweenHeight(int x,int min,int max) 
	{
		  return x >= min && x <= max;
		}
	
	//METHOD 2
	static boolean maxWeight(int x,int min,int max) 
	{
		  return x >= min && x <= max;
		}
	
	//METHOD 3
	static double Calcbmi(double h,double w) 
	{
		double y = (100*100*w)/(h*h);
		  return y;
		}
	//METHOD 4
	
	private static String printBMICategory(double bmi) {
		String s;
	
        if(bmi < 18.5) {
        	s= "You are underweight";
         x=1;
        }else if (bmi < 25) {
        	s="You are normal";
           x=2;
        }else if (bmi < 30) {
        	s="You are overweight";
          x=3;
        }else {
        	s="You are obese";
         x=4;
        }
		return s;
        
    }
	//METHOD 5
	
	private static double BMR(double height2,double weight2, int age) {
		
		double bmr = (10*weight2)+(6.25*height2)-(5*age)-161;
	
		System.out.println("BMR"+bmr);
		return bmr;
		
	}
	//METHOD 6
	
   private static double pal( String activity) {
	
		double a = 0;
	if ( activity.equalsIgnoreCase("sedentary"))
	{
		a=1.5;
		System.out.println("a:"+a);
		
	}
        
	if ( activity.equalsIgnoreCase("active"))
	{
		a=1.80;
		System.out.println("a:"+a);
	}
	
	if ( activity.equalsIgnoreCase("vigorous"))
	{
		a=2.30;
		System.out.println("a:"+a);
	}
	
	return a;
    }
	
   //METHOD 7
   
   private static double tee( )
   {
	   double bmr=BMR(height, weight, age);
	   double pal=pal(activity);
	   
	   double tee=bmr*pal;
	   System.out.println("Tee: Everyday calorie for a person "+tee);
	return tee;
   }
	
   //METHOD 8
   
	
	
	
	//1.Everyday Calorie

	//2.Activities burned
	//3.Consumed Calories
	


	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException 
	{
	
	     age= Integer.parseInt(req.getParameter("age"));
		 weight= Double.parseDouble(req.getParameter("weight"));
		 height= Double.parseDouble(req.getParameter("height"));
		 activity= req.getParameter("activities");
		morning=	
				
				
	
		//<%= "<h1> The sum is "+(Integer.parseInt(request.getParameter("t1"))+Integer.parseInt(request.getParameter("t2")))+"</h1>"%>
		
		//req.getRequestDispatcher("/programme.jsp").include(req, res);
		
		 //req.getRequestDispatcher("/programme.jsp").forward(req, res);

		PrintWriter out=res.getWriter();
		//1. check eligibility age above 16
		
      if(age>16)
	       {
			out.println("yes you r eligible as youre over 16 !");
			
		// 2. Check height and weight range	
			//bmi check
			
			double bmi=Calcbmi(height,weight);
			out.println(printBMICategory(bmi));
			out.println("Your bmi is  " +bmi);
			//out.println("x is  " +x);
			
			// cases
			if (x==1)
			{
				out.println(" You re recommended to take weight gain programme" ); 
				res.setContentType("text/html");
				out.println("<a href=\"plan.jsp\">Go to plan </a>");
			}
			if (x==2)
			{
				out.println(" You re healthy so nutrition diet is recommended" ); 
				res.setContentType("text/html");
				out.println("<a href=\"plan.jsp\">Go to plan </a>");
			}
			if (x==3)
			{
				out.println(" You re recommended to lose weight so weight lose programme is recommended" ); 
				res.setContentType("text/html");
				out.println("<a href=\"plan.jsp\">Go to plan </a>");
			}
			if (x==4)
			{
				out.println("You re recommended to lose weight quickly so weight lose programme is recommended" ); 
				res.setContentType("text/html");
				out.println("<a href=\"plan.jsp\">Go to plan </a>");
			}
	       }	
			else
			{
				out.println(" Sorry youre not eligible for this programme because your age is= " +age );
				res.setContentType("text/html");
				out.println("<a href=\"logout.jsp\">logout please </a>");
			}
		
	
      
      //CALL
          BMR(height, weight, age);
          pal(activity);
          out.print("So youre everyday calorie should be : "+tee());
  
    
      
     



}
}