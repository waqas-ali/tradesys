package com.trade.database.api.response;

import java.util.ArrayList;
import java.util.List;

public class GetProductResponse {
	private String token;
	private String status;
	private List<ProductModel> products = new ArrayList<ProductModel>();
	
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

	public List<ProductModel> getProducts() {
		return products;
	}

	public class ProductModel {
		private String name;
		private int id;
		private String description;
		private List<Image> images = new ArrayList<Image>();
		private List<Prices> prices = new ArrayList<Prices>();
		private Producer producer;
		
		
		public Producer getProducer() {
			return producer;
		}

		public void setProducer(Producer producer) {
			this.producer = producer;
		}

		public List<Prices> getPrices() {
			return prices;
		}

		public List<Image> getImages() {
			return images;
		}

		public class Producer {
			private String userName;
			private int userId;
			public String getUserName() {
				return userName;
			}
			public void setUserName(String userName) {
				this.userName = userName;
			}
			public int getUserId() {
				return userId;
			}
			public void setUserId(int userId) {
				this.userId = userId;
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
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		
		
	}
	
	
}
