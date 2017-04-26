package com.trade.database.api.response;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GetOrderDetailResponse {
	private String token;
	private String status;
	private Order order;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public class Order {
		
		private String address;
		private String userName;
		private double totalPrice;
		private List<OrderProduct> products = new ArrayList<OrderProduct>();
		
		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public double getTotalPrice() {
			return totalPrice;
		}

		public void setTotalPrice(double totalPrice) {
			this.totalPrice = totalPrice;
		}

		public List<OrderProduct> getProducts() {
			return products;
		}

		public class OrderProduct {
			private int id;
			private double quantity;
			private Date datetime;
			private List<Status> status = new ArrayList<Status>();
			private double price;

			public double getQuantity() {
				return quantity;
			}

			public void setQuantity(double quantity) {
				this.quantity = quantity;
			}

			public List<Status> getStatus() {
				return status;
			}

			public int getId() {
				return id;
			}

			public void setId(int id) {
				this.id = id;
			}

			public Date getDatetime() {
				return datetime;
			}

			public void setDatetime(Date datetime) {
				this.datetime = datetime;
			}

			public double getPrice() {
				return price;
			}

			public void setPrice(double price) {
				this.price = price;
			}

			public class Status {
				private String status;
				private Date statusTime;

				public String getStatus() {
					return status;
				}

				public void setStatus(String status) {
					this.status = status;
				}

				public Date getStatusTime() {
					return statusTime;
				}

				public void setStatusTime(Date statusTime) {
					this.statusTime = statusTime;
				}

			}
		}
		
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
