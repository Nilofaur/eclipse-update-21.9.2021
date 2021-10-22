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
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tryme.AboutmeServlet;
import com.tryme.DaoClass;
import com.tryme.LoginServlet;
import com.tryme.UpdateServlet;

import na.ecomm.model.Product;

public class SQL extends HttpServlet {
	
	static PrintWriter out;
	static String driver = "com.mysql.jdbc.Driver";
	static String connectionUrl = "jdbc:mysql://localhost:3306/";
	static String database = "userdb";
	static String db = "root";
	static String password = "secret";
	static String query="";
	static String query1="";
	static PreparedStatement pst;
	static Connection connection = null;
	static Statement statement = null;
	static ResultSet resultSet = null;
	
	
	public static int id;
	public static Double ht;
	public static int ag;
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
	public static String table;
	public static String name;
	static List<SQLinitialisation> food =new ArrayList<SQLinitialisation>(); 
	 public static String tod="";
	
	
	
	// username METHOD
	public static  String un(String name) {
		
		SQL.name=name;
		
		return name;
		
		
	}
	
	
  
 
 //METHOD 2 FOR DATE
    
	public static String tod_date()
	{
		//Instantiate a Date object
		Date date = new Date();
		System.out.println(tod);
		return tod=date.toString();
		
	}
 

	//METHOD 3 DB CONNECTION
	
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
	
	//TRY LIST - RETURN METHOD 4 - used this method
	
    
    public static List<SQLinitialisation> getenglish(String d, String table) {
    	
    	SQL.database();
    	List<SQLinitialisation> a=new ArrayList<>();
    	
	        try {
	        	System.out.println("d (getenglishmethod) "+d);
	            query = "Select * from userdb."+table+" where days = '"+d+ "'";
	            	
	            pst = SQL.connection.prepareStatement(query);
	      
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
	            }}
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println("e.get message "+e.getMessage());
	        }

	        return a;
	    }
    
    //METHOD 5 - METHOD TO JUST CALL GETENGLISH METHOD WITH PARAMETERS 
  
    public static List<SQLinitialisation> food_table(String days, String table) {
    List<SQLinitialisation> food = SQL.getenglish(days,table);
    
	return food;
    }
    
    
    
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException 
	{
    	 t = request.getParameter("days");
    
	}
	
    //METHOD 6 to get the user id 
    
    public static int getUserid(String name) throws SQLException {
    	
    	SQL.database();
    	
        query = "select userid from registeruser where name = '"+name + "'";
        System.out.println("login name" +name);
        		
        pst = SQL.connection.prepareStatement(query);
	      
        ResultSet rs = pst.executeQuery();
    
        while (rs.next()) 
        {
        System.out.println("id = "+" "+rs.getInt(1));	
        id = rs.getInt(1);
        }
     
       return id;
        }
     

    
    
    
    // METHOD 7: Get weight and height from about me table to be used for manual update jsp
    // update the other columns 
    
    
   		    public static boolean insert_manual() {
   		     SQL.database();
   		    	
  	        boolean result = false;
  	        try {
  	        	int userid = SQL.getUserid(name);
  	       
  	        	double bf_cal=UpdateServlet.morning;
  	        	double lun_cal=UpdateServlet.lunch;
  	        	double din_cal=UpdateServlet.dinner;
  	        	String activity=UpdateServlet.Todayactivity;
  	        	double minutes=UpdateServlet.minutes;
  	        	double currentweight=UpdateServlet.currentweight;
  	       
  	        
 query=" INSERT INTO userdb.manual_update (userid, height,age)"
  	+ "SELECT userid, height, age FROM userdb.aboutme where userid="+userid+";";
 
 query1="UPDATE userdb.manual_update SET  `bf_cal` = "+bf_cal+", `lun_cal` = "+lun_cal+", `din_cal` = "+din_cal+","
  + "`activity` = '"+activity+"', `minutes` = "+minutes+", `weight` = "+currentweight+",`tod` = '"+tod+"' WHERE (`userid` = '"+userid+"')";

    pst = SQL.connection.prepareStatement(query);
    pst.executeUpdate();
    
    pst = SQL.connection.prepareStatement(query1);
    pst.executeUpdate();
 
  	         result = true;
  	        } catch (SQLException e) {
  	            System.out.println(e.getMessage());
  	        }
  	        return result;
  	    }
  	    
  // METHOD 8 get height and age from aboutme table and store it in a variable to be displayed on manualupdate.jsp
   		    
   		    public static void get_htage ()
   		    {
   		    	SQL.database();
   		    	int userid = 18;
				try {
				//	userid = SQL.getUserid(name);
				
   		    	query="Select height,age from userdb.aboutme where userid = "+userid+";";
   		    	pst= SQL.connection.prepareStatement(query);
   		        pst.executeQuery();
   		      
   		     ResultSet rs = pst.executeQuery();
   		    
   	        while (rs.next()) 
   	        {
   	        System.out.println("height = "+" "+rs.getInt(1));	
   	     System.out.println("age = "+" "+rs.getInt(2));	
   	        ht = rs.getDouble(1);
   	        ag= rs.getInt(2);
   	        
   	        }
   	     
   	       return ;
				
   		 } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
   		    	
				return;
   		    	
   		 }	    }
   		    
   		    
    

	public static void main(String[] args) {
		
get_htage();
	System.out.println(ht);
			
		
//food = SQL.food_table("mon", "asian");
//System.out.println(food);
	// System.out.println(" PSVM: List:  "+SQL.getenglish("mon", "asian"));
	 
      
}
}