package com.tryme;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.tryme.*;


public class DaoClass {

	
	//start
		private Connection con;
		private String query;
	    private PreparedStatement pst;
	    String un= LoginServlet.un;
	
	    String username;
		public int id;
	   
		String plan=MethodServlet.plan;
		
		//getUserid(); 

		public DaoClass(Connection con) {
			super();
			this.con = con;
		}
		
		//end
		
		
		 
	    // start
	    
	    public List<GetLoginId> getsqlName(String name) {
	    	List<GetLoginId> a=new ArrayList<>();
	    	
		        try {
		        	//System.out.println("I am daoClass- "+LoginServlet.un);
		            query = "select name from registeruser where name = '"+LoginServlet.un + "'";
		            		
		            pst = this.con.prepareStatement(query);
		         //   pst.setString(1, "nilo");
		            ResultSet rs = pst.executeQuery();
		            
		            while (rs.next()) {
		          GetLoginId row = new GetLoginId();
		           
		          row.setName(rs.getString("name"));
		            	 
		            	 a.add(row);
		            }
		        } catch (Exception e) {
		            e.printStackTrace();
		            System.out.println(e.getMessage());
		        }

		        return a;
		    }
	    
	
	    
	    // end
	   
	    
	    // start 1 get userid WORKING
	    
	    public int getUserid(String name) throws SQLException {
	    	
	    	
	    		    	
		            query = "select userid from registeruser where name = '"+name + "'";
		            		
		            pst = this.con.prepareStatement(query);
		         
		            ResultSet rs = pst.executeQuery();
		         
		            while (rs.next()) 
		            {
		            System.out.println("id = "+" "+rs.getInt(1));	
		            id = rs.getInt(1);
		            }
		         
		           return id;
		    }
	    
	    //end1 copy paste
	    
	  
	   // SAMPLE- NOT IN USE

	    public boolean insert(double weight, double height, int age, Double goal, String ethnicity, String activity, String cuisine, String plan) {
	        boolean result = false;
	        try {
	        	//call
	        	System.out.println("insert method calling getuserid method "+getUserid(un));
	        	System.out.println("plan insert method="+plan);
	        	                                                                                                                                
	        	                                                                                                                
	        	query = "insert into userdb.Aboutme (userid, weight, height, age, goalweight, ethnicity, activity, cuisine) values(?,?,?,?,?,?,?,?,?)";  
	            pst = this.con.prepareStatement(query);
	            int userid = getUserid(un);
	            System.out.println("userid="+userid);
	            pst.setInt(1, 1);
	            pst.setDouble(2, weight);
	            pst.setDouble(3, height);
	            pst.setInt(4, age);
	            pst.setDouble(5, goal);
	            pst.setString(6, ethnicity);
	            pst.setString(7, activity);
	            pst.setString(8, cuisine);
	            pst.setString(9, plan);
	            pst.executeUpdate();
	            result = true;
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	        return result;
	    }
	  
		//WORKing
		public boolean insert1() {
			System.out.println("INSERT 1 METHOD LINE 127");
	        boolean result = false;
	        try {
	        	  int userid = getUserid(un);
	        	  double weight=AboutmeServlet.weight;
	        	  double height=AboutmeServlet.height;
	        	  int age=AboutmeServlet.age;
	        	  double goalweight=AboutmeServlet.goal;
	        	  String ethnicity =AboutmeServlet.ethnicity;
	        	  String activity =AboutmeServlet.activity;
	        	  String cuisine=AboutmeServlet.cuisine;
	        	  
	        	System.out.println("plan insert method1"+plan);
	        	
	        	//query = "insert into userdb.Aboutme (userid, weight, height, age, goalweight, ethnicity, activity, cuisine ) values("+userid+","+weight+","+height+","+age+","+goalweight+",'"+ethnicity+"','"+activity+"','"+cuisine+"')";  
	        
	    query= "insert into userdb.Aboutme (userid, weight, height, age, goalweight, ethnicity, activity, cuisine , plan) "
	    		+ "values("+userid+","+weight+","+height+","+age+","+goalweight+",'"+ethnicity+"','"+activity+"','"+cuisine+"','"+plan+"') "
		        + "ON DUPLICATE KEY UPDATE userid = "+userid+",weight="+weight+",height="+height+",age="+age+","
		        + "goalweight="+goalweight+","+ "ethnicity='"+ethnicity+"',activity='"+activity+"',cuisine='"+cuisine+"',plan='"+plan+"'";	        	
	        	
	        	
	        	
	        	
	            pst = this.con.prepareStatement(query);
	           
	            
	            pst.executeUpdate();
	            result = true;
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	        return result;
	    }
	    
	    
	    
}
