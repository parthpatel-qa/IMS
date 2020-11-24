package com.qa.main.controller;

import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.main.persistence.dao.ItemDAO1;
import com.qa.main.persistence.domain.Items;
import com.qa.main.utils.Utils;

public class ItemController implements CrudController<Items> {
	
	public static final Logger LOGGER = LogManager.getLogger();

	private Utils utils;

	private ItemDAO1 itemDAO;
	Scanner scan = new Scanner(System.in);




	public ItemController(ItemDAO1 itemDAO, Utils utils) {
		super();
		this.setItemDAO(itemDAO);
		this.utils = utils;
	}

	@Override
	public List<Items> readAll() {
		List<Items> items = getItemDAO().readAll();
		for (Items customer : items) {
			LOGGER.info(customer.toString());
		}
		return items;
	}

	@Override
	public Items create() {
		LOGGER.info("Please enter an item name");
		String name = utils.getString();
		LOGGER.info("Please enter a quantity");
		Long quantity = utils.getLong();
		LOGGER.info("Please enter a price");
		Double price = utils.getDouble();
		Items items = getItemDAO().create(new Items(name, quantity, price));
		LOGGER.info("Item created");
		return items;
	}

	@Override
	public Items update() {
		LOGGER.info("Please enter the id of the item you would like to update");
		Long id = utils.getLong();
		LOGGER.info("Please enter the name of the item");
		String name = utils.getString();
		LOGGER.info("Please enter the quantity of the item");
		Long quantity = utils.getLong();
		LOGGER.info("Please enter the price of this item");
		Long price = utils.getLong();
		Items items = itemDAO.update(new Items(id, name, quantity, price));
		LOGGER.info("Item Updated");
		return items;
	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the item you would like to delete");
		Long id = utils.getLong();
		return itemDAO.delete(id);
	}


	public ItemDAO1 getItemDAO() {
		return itemDAO;
	}

	public void setItemDAO(ItemDAO1 itemDAO) {
		this.itemDAO = itemDAO;
	}

}
