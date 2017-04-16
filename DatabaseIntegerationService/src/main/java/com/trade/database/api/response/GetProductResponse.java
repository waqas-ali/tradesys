package com.trade.database.api.response;

import java.util.ArrayList;
import java.util.List;

public class GetProductResponse {
	private String token;
	private String status;
	private List<Product> products = new ArrayList<Product>();
	
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

	public List<Product> getProducts() {
		return products;
	}

	public class Product {
		private String product;
		private int id;
		private String description;
		private List<Image> images = new ArrayList<Image>();
		private List<Prices> prices = new ArrayList<Prices>();
		
		public List<Prices> getPrices() {
			return prices;
		}

		public List<Image> getImages() {
			return images;
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
		public String getProduct() {
			return product;
		}
		public void setProduct(String product) {
			this.product = product;
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
