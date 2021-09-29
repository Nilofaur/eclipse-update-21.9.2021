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
	static int minutes;
	static double met;
	static int weightcategory;
	static double today_eod;
	static double balance_result;
	static double bmi;
	static String print_eligibility;
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
	
 static String printBMICategory(double bmi) {
		String wc;
	
        if(bmi < 18.5) {
        	wc= "You are underweight";
         weightcategory=1;
        }else if (bmi < 25) {
        	wc="You are normal";
           weightcategory=2;
        }else if (bmi < 30) {
        	wc="You are overweight";
          weightcategory=3;
        }else {
        	wc="You are obese";
         weightcategory=4;
        }
		return wc;
        
    }
	//METHOD 5
	
	 static double BMR(double height2,double weight2, int age) {
		
		double bmr = (10*weight2)+(6.25*height2)-(5*age)-161;
	
		//System.out.println("BMR"+bmr);
		return bmr;
		
	}
	//METHOD 6
	
   static double pal( String activity) {
	
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
   
   static double everyday_maxcaloriemethod( )
   {
	   double bmr=AboutmeServlet.BMR(height, weight, age);
	   double pal=AboutmeServlet.pal(activity);
	   
	   double everyday_maxcaloriemethod=bmr*pal;
	   System.out.println("Tee: Everyday calorie for a person "+everyday_maxcaloriemethod);
	return everyday_maxcaloriemethod;
   }
	
   //METHOD 8
   
  static double consumed_caloriesmethod(double m, double l, double d)
   {
	  double sum=0;
	   sum=m+l+d;
	   return sum;
	   
   }
	
	//METHOD 9 - later create an sql table to fetch the value as per activity
   
    static double MET(String act)
   {
		int act1 = 0;
		if ( activity.equalsIgnoreCase("sedentary"))
		{
			act1=3;
			
					
		}
	        
		if ( activity.equalsIgnoreCase("active"))
		{
			act1=5;
		
		}
		
		if ( activity.equalsIgnoreCase("vigorous"))
		{
			act1=10;
			
		}
		
		return act1;
	   
   }
	
   
   //METHOD 10
   
  static double burnt_byworkoutmethod(int min,double weight2)
   {
	   
	   
	  double total_calBurnt= (min*met)*((met*3.5*weight)/200);
	   
	return total_calBurnt;
   
   }
  
  //METHOD 11
  static double eod_spentmethod()
  {
	  
	  if (consumed_caloriesmethod(morning, lunch, dinner)>burnt_byworkoutmethod(minutes, weight))
	  {
		today_eod=( consumed_caloriesmethod(morning, lunch, dinner)-burnt_byworkoutmethod(minutes, weight));
		   
	  }
	  else 
		  today_eod=( burnt_byworkoutmethod(minutes, weight)-consumed_caloriesmethod(morning, lunch, dinner));

	return today_eod;
	  
  }
  
  //METHOD 12
  
  static double totalbalanceleft_method() {
	  if(everyday_maxcaloriemethod()>eod_spentmethod())
	  {
		  balance_result=everyday_maxcaloriemethod()-eod_spentmethod();
	  }
	  else 
		  balance_result=eod_spentmethod()-everyday_maxcaloriemethod();
	  return balance_result;
  }
  
  //METHOD 13 
  
  static String eligibility(int age)
  {
		//1. check eligibility age above 16
	  if(age>16)
      {
		  print_eligibility="yes you r eligible as youre over 16 !";
		System.out.println(print_eligibility);
		
	// 2. Check height and weight range	
		//bmi check
		
	    bmi=Calcbmi(height,weight);
		System.out.println("printBMICategory(bmi) : "+printBMICategory(bmi));
		System.out.println("Your bmi is - method 13 " +  bmi);
		System.out.println("weightcategory ID is - method 13 " +weightcategory);
		
		// cases
		if (weightcategory==1)
		{
			print_eligibility=" You re recommended to take weight gain programme" ;
			System.out.println(); 
			//res.setContentType("text/html");
			//out.println("<a href=\"plan.jsp\">Go to plan </a>");
		}
		if (weightcategory==2)
		{
			print_eligibility=" You re healthy so nutrition diet is recommended";
			System.out.println( print_eligibility); 
			//res.setContentType("text/html");
		//	out.println("<a href=\"plan.jsp\">Go to plan </a>");
		}
		if (weightcategory==3)
		{
			print_eligibility=" You re recommended to lose weight so weight lose programme is recommended" ;
			System.out.println(print_eligibility); 
			//res.setContentType("text/html");
			//out.println("<a href=\"plan.jsp\">Go to plan </a>");
		}
		if (weightcategory==4)
		{
			print_eligibility="You re recommended to lose weight quickly so weight lose programme is recommended";
				System.out.println( print_eligibility); 
		//	res.setContentType("text/html");
			//out.println("<a href=\"plan.jsp\">Go to plan </a>");
		}
      }	
		else
		{
			print_eligibility=" Sorry youre not eligible for this programme because your age is= ";
			System.out.println( print_eligibility + "  " +age);
		//	res.setContentType("text/html");
		//	out.println("<a href=\"logout.jsp\">logout please </a>");
		}
	return print_eligibility;
	
	  
  }
	//METHOD 14
  
  //IDEAL WEIGHT  45.5 + (0.91 × [height in centimeters − 152.4])
  
//METHOD 15
 // Decreasing your caloric intake by 500-1000 calories per day, 
  //should result in an approximate 1-2 pound weight loss per week.

	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException 
	{
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		PrintWriter out=res.getWriter();
	
	
	     age= Integer.parseInt(req.getParameter("age"));
		 weight= Double.parseDouble(req.getParameter("weight"));
		 height= Double.parseDouble(req.getParameter("height"));
		 activity= req.getParameter("activities");
		 morning= Double.parseDouble(req.getParameter("morning"));	
		 lunch= Double.parseDouble(req.getParameter("lunch"));	
		 dinner= Double.parseDouble(req.getParameter("dinner"));	
		 minutes= Integer.parseInt(req.getParameter("minutes"));	
		 met =MET(activity);
	
		 
	
	      
	      //CALL
		 eligibility(age);
		 everyday_maxcaloriemethod();
		 consumed_caloriesmethod(morning,lunch,dinner);
		 burnt_byworkoutmethod(minutes,weight);
	

      
		 // store the values of methods 
	          
	         // double everyday_maxcalorie= Double.parseDouble((df.format(AboutmeServlet.everyday_maxcaloriemethod())));
	       //   double consumed_calorie= Double.parseDouble((df.format(AboutmeServlet.consumed_caloriesmethod(morning,lunch,dinner))));
	      //   double burnt_byworkout= Double.parseDouble((df.format(AboutmeServlet.burnt_byworkoutmethod(minutes,weight))));
      double everyday_maxcalorie=AboutmeServlet.everyday_maxcaloriemethod();
      double consumed_calorie=AboutmeServlet.consumed_caloriesmethod(morning, lunch, dinner);
      double burnt_byworkout=AboutmeServlet.burnt_byworkoutmethod(minutes, weight);
      double eod_spent=eod_spentmethod();
      double totalbalance_left=totalbalanceleft_method();
      String printeligibility=eligibility(age);
      
      
		// set value so it can be forwarded to JSP
	          
	         req.setAttribute("everyday_maxcalorie",everyday_maxcalorie);
	         req.setAttribute("consumed_calorie",consumed_calorie);
	         req.setAttribute("burnt_byworkout",burnt_byworkout);
		     req.setAttribute("eod_spent", eod_spent);
		     req.setAttribute("totalbalance_left", totalbalance_left);
		     req.setAttribute("printeligibility", printeligibility);
	    // forward it to JSP
	          
	          RequestDispatcher disp = req.getRequestDispatcher("/plan.jsp");
	          try {
				disp.forward(req, res);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch bloc
				e.printStackTrace();
			}
	


}
}