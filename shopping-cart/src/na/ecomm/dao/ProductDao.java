package na.ecomm.dao;

import java.sql.*;
import java.util.*;

//import com.tryme.AboutmeServlet;
//import com.tryme.DaoClass;

import na.ecomm.model.Cart;
import na.ecomm.model.Product;

public class ProductDao {
	private Connection con;

	public static String query;
    private PreparedStatement pst;
    private ResultSet rs;
    
    public static Connection con1;

	//
	static String driver = "com.mysql.jdbc.Driver";
	static String connectionUrl = "jdbc:mysql://localhost:3306/";
	static String database = "ecommerce_cart";
	static String db = "root";
	static String password = "secret";

	public static String query1;
	public static PreparedStatement pst1;
	public static ResultSet rs1;

	public static Connection connection1 = null;
	public static Statement statement1 = null;
	public static ResultSet resultSet1 = null;
	
	
	
    
public static int sum = 0;
	public ProductDao(Connection con) {
		super();
		this.con = con;
	}
	
	
	public List<Product> getAllProducts() {
        List<Product> book = new ArrayList<>();
        try {

            query = "select * from products";
            pst = this.con.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
            	Product row = new Product();
                row.setId(rs.getInt("id"));
                row.setName(rs.getString("name"));
                row.setCategory(rs.getString("category"));
                row.setPrice(rs.getDouble("price"));
                row.setImage(rs.getString("image"));

                book.add(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return book;
    }
	
	
	 public Product getSingleProduct(int id) {
		 Product row = null;
	        try {
	            query = "select * from products where id=? ";

	            pst = this.con.prepareStatement(query);
	            pst.setInt(1, id);
	            ResultSet rs = pst.executeQuery();

	            while (rs.next()) {
	            	row = new Product();
	                row.setId(rs.getInt("id"));
	                row.setName(rs.getString("name"));
	                row.setCategory(rs.getString("category"));
	                row.setPrice(rs.getDouble("price"));
	                row.setImage(rs.getString("image"));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println(e.getMessage());
	        }

	        return row;
	    }
	
	public double getTotalCartPrice(ArrayList<Cart> cartList) {
      sum = 0;
        try {
            if (cartList.size() > 0) {
                for (Cart item : cartList) {
                    query = "select price from products where id=?";
                    pst = this.con.prepareStatement(query);
                    pst.setInt(1, item.getId());
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        sum+=rs.getDouble("price")*item.getQuantity();
                  System.out.println("sum: product dao"+sum);
                    }

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return sum;
    }

    
    public List<Cart> getCartProducts(ArrayList<Cart> cartList) {
        List<Cart> book = new ArrayList<>();
        try {
            if (cartList.size() > 0) {
                for (Cart item : cartList) {
                    query = "select * from products where id=?";
                    pst = this.con.prepareStatement(query);
                    pst.setInt(1, item.getId());
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        Cart row = new Cart();
                        row.setId(rs.getInt("id"));
                        row.setName(rs.getString("name"));
                        row.setCategory(rs.getString("category"));
                        row.setPrice(rs.getDouble("price")*item.getQuantity());
                        row.setQuantity(item.getQuantity());
                        book.add(row);
                    }

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return book;
    }


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
      
      	System.out.println("sum from insert+sum()"+sum);
			/*
			 * String query1=" INSERT INTO `ecommerce_cart`.`pp` (`sum`)" +
			 * " values("+sum+") ON DUPLICATE KEY UPDATE sum = "+sum+"";
			 */
 
  query=" INSERT INTO `ecommerce_cart`.`pp` (`id`, `sum`) VALUES ('1', '35') "
  		+ "ON duplicate key update sum= "+sum+" ;";
  		
          pst1 = ProductDao.connection1.prepareStatement(query);
         
          pst1.executeUpdate();
          result = true;
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
      return result;
  
	}

	//METHoD GET sum -- didnt use here. check tot.java in paypal
	
			public static int get_sum() {
			
				
				try {
					database();
					System.out.println("get sum()");
					query = "select sum from pp; ";
					pst1 = ProductDao.connection1.prepareStatement(query);
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



}