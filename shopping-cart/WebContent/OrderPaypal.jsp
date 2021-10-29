<%@page import="na.ecomm.connection.DbCon"%>

<%@page import="na.ecomm.model.*"%>
<%@page import="java.util.*"%>
<%@page import="na.ecomm.dao.*"%>
<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	DecimalFormat dcf = new DecimalFormat("#.##");
	request.setAttribute("dcf", dcf);
	User auth = (User) request.getSession().getAttribute("auth");
	List<Order> orders = null;
	if (auth != null) {
	    request.setAttribute("person", auth);
	    OrderDao orderDao  = new OrderDao(DbCon.getConnection());
		orders = orderDao.userOrders(auth.getId());
	}else{
		response.sendRedirect("login.jsp");
	}
	ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
	List<Cart> cartProduct = null;
	if (cart_list != null) {
		
		request.setAttribute("cart_list", cart_list);
	}
	ProductDao pd = new ProductDao(DbCon.getConnection());
	pd.getCartProducts(cart_list);
	double sum=ProductDao.sum;
	
	ProductDao.insert_sum();
request.setAttribute("sum", sum);
RequestDispatcher disp = request.getRequestDispatcher("/pp.jsp");
disp.forward(request, response);

	%>
	
	
<!DOCTYPE html>
<html>
<head>

<title>E-Commerce Cart</title>
</head>
<body>

	<div class="container">
		<div class="card-header my-3">All Orders</div>
	
		<table class="table table-light">
			<thead>
				<tr>
				<p id="demo">Total ? : <%=sum %></p>
					<th scope="col">Name</th>
					<br>
				
					<th scope="col">Price</th>
						</tr>
			</thead>
			<tbody>
			
			<%
			if(orders != null){
				for(Order o:orders){%>
					<tr>
					
						<td><%=o.getName() %></td>
						
						<td>£<%=dcf.format(o.getPrice()) %></td>
						
					</tr>
				<%}
			}
			%>
			
			</tbody>
		</table>

		
	</div>

</body>
</html>