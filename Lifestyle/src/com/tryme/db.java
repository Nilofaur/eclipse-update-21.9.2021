package com.tryme;
import java.sql.*;
public class db {
// NOT IN USE .. ONLY FOR TEST
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/schemanew", "root", "secret");
		Statement st=con.createStatement();
		
		ResultSet rs1=st.executeQuery("Select * from user");
		
		String userdata="";
		
		//String out1=rs1.getString("username") + "" + rs1.getString("email");
		while(rs1.next())
		{
			userdata=rs1.getString(1)+":"+rs1.getString(2);
			System.out.println(userdata);
		}
		
		
		//insert query
		
		String query="insert into user values ('soj','pwd')";
		//String username="Nantha";
		//String email="fgh";
		//PreparedStatement ps=con.prepareStatement(query);
		//ps.setString(1, username); 
	    //ps.setString(2, email);
		//int count=ps.executeUpdate();
		//System.out.println(count + "updated");
		
		
         int rs2=st.executeUpdate(query);
		
		//String userdata="";
		
		//String out1=rs1.getString("username") + "" + rs1.getString("email");
          System.out.println(rs2 + "updated");
          

          String query1="insert into schemanew.userdetail values ('6','Sanj','test','user')";
          int rs3=st.executeUpdate(query1);
          System.out.println(rs3 + "updated");
		st.close();
		con.close();
	}

}
