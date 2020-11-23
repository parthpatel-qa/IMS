package com.qa.main.persistence.domain;

public class Items {
	
	private Long Item_id;
	private String item;
	private int Quantity;
	private double Price;
	
	//constructors
	
	public Items(String item_name, int quantity, double price) {
		super();
		item = item_name;
		Quantity = quantity;
		Price = price;
	}



	public Items(Long item_id, String item_name, int quantity, double price) {
		super();
		Item_id = item_id;
		item = item_name;
		Quantity = quantity;
		Price = price;
	}


	//getter and setters
	
	public Long getItem_id() {
		return Item_id;
	}



	public void setItem_id(Long item_id) {
		Item_id = item_id;
	}



	public String getItem_name() {
		return item;
	}



	public void setItem_name(String item_name) {
		item = item_name;
	}



	public int getQuantity() {
		return Quantity;
	}



	public void setQuantity(int quantity) {
		Quantity = quantity;
	}



	public double getPrice() {
		return Price;
	}



	public void setPrice(double price) {
		Price = price;
	}
	
	
	@Override
	public String toString() {
		return "Item id: "+Item_id + ", Item: "+ item+", Price: "+Price +", Quantity: "+ Quantity;
}
	

	
	
	

}
