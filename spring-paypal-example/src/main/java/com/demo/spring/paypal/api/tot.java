package com.demo.spring.paypal.api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;





public class tot {

	
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


	
	//METHoD GET sum
	

		public static int get_sum() {
			database();
			
			try {
				
				query = "select sum from pp; ";
				pst1 = tot.connection1.prepareStatement(query);
				pst1.executeQuery();

				ResultSet rs = pst1.executeQuery();

				while (rs.next()) {
					System.out.println("sum select query = " + " " + rs.getInt(1));
				
					sum= rs.getInt(1);
					

				}

				return sum;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

				return sum;

			}
		}

	
	public static void main(String[] args) {
		
		
	
	}

}
