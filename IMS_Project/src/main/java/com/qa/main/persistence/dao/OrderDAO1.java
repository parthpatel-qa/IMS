package com.qa.main.persistence.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.main.persistence.domain.Items;
import com.qa.main.persistence.domain.Orders;
import com.qa.main.utils.DBUtils;

public class OrderDAO1 implements DAO<Orders> {

	public static final Logger LOGGER = LogManager.getLogger();
	ItemDAO1 itemDAO = new ItemDAO1();
	
	@Override
	public List<Orders> readAll() {
		try( Connection connection = DBUtils.getInstance().getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("Select * FROM Orders");){
				List<Orders> orders = new ArrayList<>();
				while (resultSet.next()) {
					orders.add(modelFromResultSet(resultSet));
				}
				return orders;
			} catch (SQLException e) {
				LOGGER.debug(e);
				LOGGER.error(e.getMessage());
			}
		return new ArrayList<>();
	}

	@Override
	public Orders create(Orders orders) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("INSERT INTO Orders(customer_ID, date_placed, total) values('" + orders.getCustomer_ID()
					+ "','" + orders.getDate() + "," +orders.getTotal() + "')");
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public Orders readOrders(Long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM Orders where order_ID = " + id);) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	@Override
	public Orders update(Orders orders) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) {
				statement.executeUpdate("update Orders set customer_ID ='" + orders.getCustomer_ID() + "', dateplaced ='"
					+ orders.getDate() +  "', total ='"
					+ orders.getTotal());
			return readOrders(orders.getOrder_id());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public int delete(Long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) {
			return statement.executeUpdate("delete from Orders where order_ID = " + id);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

	@Override
	public Orders modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long oid = resultSet.getLong("order_ID");
		Long cid = resultSet.getLong("customer_ID");
		List<Items> items = readLines(resultSet.getLong("item_ID"));
		for(Items item: items) {
			item.setQuantity(1L);
		}
		Double total = resultSet.getDouble("total");
		Date date = resultSet.getDate("date");
	
	return new Orders(oid, cid, items, total, date);
	}
	
	public List<Items> readLines(Long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orderline where order_ID = " + id);) {
			List<Items> items = new ArrayList<Items>();
			while (resultSet.next()) {
				items.add(itemDAO.readItem(resultSet.getLong("item_ID")));
			}
			return items;
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	public Orders readLatest() {
		try( Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM Orders ORDER BY order_ID DESC LIMIT 1");){
			resultSet.next();
			return modelFromResultSet(resultSet);
		}catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
		
	}

}
