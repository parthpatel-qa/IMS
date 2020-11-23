package com.qa.main.controller;

import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.main.persistence.dao.CustomerDAO1;
import com.qa.main.persistence.domain.Customer;
import com.qa.main.utils.Utils;

public class CustomerController implements CrudController<Customer>{
	
	public static final Logger LOGGER = LogManager.getLogger();

	private CustomerDAO1 customerDAO;
	private Utils utils;

	public CustomerController(CustomerDAO1 customerDAO, Utils utils) {
		super();
		this.customerDAO = customerDAO;
		this.utils = utils;
	}
	


	public ArrayList<Customer> readAll() {
		ArrayList<Customer> customers = (ArrayList<Customer>) customerDAO.readAll();
		for (Customer customer : customers) {
			LOGGER.info(customer.toString());
		}
		return customers;
		
	}


	public Customer create() {
		LOGGER.info("Please enter a name");
		String customer_name = utils.getString();
		LOGGER.info("Please enter an email");
		String email = utils.getString();
		LOGGER.info("Please enter a changeable password for the new customer");
		String password = utils.getString();
		Customer customer = customerDAO.create(new Customer(customer_name, email, password));
		LOGGER.info("Customer created");
		return customer;
		
	}

	public Customer update() {
			LOGGER.info("Please enter the id of the customer you would like to update");
			Long id = utils.getLong();
			LOGGER.info("Please enter a new name");
			String customer_name = utils.getString();
			LOGGER.info("Please enter a new email");
			String email = utils.getString();
			LOGGER.info("Please enter a new password");
			String password = utils.getString();
			Customer customer = customerDAO.update(new Customer(id, customer_name, email, password));
			LOGGER.info("Customer Updated");
			return customer;
	}

	public int delete() {
		LOGGER.info("Please enter the id of the customer you would like to delete");
		Long customer_id = utils.getLong();
		return customerDAO.delete(customer_id);
	}





	
	

}
