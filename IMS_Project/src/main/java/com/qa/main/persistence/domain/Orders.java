package com.qa.main.persistence.domain;

import java.sql.Date;
import java.util.List;

public class Orders {
	
	private Long Order_id;
	private Long customer_ID;
	private List<Items> items;
	private Double Total;
	private Date date;
	
	
	
	



	public Orders(Long order_id, Long customer_ID, List<Items> items, Double total, Date date) {
		super();
		Order_id = order_id;
		this.customer_ID = customer_ID;
		this.items = items;
		Total = total;
		this.date = date;
	}

	
	public Long getCustomer_ID() {
		return customer_ID;
	}



	public void setCustomer_ID(Long customer_ID) {
		this.customer_ID = customer_ID;
	}
	
	
	


	public List<Items> getItems() {
		return items;
	}


	public void setItems(List<Items> items) {
		this.items = items;
	}


	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public void setTotal(Double total) {
		Total = total;
	}



	public Orders(double total) {
		super();
		Total = total;
	}



	public Orders(Long order_id, double total) {
		super();
		Order_id = order_id;
		Total = total;
	}



	public Long getOrder_id() {
		return Order_id;
	}



	public void setOrder_id(Long order_id) {
		Order_id = order_id;
	}



	public double getTotal() {
		return Total;
	}



	public void setTotal(double total) {
		Total = total;
	}
	
	

	
	public String toString() {
		return "Order id: "+Order_id + ", Customer ID: "+ customer_ID+", Order place on: "+ date+", Total: "+ Total;
}
	

}
