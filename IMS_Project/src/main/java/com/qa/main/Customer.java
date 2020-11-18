package com.qa.main;

public class Customer {
	
	//database fields as variables
	private int customer_ID = 0;
	private String customer_name;
	private String email;
	private String password;
	
	//constructors
	public Customer(String customer_name, String email, String password) {
		super();
		this.customer_name = customer_name;
		this.email = email;
		this.password = password;
	}
	public Customer(int customer_ID, String customer_name, String email, String password) {
		super();
		this.customer_ID = customer_ID;
		this.customer_name = customer_name;
		this.email = email;
		this.password = password;
	}
	//getters and setters
	public int getCustomer_ID() {
		return customer_ID;
	}
	public void setCustomer_ID(int customer_ID) {
		this.customer_ID = customer_ID;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
