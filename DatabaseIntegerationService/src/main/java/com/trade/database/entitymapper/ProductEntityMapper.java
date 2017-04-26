package com.trade.database.entitymapper;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.trade.database.api.request.AddUpdateProduct;
import com.trade.database.api.response.GetProductResponse;
import com.trade.database.api.response.UserDetail;
import com.trade.database.pojo.Pricesslot;
import com.trade.database.pojo.Product;
import com.trade.database.pojo.Productpicture;
import com.trade.database.pojo.Userprofile;

public class ProductEntityMapper {
	public Product convertToEntity(AddUpdateProduct dto) {
		Product product = new Product();
		List<AddUpdateProduct.Image> images = dto.getImages();
		List<AddUpdateProduct.Prices> prices = dto.getPrices();
		
		Set<Productpicture> pictures = new HashSet<Productpicture>();
		for (AddUpdateProduct.Image img: images) {
			Productpicture picture = new Productpicture();
			picture.setPicture(img.getUrl());
			picture.setProduct(product);
			pictures.add(picture);
		}
		Set<Pricesslot> pricesslots = new HashSet<Pricesslot>();
		for (AddUpdateProduct.Prices price: prices) {
			Pricesslot slot = new Pricesslot();
			slot.setMinOrder(price.getMinOrder());
			slot.setPrice(price.getPrice());
			slot.setProduct(product);
			pricesslots.add(slot);
		}
		
		product.setDescription(dto.getDescription());
		product.setProdName(dto.getName());
		product.setQuantity(dto.getQuantity());
		product.setPricesslots(pricesslots);
		product.setProductpictures(pictures);
		return product;
	}
	
	public GetProductResponse.ProductModel convertFromEntity(Product product ) {
		GetProductResponse.ProductModel model = new GetProductResponse().new ProductModel();
		
		return model;
		
	}
}
