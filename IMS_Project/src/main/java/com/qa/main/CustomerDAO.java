package com.qa.main;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO {
	
	private static IMSConnection DbInstance;
	
	public CustomerDAO() {
		DbInstance = IMSConnection.connect("root", "root");
		}

	// CRUD
	// create
	public void create(Customer customer) {
		String name = customer.getCustomer_name();
		String email = customer.getEmail();
		String pass = customer.getPassword();
		String query = String.format("INSERT INTO Customers(`customer_name`, `email`, `password`) VALUES ('%s, '%s');", name, email, pass); 
		try {
			DbInstance.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Could not create please try again");
			e.printStackTrace();
		}
	}
	
	//update by id
	public void update(int id, Customer cus) {
		String query = String.format("Update Customers set customer_name = '%s', email = '%s', password = '%s' WHERE customer_ID = '%d'", cus.getCustomer_name(), cus.getEmail(), cus.getPassword(), id);
		try {
			DbInstance.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Could not update, please try again");
			e.printStackTrace();
		}
	}
	//delete by id
	public void delete(int id) {
		String query = String.format("DELETE FROM Customers WHERE customer_ID= '%d'", id);
		try {
			DbInstance.executeUpdate(query);
		} catch (SQLException e) {
		System.out.println("Could not delete, please try again");
			e.printStackTrace();
		}
	}
	
	
	
	//READ by ID
	public ResultSet read(int id) {
		String query = "Select * FROM Customers WHERE customer_ID =  "+id;
		ResultSet rs = null;
		try {
			rs = DbInstance.executeQuery(query);
		} catch (SQLException e) {
			System.out.println("Unreadable query!!!");
			e.printStackTrace();
		}
		return rs;
	}
	//READ all from db
	public ResultSet readAll() {
		String query = "Select * FROM Customers";
		ResultSet rs = null;
		try {
			rs = DbInstance.executeQuery(query);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return rs;
	}
	
	
	 
	
}
