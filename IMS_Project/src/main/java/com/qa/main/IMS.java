package com.qa.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.main.controller.Action;
import com.qa.main.controller.CrudController;
import com.qa.main.controller.CustomerController;
import com.qa.main.controller.ItemController;
import com.qa.main.controller.OrderController;
import com.qa.main.persistence.dao.CustomerDAO1;
import com.qa.main.persistence.dao.ItemDAO1;
import com.qa.main.persistence.dao.OrderDAO1;
import com.qa.main.utils.DBUtils;
import com.qa.main.utils.Utils;

public class IMS {
	
	public static final Logger LOGGER = LogManager.getLogger();

	private final CustomerController customers;
	private final ItemController items;
	private final Utils utils;
	private final OrderController orders;

	public IMS() {
		this.utils = new Utils();
		final CustomerDAO1 custDAO = new CustomerDAO1();
		final ItemDAO1 itemDAO = new ItemDAO1();
		final OrderDAO1 orderDAO = new OrderDAO1();
		this.customers = new CustomerController(custDAO, utils);
		this.items = new ItemController(itemDAO, utils);
		this.orders = new OrderController(orderDAO, utils, custDAO, itemDAO);
		
	}

	public void imsSystem() {
		LOGGER.info("What is your username");
		String username = utils.getString();
		LOGGER.info("What is your password");
		String password = utils.getString();

		DBUtils.connect(username, password);
		Domain domain = null;
		do {
			LOGGER.info("Which entity would you like to use?");
			Domain.printDomains();

			domain = Domain.getDomain(utils);
			boolean changeDomain = false;
			do {

				CrudController<?> active = null;
				switch (domain) {
				case CUSTOMER:
					active = this.customers;
					break;
				case ITEM:
					active = null;
					break;
				case ORDER:
					active = null;
					break;
				case STOP:
					return;
				default:
					break;
				}

				LOGGER.info("What would you like to do with " + domain.name().toLowerCase() + ":");

				Action.printActions();
				Action action = Action.getAction(utils);

				if (action == Action.RETURN) {
					changeDomain = true;
				} else {
					doAction(active, action);
				}
			} while (!changeDomain);
		} while (domain != Domain.STOP);
	}

	public void doAction(CrudController<?> crudController, Action action) {
		switch (action) {
		case CREATE:
			crudController.create();
			break;
		case READ:
			crudController.readAll();
			break;
		case UPDATE:
			crudController.update();
			break;
		case DELETE:
			crudController.delete();
			break;
		case RETURN:
			break;
		default:
			break;
		}
	}
	
		

}
