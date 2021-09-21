package com.tryme;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbcon {
	
	private static Connection connection = null;
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
        if(connection == null){
            Class.forName("com.mysql.cj.jdbc.Driver");
            //jdbc:mysql://localhost:3306/userdb", "root", "secret
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb","root","secret");
            System.out.print("connected userdb database");
        }
        return connection;
    }
}

