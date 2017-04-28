package com.trade.database.service;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.trade.database.api.request.AddUpdateProduct;
import com.trade.database.api.request.GetProductBy;
import com.trade.database.api.response.AddUpdateResponse;
import com.trade.database.api.response.GetProductDetailResponse;
import com.trade.database.api.response.GetProductResponse;
import com.trade.database.dao.ProductDAO;
import com.trade.database.entitymapper.ProductEntityMapper;
import com.trade.database.pojo.Pricesslot;
import com.trade.database.pojo.Product;
import com.trade.database.pojo.Productpicture;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/product")
public class ProductService {
	@Autowired
	private ProductDAO dao;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ApiOperation(value = "Add new Product", notes = "Add new Product")
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Fields are with validation errors"),
			@ApiResponse(code = 201, message = "") })
	public AddUpdateResponse addProduct(@RequestBody AddUpdateProduct dto) {
		AddUpdateResponse response = new AddUpdateResponse();
		response.setStatus("600");
		try {
			ProductEntityMapper mapper = new ProductEntityMapper();
			Product product = mapper.convertToEntity(dto);
			dao.create(product);
			response.setStatus("200");
			response.setToken("");
		} catch (Exception e) {

		}
		return response;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ApiOperation(value = "Update Product", notes = "Update Product")
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Fields are with validation errors"),
			@ApiResponse(code = 201, message = "") })
	public AddUpdateResponse updateProduct(@RequestBody AddUpdateProduct dto) {
		AddUpdateResponse response = new AddUpdateResponse();
		try {
			ProductEntityMapper mapper = new ProductEntityMapper();
			Product product = mapper.convertToEntity(dto);
			dao.create(product);
			response.setStatus("200");
		} catch (Exception e) {

		}
		return response;
	}

	@RequestMapping(value = "/get/category", method = RequestMethod.POST)
	public GetProductResponse getProductsByCategory(@RequestBody GetProductBy dto) {
		GetProductResponse response = new GetProductResponse();
		try {
			List<Product> products = dao.getByCategory(dto.getCategoryId());
			for (Product product : products) {
				ProductEntityMapper mapper = new ProductEntityMapper();
				GetProductResponse.ProductModel model = mapper.convertFromEntity(product); 
				response.getProducts().add(model);
			}
			
		} catch (Exception e) {
		}
		return response;
	}
	
	@RequestMapping(value = "/get/home", method = RequestMethod.POST)
	public GetProductResponse getProducts(@RequestBody GetProductBy dto) {
		GetProductResponse response = new GetProductResponse();
		try {
			List<Product> products = dao.getAll();
			for (Product product : products) {
				ProductEntityMapper mapper = new ProductEntityMapper();
				GetProductResponse.ProductModel model = mapper.convertFromEntity(product); 
				response.getProducts().add(model);
			}
			
		} catch (Exception e) {
		}
		return response;
	}

	@RequestMapping(value = "/get/producer", method = RequestMethod.POST)
	public GetProductResponse getProductsByProducer(@RequestBody GetProductBy dto) {
		GetProductResponse response = new GetProductResponse();
		try {
			List<Product> products = dao.getByProducer(dto.getProducerId());
			for (Product product : products) {
				ProductEntityMapper mapper = new ProductEntityMapper();
				GetProductResponse.ProductModel model = mapper.convertFromEntity(product); 
				response.getProducts().add(model);
			}
			
		} catch (Exception e) {
		}
		return response;
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public GetProductResponse getProductsByCriteria(@RequestBody GetProductBy dto) {
		GetProductResponse response = new GetProductResponse();
		try {
			List<Product> products = dao.getByCriteria(dto.getKeyword());
			for (Product product : products) {
				ProductEntityMapper mapper = new ProductEntityMapper();
				GetProductResponse.ProductModel model = mapper.convertFromEntity(product); 
				response.getProducts().add(model);
			}
			
		} catch (Exception e) {
		}
		return response;
	}
	@RequestMapping(value = "/details", method = RequestMethod.POST)
	public GetProductDetailResponse getProductDetails() {
		GetProductDetailResponse response = new GetProductDetailResponse();
		try {
			Product prod = dao.getProductDetail(1);
			GetProductDetailResponse.Product product = response.new Product();
			product.setDescription(prod.getDescription());
			product.setName(prod.getProdName());
			Set<Pricesslot> prices = prod.getPricesslots();
			Iterator<Pricesslot> iterator = prices.iterator();			
			while ( iterator.hasNext()) {
				Pricesslot slot = iterator.next();
				GetProductDetailResponse.Product.Prices pr = product. new Prices();
				pr.setMinOrder(slot.getMinOrder());
				pr.setPrice(slot.getPrice());
				product.getPrices().add(pr);
			}
			Set<Productpicture> pictures = prod.getProductpictures();
			Iterator<Productpicture> it = pictures.iterator();
			while ( it.hasNext()) {
				Productpicture pic = it.next();
				GetProductDetailResponse.Product.Image img = product. new Image();
				img.setUrl(pic.getPicture());
				product.getImages().add(img);
			}
			response.setProduct(product);
		} catch (Exception e) {

		}
		return response;
	}
}
