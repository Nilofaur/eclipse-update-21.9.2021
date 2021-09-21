package com.tryme;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import na.ecomm.model.Product;

public class DaoClass {

	
	//start
		private Connection con;
		private String query;
	    private PreparedStatement pst;
	    //private ResultSet rs;
	    

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
}
