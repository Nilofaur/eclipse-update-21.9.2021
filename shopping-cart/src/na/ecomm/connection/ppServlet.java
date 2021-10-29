package na.ecomm.connection;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import na.ecomm.dao.ProductDao;
import na.ecomm.model.Cart;

/**
 * Servlet implementation class ppServlet
 */
@WebServlet("/pp")
public class ppServlet extends HttpServlet {
	
	public static int total;
	public static double sum;
	private static final long serialVersionUID = 1L;

	protected void Service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		final long serialVersionUID = 1L;

HttpSession session = null;
ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
List<Cart> cartProduct = null;
if (cart_list != null) {
	
	request.setAttribute("cart_list", cart_list);
}
ProductDao pd = null;
try {
	pd = new ProductDao(DbCon.getConnection());
} catch (ClassNotFoundException | SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
pd.getCartProducts(cart_list);
 sum=ProductDao.sum;
 ProductDao.insert_sum();
 total=ProductDao.get_sum();
	System.out.println("ppServlet"+sum);
	request.setAttribute("sum", sum); 
	request.setAttribute("total",total); 
	RequestDispatcher disp = request.getRequestDispatcher("/home.jsp");
	disp.forward(request, response);
	
	}

}
