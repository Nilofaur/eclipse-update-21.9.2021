package na.ecomm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class sqltest {

	//
	static String driver = "com.mysql.jdbc.Driver";
	static String connectionUrl = "jdbc:mysql://localhost:3306/";
	static String database = "ecommerce_cart";
	static String db = "root";
	static String password = "secret";
	static int sum = 83;
	
	public static String query;
	public static PreparedStatement pst1;
	public static ResultSet rs1;

	public static Connection connection1 = null;
	public static Statement statement1 = null;
	public static ResultSet resultSet1 = null;
	
	//METHOD - DB
	public static void database() {

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			connection1 = DriverManager.getConnection(connectionUrl + database, db, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			statement1 = connection1.createStatement();
			System.out.println("database() ?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("connected");
		}

	}


	//METHOD - SEND SUM TO DB


		public static boolean insert_sum() {
			
	      boolean result = false;
	      try {
	    	  database();
	      System.out.println("insert_sum()");
	      	System.out.println("sum from insert_sum()"+sum);
				
	  query=" INSERT INTO `ecommerce_cart`.`pp` (`id`, `sum`) VALUES ('1', '35') "
	  		+ "ON duplicate key update sum= "+sum+" ;";
	  		
	          pst1 = sqltest.connection1.prepareStatement(query);
	         
	          pst1.executeUpdate();
	          result = true;
	      } catch (SQLException e) {
	          System.out.println(e.getMessage());
	      }
	      return result;
	  
		}

		//METHoD GET sum
		
		public static void get_sum() {
			database();
			
			try {
				
				query = "select sum from pp; ";
				pst1 = sqltest.connection1.prepareStatement(query);
				pst1.executeQuery();

				ResultSet rs = pst1.executeQuery();

				while (rs.next()) {
					System.out.println("sum select query = " + " " + rs.getInt(1));
				
					sum= rs.getInt(1);
					

				}

				return;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

				return;

			}
		}
	
		
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("sqltest class"+insert_sum());
		get_sum();
	}

}
