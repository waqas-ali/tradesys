package com.trade.database.entitymapper;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.trade.database.api.request.AddUpdateProduct;
import com.trade.database.api.response.GetProductResponse;
import com.trade.database.api.response.GetProductResponse.ProductModel;
import com.trade.database.api.response.GetProductResponse.ProductModel.Image;
import com.trade.database.api.response.GetProductResponse.ProductModel.Prices;
import com.trade.database.api.response.GetProductResponse.ProductModel.Producer;
import com.trade.database.pojo.Category;
import com.trade.database.pojo.Pricesslot;
import com.trade.database.pojo.Product;
import com.trade.database.pojo.Productpicture;
import com.trade.database.pojo.Status;
import com.trade.database.pojo.User;

public class ProductEntityMapper {
	public Product convertToEntity(AddUpdateProduct dto) {
		Product product = new Product();
		List<AddUpdateProduct.Image> images = dto.getImages();
		List<AddUpdateProduct.Prices> prices = dto.getPrices();
		
		for (AddUpdateProduct.Image img: images) {
			Productpicture picture = new Productpicture();
			picture.setPicture(img.getUrl());
			picture.setProduct(product);
			product.getProductpictures().add(picture);
		}
		
		for (AddUpdateProduct.Prices price: prices) {
			Pricesslot slot = new Pricesslot();
			slot.setMinOrder(price.getMinOrder());
			slot.setPrice(price.getPrice());
			slot.setProduct(product);
			product.getPricesslots().add(slot);
		}
		
		product.setDescription(dto.getDescription());
		product.setProdName(dto.getName());
		product.setQuantity(dto.getQuantity());
		User user = new User();
		user.setId(Integer.parseInt(dto.getToken()));
		product.setUser(user);
		Category category = new Category();
		category.setId(dto.getCategoryId());
		product.setCategory(category);
		Status status = new Status();
		status.setId(1);
		product.setStatus(status);
		
		return product;
	}
	
	public GetProductResponse.ProductModel convertFromEntity(Product product ) {
		GetProductResponse.ProductModel model = new GetProductResponse().new ProductModel();
		
		model.setDescription(product.getDescription());
		model.setId(product.getId());
		model.setName(product.getProdName());
		
		Set<Pricesslot> prices = product.getPricesslots();
		Iterator<Pricesslot> iterator = prices.iterator();			
		while ( iterator.hasNext()) {
			Pricesslot slot = iterator.next();
			GetProductResponse.ProductModel.Prices pr = model. new Prices();
			pr.setMinOrder(slot.getMinOrder());
			pr.setPrice(slot.getPrice());
			model.getPrices().add(pr);
		}
		Set<Productpicture> pictures = product.getProductpictures();
		Iterator<Productpicture> it = pictures.iterator();
		while ( it.hasNext()) {
			Productpicture pic = it.next();
			GetProductResponse.ProductModel.Image img = model. new Image();
			img.setUrl(pic.getPicture());
			model.getImages().add(img);
		}
		GetProductResponse.ProductModel.Producer producer = model. new Producer();
		producer.setUserId(product.getUser().getId());
		producer.setUserName(product.getUser().getUserName());
		model.setProducer(producer);
		return model;
		
	}
}
