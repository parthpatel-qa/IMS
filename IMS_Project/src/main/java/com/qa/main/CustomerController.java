package com.qa.main;

import java.util.List;
import java.util.Scanner;

public class CustomerController implements CrudController<Customer>{
	
	Scanner scan = new Scanner(System.in);
	CustomerDAO customerDAO = new CustomerDAO();

	public List<Customer> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Customer read() {
		// TODO Auto-generated method stub
		return null;
	}

	public Customer create() {
		System.out.println("What is the customers name?");
		String customer_name = scan.nextLine();
		System.out.println("What is the customers email?");
		String email = scan.nextLine();
		System.out.println("What is the customers chosen password?");
		String password = scan.nextLine();
		customerDAO.create(new Customer(customer_name, email, password));
		return null;
		
	}

	public Customer update() {
		System.out.println("What is the customer ID?");
		int id = scan.nextInt();
		scan.nextLine();
		System.out.println("What is the customers name?");
		String customer_name = scan.nextLine();
		System.out.println("What is the customers email?");
		String email = scan.nextLine();
		System.out.println("What is the customers chosen password?");
		String password = scan.nextLine();
		customerDAO.update(id, new Customer(customer_name, email, password));
		return null;
	}

	public int delete() {
		
		return 0;
	}
	

	
	

}
