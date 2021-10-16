package SQL;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tryme.LoginServlet;

public class SQL extends HttpServlet {
	
	static PrintWriter out;
	static String driver = "com.mysql.jdbc.Driver";
	static String connectionUrl = "jdbc:mysql://localhost:3306/";
	static String database = "userdb";
	static String db = "root";
	static String password = "secret";
	static String query="";
	static PreparedStatement pst;
	static Connection connection = null;
	static Statement statement = null;
	static ResultSet resultSet = null;
	

	static ResultSet rs = null;
	static ResultSetMetaData rsmd = null;
	static int columnsNumber = 0;
	//initialisation
	
	public static String days ;
	static String breakfast ;
	static String lunch;
	static String evening_snack ;
	public static String dinner;
	public static String t ;
	
	// METHOD 1
	public static String english ()
	{
		SQL.database();

		String sql = "Select * from userdb.english";

		try {
			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(resultSet);
		}
		try {
			while (resultSet.next()) {
				days = resultSet.getString("days");
				breakfast = resultSet.getString("breakfast");
				lunch = resultSet.getString("lunch");
				evening_snack = resultSet.getString("evening_snack");
				dinner = resultSet.getString("dinner");
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultSet.toString();
		

}
	
	
	//METHOD 2 DB CONNECTION
	
	public static void database()
	{

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	
	
		try {
			connection = DriverManager.getConnection(connectionUrl + database, db, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("connected");
		}
		
	}
	
	//TRY LIST - RETURN METHOD - used this method
	
    
    public static List<SQLinitialisation> getenglish(String d) {
    	
    	SQL.database();
    	List<SQLinitialisation> a=new ArrayList<>();
    	
	        try {
	        	System.out.println("d (getenglishmethod) "+d);
	            query = "Select * from userdb.english where days = '"+d+ "'";
	            
	            		
	            pst = SQL.connection.prepareStatement(query);
	         //   pst.setString(1, "nilo");
	            ResultSet rs = pst.executeQuery();
	        
	       	 for(int i=0;i<=3;i++)
      	      {    
	            while (rs.next()) {
	            	
	            
	          SQLinitialisation row = new SQLinitialisation();
	           
	          row.setDays(rs.getString("days"));
	          row.setBreakfast(rs.getString("breakfast"));
	          row.setLunch(rs.getString("lunch"));
	          row.setEvening_snack(rs.getString("evening_snack"));
	          row.setDinner(rs.getString("dinner"));
	            	 
	            	 a.add(row);
	            	 
	          // dinner=rs.getString(dinner); 	 
	           
	            	 
	            }}
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println("e.get message "+e.getMessage());
	        }

	        return a;
	    }
    
    
	
	// PRINTS ALL ROWS	  METHOD 3
    public static  String getenglish1() {
    	
    	SQL.database();
    	
    	 //SQL.getenglish1();
	      
	        
	            query = "Select * from userdb.english";
	            		
	            try {
					pst = SQL.connection.prepareStatement(query);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	         //   pst.setString(1, "nilo");
	           
				try {
					rs = pst.executeQuery();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	          
				try {
					rsmd = rs.getMetaData();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	          
				try {
					columnsNumber = rsmd.getColumnCount();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	            
	            try {
	            	
					while (rs.next()) {
						
						for(int i = 1 ; i <= columnsNumber; i++){

						   System.out.print(""+rs.getString(i) + " "); //Print one element of a row
						    breakfast=  rs.getString(breakfast);
						    days=  rs.getString(days);
						    lunch=  rs.getString(lunch);
						  
						}

						  System.out.println();//Move to the next line to print the next row.           

						    }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return dinner;
	     	 
	   
	    }


    
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException 
	{
    	 t = request.getParameter("days");
    	// TRY SESSION - set value so it can be forwarded to JSP
        HttpSession sess = request.getSession(); 
      
       sess.setAttribute("days", days);
       sess.setAttribute("breakfast", breakfast);
       sess.setAttribute("lunch",lunch);
 	   sess.setAttribute("evening_snack", evening_snack);
 	   sess.setAttribute("dinner", dinner);
 	   
	}
	

	public static void main(String[] args) {
		
	
	   // System.out.println(" PSVM: List:  "+SQL.getenglish(t));
	  //  SQL.getenglish1();
      
}
}