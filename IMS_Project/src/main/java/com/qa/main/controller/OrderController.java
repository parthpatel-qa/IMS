package com.qa.main.controller;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Order;

import com.qa.main.persistence.dao.CustomerDAO1;
import com.qa.main.persistence.dao.ItemDAO1;
import com.qa.main.persistence.dao.OrderDAO1;
import com.qa.main.persistence.domain.Customer;
import com.qa.main.persistence.domain.Orders;
import com.qa.main.utils.Utils;

public class OrderController implements CrudController<Orders> {
	
	public static final Logger LOGGER = LogManager.getLogger();
	

	private OrderDAO1 orderDAO;
	private Utils utils;
	private CustomerDAO1 customerDAO;
	private ItemDAO1 itemDAO;
	
	
	public OrderController(OrderDAO1 orderDAO, Utils utils, CustomerDAO1 customerDAO, ItemDAO1 itemDAO) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
		this.customerDAO = customerDAO;
		this.itemDAO = itemDAO;
	}

	@Override
	public List<Orders> readAll() {
		List<Orders> orders = orderDAO.readAll();
		for (Orders order : orders) {
			LOGGER.info(order.toString());
		}
		return orders;
	}

	@Override
	public Orders create() {
		List<Customer> customers = customerDAO.readAll();
		for (Customer customer : customers) {
			LOGGER.info(customer.toString());
		}
		LOGGER.info("To create an order, you will need a customer. Please enter a customer ID");
		long customer_ID = utils.getLong();
		Orders order = orderDAO.create(new Orders(customer_ID));
		LOGGER.info("Order created");
		return order;
	}
	

	@Override
	public Orders update() {
		LOGGER.info("Please enter the Order id: ");
		Long orderid = utils.getLong();
		LOGGER.info("Please enter the customer id: ");
		Long cust_id = utils.getLong();
		LOGGER.info("Please enter the date this order was made (YYYY-MM-DD): ");
		Date date = utils.getDate();
		Orders order = orderDAO.update(new Orders(orderid, cust_id, null, null, date));
		return order;
	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the Order id of the order you would like to delete");
		Long orderid = utils.getLong();
		return orderDAO.delete(orderid);
	}
	
	
	
}
