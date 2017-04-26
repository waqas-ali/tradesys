package com.trade.database.api.request;

import java.util.ArrayList;
import java.util.List;

public class AddUpdateOrder {
	private String token;
	private String address;
	private int orderId;
	private double price;
	private List<OrderProduct> product = new ArrayList<OrderProduct>();

	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<OrderProduct> getProduct() {
		return product;
	}

	public void setProduct(List<OrderProduct> product) {
		this.product = product;
	}

	public static class OrderProduct {
		private int quantity;
		private double price;
		private int id;
		
		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}


	}

	public class Image {
		private String url;

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

	}

	public class Prices {
		private double price;
		private double minOrder;

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public double getMinOrder() {
			return minOrder;
		}

		public void setMinOrder(double minOrder) {
			this.minOrder = minOrder;
		}
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
