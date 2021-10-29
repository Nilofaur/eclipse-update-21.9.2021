package com.demo.spring.paypal.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
//import na.ecomm.connection.ppServlet;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {

	private double price;
	private String currency;
	private String method;
	private String intent;
	private String description;
	//public double sum= ppServlet.sum;
	
}