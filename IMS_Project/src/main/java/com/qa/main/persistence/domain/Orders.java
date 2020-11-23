package com.qa.main.persistence.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Orders {
	
	private int Order_id=0;
	private int customer_ID;
	private double Total;
	
	
	
	
	public Orders(double total) {
		super();
		Total = total;
	}



	public Orders(int order_id, double total) {
		super();
		Order_id = order_id;
		Total = total;
	}



	public int getOrder_id() {
		return Order_id;
	}



	public void setOrder_id(int order_id) {
		Order_id = order_id;
	}



	public double getTotal() {
		return Total;
	}



	public void setTotal(double total) {
		Total = total;
	}
	
	
	public static Orders convert (ResultSet rs) throws SQLException {
		if (rs.next()) {
			int Order_id = rs.getInt("Order id");
			double total = rs.getDouble("total");
			return new Orders(Order_id, total);
		}
		return null;
	}
	public String toString() {
		return "Order id: "+Order_id + ", Total: "+ Total;
}
	

}
