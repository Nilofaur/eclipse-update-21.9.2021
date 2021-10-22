<%@page import="SQL.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.tryme.*"%>
<%@page import="java.util.*"%>

<%@ include file="links.jsp"%>

<%
//DB connect 

String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String database = "userdb";
String db = "root";
String password = "secret";

//initiasation
String name1 = "";
String login_name = "";
int user_id = 0;
double weight = 0;
String cuisine = "";
double everyday_maxcalorie = 0;
String plan = "";


String days1;
String d;
String table1="";
List<SQLinitialisation> food =new ArrayList<SQLinitialisation>(); 


try {
	Class.forName(driver);
} catch (ClassNotFoundException e) {
	e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>

<%
days1=request.getParameter("days");

%>


<!DOCTYPE html>
<html>
<head>
<style>
.container {
	margin-top: 10px;
}
</style>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
	crossorigin="anonymous"></script>

</head>
<body>

	<%
		try {
		connection = DriverManager.getConnection(connectionUrl + database, db, password);
		statement = connection.createStatement();

		String sql = "SELECT registeruser.name, aboutme.* FROM registeruser INNER JOIN aboutme ON registeruser.userid=aboutme.userid where name='"
		+ LoginServlet.un + "'";

		resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
	%>

	<%
	name1 = resultSet.getString("name");
	login_name = LoginServlet.un;
	user_id = resultSet.getInt("userid");
	weight = resultSet.getDouble("weight");
	cuisine = resultSet.getString("cuisine");
	everyday_maxcalorie = resultSet.getDouble("everyday_maxcalorie");
	plan = resultSet.getString("plan");
	
	%>

	<%
		// DISPLAY CALORIE ONLY IF LOGIN CREDENTIAL MATCHES
	if (name1.equalsIgnoreCase(login_name)) {
	%>

	<div class="container">

		<table class="table table-sm table-hover table-dark ">
			<thead>
				<tr>
					<th scope="col">User Id</th>
					<th scope="col">Name</th>
					<th scope="col">Everyday Calorie</th>
					<th scope="col">Plan</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th scope="row"><%=user_id%></th>
					<td><%=name1%></td>
					<td><%=everyday_maxcalorie%></td>
					<td><%=plan%></td>
				</tr>

			</tbody>
		</table>
	</div>

	<%
		}
	%>

	<%
		}
	connection.close();
	} catch (Exception e) {
	e.printStackTrace();
	}
	%>



	<!-- Background image -->
	<div class="bg-image d-flex justify-content-center align-items-center"
		style="background-image: url('https://mdbootstrap.com/img/new/slides/006.jpg'); height: 100vh;">
		<!-- Background image -->

		<div class="container px-4">
			<div class="row gx-5">
				<div class="col">

					<div class="test1">
						<p>
						<h3>DIET</h3>

						<%
							// 1. WEIGHTLOSE 2.NUTRITION 3.WEIGHTGAIN 4.RAPIDLOSE
						// 1.ENGLISH 2.ASIAN 3.VEG

						//CASE 1-1 START:
						if (plan.equalsIgnoreCase("weightlose")) {

							if (cuisine.equalsIgnoreCase("english")) {
							
						%>

					</div>
					<h1 class="text-white"></h1>
					<div class="text-white p-3">


						<p>

							<%
							food=SQL.food_table(days1, "eng_lose");
							//just printing th o/p from the method
								out.println("food = " + food);
							if (!food.isEmpty()) {
								for (SQLinitialisation ss : food) {
							%>

							<%
								}
							} else {

							out.println(":(");
							}
							%>
						</p>
					</div>

				</div>

				<%
					}
				}
				%>


				<%
					// 1. WEIGHTLOSE 2.NUTRITION 3.WEIGHTGAIN 4.RAPIDLOSE
				// 1.ENGLISH 2.ASIAN 3.VEG

				//CASE 1-2 START:
				if (plan.equalsIgnoreCase("weightlose")) {

					if (cuisine.equalsIgnoreCase("asian")) {
				%>

			</div>
			<h1 class="text-white"></h1>
			<div class="text-white p-3">
				<p>

					<%
							food=SQL.food_table(days1, "asian_lose");
								out.println("food = " + food);
							if (!food.isEmpty()) {
								for (SQLinitialisation ss : food) {
							%>

					<%
								}
							} else {

							out.println(":(");
							}
							%>
				</p>



			</div>
		</div>

		<%
			}
		}
		%>
		<%
			// 1. WEIGHTLOSE 2.NUTRITION 3.WEIGHTGAIN 4.RAPIDLOSE
		// 1.ENGLISH 2.ASIAN 3.VEG

		//CASE 1-3 START:
		if (plan.equalsIgnoreCase("weightlose")) {

			if (cuisine.equalsIgnoreCase("mixed")) {
		%>

	</div>
	<h1 class="text-white"></h1>
	<div class="text-white p-3">
		<p>

			<%
								out.println("food = " + food);
							if (!food.isEmpty()) {
								for (SQLinitialisation ss : food) {
							%>

			<%
								}
							} else {

							out.println(":(");
							}
							%>
		</p>
	</div>



	<%
		}
	}
	%>













