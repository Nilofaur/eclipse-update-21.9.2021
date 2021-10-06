package com.tryme;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MethodServlet
 */
@WebServlet("/method")
public class MethodServlet extends HttpServlet {
	
	private static int weightcategory;
	private static double height;
	private static double weight;
	private static int age;
	private static String activity;
	
	private static double morning;
	private static double lunch;
	private static double dinner;
	private static int minutes;
	private static double today_eod;
	private static double balance_result;
	private static String print_eligibility;
	public static String plan;
	private static double bmi;

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
		   double bmr=MethodServlet.BMR(AboutmeServlet.height, AboutmeServlet.weight, AboutmeServlet.age);
		   double pal=MethodServlet.pal(AboutmeServlet.activity);
		   
		   double everyday_maxcaloriemethod=bmr*pal;
		   System.out.println("Tee: Everyday calorie for a person "+everyday_maxcaloriemethod);
		return everyday_maxcaloriemethod;
	   }
	   
	   
   //METHOD 7.1
	   
	   static double everyday_maxcaloriemethod1( )
	   {
		   double bmr=MethodServlet.BMR(UpdateServlet.height, UpdateServlet.currentweight, UpdateServlet.age);
		   double pal=MethodServlet.pal(UpdateServlet.Todayactivity);
		   
		   double everyday_maxcaloriemethod1=bmr*pal;
		   System.out.println("Tee: Everyday calorie for a person "+everyday_maxcaloriemethod1);
		return everyday_maxcaloriemethod1;
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
			if ( act.equalsIgnoreCase("sedentary"))
			{
				act1=3;
				
						
			}
		        
			if ( act.equalsIgnoreCase("active"))
			{
				act1=5;
			
			}
			
			if ( act.equalsIgnoreCase("vigorous"))
			{
				act1=10;
				
			}
			
			return act1;
		   
	   }
		
	   
	   //METHOD 10
	   
	  static double burnt_byworkoutmethod(int min,double weight2)
	   {
		   
		   
		  double total_calBurnt= (min*UpdateServlet.met1)*((UpdateServlet.met1*3.5*weight2)/200);
		   
		return total_calBurnt;
	   
	   }
	  
	  //METHOD 11
	  static double eod_spentmethod()
	  {
		  
		  if (consumed_caloriesmethod(UpdateServlet.morning, UpdateServlet.lunch, UpdateServlet.dinner)>burnt_byworkoutmethod(UpdateServlet.minutes, UpdateServlet.currentweight))
		  {
			today_eod=( consumed_caloriesmethod(UpdateServlet.morning, UpdateServlet.lunch, UpdateServlet.dinner)-burnt_byworkoutmethod(UpdateServlet.minutes, UpdateServlet.currentweight));
			   
		  }
		  else 
			  today_eod=( burnt_byworkoutmethod(UpdateServlet.minutes, UpdateServlet.currentweight)-consumed_caloriesmethod(UpdateServlet.morning, UpdateServlet.lunch, UpdateServlet.dinner));

		return today_eod;
		  
	  }
	  
	  //METHOD 12
	  
	  static double totalbalanceleft_method() {
		  if(everyday_maxcaloriemethod1()>eod_spentmethod())
		  {
			  balance_result=everyday_maxcaloriemethod1()-eod_spentmethod();
		  }
		  else 
			  balance_result=eod_spentmethod()-everyday_maxcaloriemethod1();
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
			
		    bmi=Calcbmi(AboutmeServlet.height,AboutmeServlet.weight);
			System.out.println("printBMICategory(bmi) : "+printBMICategory(bmi));
			System.out.println("Your bmi is - method 13 " +  bmi);
			System.out.println("weightcategory ID is - method 13 " +weightcategory);
			
			// cases
			if (weightcategory==1)
			{
				print_eligibility=" You re recommended to take weight gain programme" ;
				System.out.println(print_eligibility); 
				plan="weightgain";
				
			}
			if (weightcategory==2)
			{
				print_eligibility=" You re healthy so nutrition diet is recommended";
				System.out.println( print_eligibility); 
				plan="nutrition";
			
			}
			if (weightcategory==3)
			{
				print_eligibility=" You re recommended to lose weight so weight lose programme is recommended" ;
				System.out.println(print_eligibility); 
				plan="weightlose";
			}
			if (weightcategory==4)
			{
				print_eligibility="You re recommended to lose weight quickly so weight lose programme is recommended";
					System.out.println( print_eligibility); 
					plan="rapidlose";
			}
	      }	
			else
			{
				print_eligibility=" Sorry youre not eligible for this programme because your age is= ";
				System.out.println( print_eligibility + "  " +age);
			
			}
		return print_eligibility;
		
		  
	  }
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
