package na.ecomm.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbCon {
	private static Connection connection = null;
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
        if(connection == null){
            Class.forName("com.mysql.cj.jdbc.Driver");
            //jdbc:mysql://localhost:3306/userdb", "root", "secret
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce_cart","root","secret");
            System.out.print("connected ecommerce cart sql DB");
        }
        return connection;
    }
}