<%
							// 1. WEIGHTLOSE 2.NUTRITION 3.WEIGHTGAIN 4.RAPIDLOSE
						// 1.ENGLISH 2.ASIAN 3.VEG

						//CASE 2-1 START:
						if (plan.equalsIgnoreCase("nutrition")) {

							if (cuisine.equalsIgnoreCase("english")) {
							
						%>

					</div>
					<h1 class="text-white"></h1>
					<div class="text-white p-3">


						<p>

							<%
							food=SQL.food_table(days1, "eng_nut");
							//just printing th o/p from the method
								out.println("food = " + food);
							if (!food.isEmpty()) {
								for (SQLinitialisation ss : food) {
							%>

							<%
								}
							} else {

							out.println(":(");
							}
							%>
						</p>
					</div>

				</div>

				<%
					}
				}
				%>


				<%
					// 1. WEIGHTLOSE 2.NUTRITION 3.WEIGHTGAIN 4.RAPIDLOSE
				// 1.ENGLISH 2.ASIAN 3.VEG

				//CASE 2-2 START:
				if (plan.equalsIgnoreCase("nutrition")) {

					if (cuisine.equalsIgnoreCase("asian")) {
				%>

			</div>
			<h1 class="text-white"></h1>
			<div class="text-white p-3">
				<p>

					<%
							food=SQL.food_table(days1, "asian_nut");
								out.println("food = " + food);
							if (!food.isEmpty()) {
								for (SQLinitialisation ss : food) {
							%>

					<%
								}
							} else {

							out.println(":(");
							}
							%>
				</p>



			</div>
		</div>

		<%
			}
		}
		%>
		<%
			// 1. WEIGHTLOSE 2.NUTRITION 3.WEIGHTGAIN 4.RAPIDLOSE
		// 1.ENGLISH 2.ASIAN 3.VEG

		//CASE 1-3 START:
		if (plan.equalsIgnoreCase("nutrition")) {

			if (cuisine.equalsIgnoreCase("mixed")) {
		%>

	</div>
	<h1 class="text-white"></h1>
	<div class="text-white p-3">
		<p>

			<%
		            	food=SQL.food_table(days1, "veg_nut");
								out.println("food = " + food);
							if (!food.isEmpty()) {
								for (SQLinitialisation ss : food) {
							%>

			<%
								}
							} else {

							out.println(":(");
							}
							%>
		</p>
	</div>



	<%
		}
	}
	%>





















<%
							// 1. WEIGHTLOSE 2.NUTRITION 3.WEIGHTGAIN 4.RAPIDLOSE
						// 1.ENGLISH 2.ASIAN 3.VEG

						//CASE 3-1 START:
						if (plan.equalsIgnoreCase("weightgain")) {

							if (cuisine.equalsIgnoreCase("english")) {
							
						%>

					</div>
					<h1 class="text-white"></h1>
					<div class="text-white p-3">


						<p>

							<%
							food=SQL.food_table(days1, "eng_gain");
							//just printing th o/p from the method
								out.println("food = " + food);
							if (!food.isEmpty()) {
								for (SQLinitialisation ss : food) {
							%>

							<%
								}
							} else {

							out.println(":(");
							}
							%>
						</p>
					</div>

				</div>

				<%
					}
				}
				%>


				<%
					// 1. WEIGHTLOSE 2.NUTRITION 3.WEIGHTGAIN 4.RAPIDLOSE
				// 1.ENGLISH 2.ASIAN 3.VEG

				//CASE 1-2 START:
				if (plan.equalsIgnoreCase("weightgain")) {

					if (cuisine.equalsIgnoreCase("asian")) {
				%>

			</div>
			<h1 class="text-white"></h1>
			<div class="text-white p-3">
				<p>

					<%
							food=SQL.food_table(days1, "asian_gain");
								out.println("food = " + food);
							if (!food.isEmpty()) {
								for (SQLinitialisation ss : food) {
							%>

					<%
								}
							} else {

							out.println(":(");
							}
							%>
				</p>



			</div>
		</div>

		<%
			}
		}
		%>
		<%
			// 1. WEIGHTLOSE 2.NUTRITION 3.WEIGHTGAIN 4.RAPIDLOSE
		// 1.ENGLISH 2.ASIAN 3.VEG

		//CASE 1-3 START:
		if (plan.equalsIgnoreCase("weightgain")) {

			if (cuisine.equalsIgnoreCase("mixed")) {
		%>

	</div>
	<h1 class="text-white"></h1>
	<div class="text-white p-3">
		<p>

			<%
			food=SQL.food_table(days1, "veg_gain");
								out.println("food = " + food);
							if (!food.isEmpty()) {
								for (SQLinitialisation ss : food) {
							%>

			<%
								}
							} else {

							out.println(":(");
							}
							%>
		</p>
	</div>



	<%
		}
	}
	%>















<%
							// 1. WEIGHTLOSE 2.NUTRITION 3.WEIGHTGAIN 4.RAPIDLOSE
						// 1.ENGLISH 2.ASIAN 3.VEG

						//CASE 4-1 START:
						if (plan.equalsIgnoreCase("rapidlose")) {

							if (cuisine.equalsIgnoreCase("english")) {
							
						%>

					</div>
					<h1 class="text-white"></h1>
					<div class="text-white p-3">


						<p>

							<%
							food=SQL.food_table(days1, "eng_rapid");
							//just printing th o/p from the method
								out.println("food = " + food);
							if (!food.isEmpty()) {
								for (SQLinitialisation ss : food) {
							%>

							<%
								}
							} else {

							out.println(":(");
							}
							%>
						</p>
					</div>

				</div>

				<%
					}
				}
				%>


				<%
					// 1. WEIGHTLOSE 2.NUTRITION 3.WEIGHTGAIN 4.RAPIDLOSE
				// 1.ENGLISH 2.ASIAN 3.VEG

				//CASE 1-2 START:
				if (plan.equalsIgnoreCase("rapidlose")) {

					if (cuisine.equalsIgnoreCase("asian")) {
				%>

			</div>
			<h1 class="text-white"></h1>
			<div class="text-white p-3">
				<p>

					<%
							food=SQL.food_table(days1, "asian_rapid");
								out.println("food = " + food);
							if (!food.isEmpty()) {
								for (SQLinitialisation ss : food) {
							%>

					<%
								}
							} else {

							out.println(":(");
							}
							%>
				</p>



			</div>
		</div>

		<%
			}
		}
		%>
		<%
			// 1. WEIGHTLOSE 2.NUTRITION 3.WEIGHTGAIN 4.RAPIDLOSE
		// 1.ENGLISH 2.ASIAN 3.VEG

		//CASE 1-3 START:
		if (plan.equalsIgnoreCase("rapidlose")) {

			if (cuisine.equalsIgnoreCase("mixed")) {
		%>

	</div>
	<h1 class="text-white"></h1>
	<div class="text-white p-3">
		<p>

			<%
			food=SQL.food_table(days1, "veg_rapid");
								out.println("food = " + food);
							if (!food.isEmpty()) {
								for (SQLinitialisation ss : food) {
							%>

			<%
								}
							} else {

							out.println(":(");
							}
							%>
		</p>
	</div>



	<%
		}
	}
	%>

	<%-- <%

System.out.println(days1);

if (days1.equalsIgnoreCase("mon"))
{
	SQL.getenglish("mon");
	//SQL.getenglish(days1);
	
}


else
{
System.out.println("days1sorry elsee part");
}

%> --%>
	<br>

	<br>
</body>
</html>