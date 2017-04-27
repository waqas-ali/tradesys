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
	public GetProductResponse getProductsByCategory(@RequestBody String token, @RequestBody int category, @RequestBody int page) {
		GetProductResponse response = new GetProductResponse();
		try {
			List<Product> products = dao.getAll();
			List<GetProductResponse.ProductModel> list = response.getProducts();
			for (Product prod : products) {
				GetProductResponse.ProductModel product = response.new ProductModel();
				product.setDescription(prod.getDescription());
				product.setId(prod.getId());
				product.setName(prod.getProdName());
				
				Set<Pricesslot> prices = prod.getPricesslots();
				Iterator<Pricesslot> iterator = prices.iterator();			
				while ( iterator.hasNext()) {
					Pricesslot slot = iterator.next();
					GetProductResponse.ProductModel.Prices pr = product. new Prices();
					pr.setMinOrder(slot.getMinOrder());
					pr.setPrice(slot.getPrice());
					product.getPrices().add(pr);
				}
				Set<Productpicture> pictures = prod.getProductpictures();
				Iterator<Productpicture> it = pictures.iterator();
				while ( it.hasNext()) {
					Productpicture pic = it.next();
					GetProductResponse.ProductModel.Image img = product. new Image();
					img.setUrl(pic.getPicture());
					product.getImages().add(img);
				}
				GetProductResponse.ProductModel.Producer producer = product. new Producer();
				producer.setUserId(prod.getUser().getId());
				producer.setUserName(prod.getUser().getUserName());
				product.setProducer(producer);
				list.add(product);
			}
		} catch (Exception e) {
		}
		return response;
	}
	
	@RequestMapping(value = "/get/home", method = RequestMethod.POST)
	public GetProductResponse getProducts(@RequestBody String token, @RequestBody int page) {
		GetProductResponse response = new GetProductResponse();
		try {
			List<Product> products = dao.getAll();
			List<GetProductResponse.ProductModel> list = response.getProducts();
			for (Product prod : products) {
				GetProductResponse.ProductModel product = response.new ProductModel();
				product.setDescription(prod.getDescription());
				product.setId(prod.getId());
				product.setName(prod.getProdName());
				
				Set<Pricesslot> prices = prod.getPricesslots();
				Iterator<Pricesslot> iterator = prices.iterator();			
				while ( iterator.hasNext()) {
					Pricesslot slot = iterator.next();
					GetProductResponse.ProductModel.Prices pr = product. new Prices();
					pr.setMinOrder(slot.getMinOrder());
					pr.setPrice(slot.getPrice());
					product.getPrices().add(pr);
				}
				Set<Productpicture> pictures = prod.getProductpictures();
				Iterator<Productpicture> it = pictures.iterator();
				while ( it.hasNext()) {
					Productpicture pic = it.next();
					GetProductResponse.ProductModel.Image img = product. new Image();
					img.setUrl(pic.getPicture());
					product.getImages().add(img);
				}
				GetProductResponse.ProductModel.Producer producer = product. new Producer();
				producer.setUserId(prod.getUser().getId());
				producer.setUserName(prod.getUser().getUserName());
				producer.setUserName("need to fetch from user");
				product.setProducer(producer);
				list.add(product);
			}
		} catch (Exception e) {
		}
		return response;
	}

	@RequestMapping(value = "/get/producer", method = RequestMethod.POST)
	public GetProductResponse getProductsByProducer(@RequestBody String token, @RequestBody int userId, @RequestBody int page) {
		GetProductResponse response = new GetProductResponse();
		try {
			List<Product> products = dao.getAll();
			List<GetProductResponse.ProductModel> list = response.getProducts();
			for (Product prod : products) {
				GetProductResponse.ProductModel product = response.new ProductModel();
				product.setDescription(prod.getDescription());
				product.setId(prod.getId());
				product.setName(prod.getProdName());
				
				Set<Pricesslot> prices = prod.getPricesslots();
				Iterator<Pricesslot> iterator = prices.iterator();			
				while ( iterator.hasNext()) {
					Pricesslot slot = iterator.next();
					GetProductResponse.ProductModel.Prices pr = product. new Prices();
					pr.setMinOrder(slot.getMinOrder());
					pr.setPrice(slot.getPrice());
					product.getPrices().add(pr);
				}
				Set<Productpicture> pictures = prod.getProductpictures();
				Iterator<Productpicture> it = pictures.iterator();
				while ( it.hasNext()) {
					Productpicture pic = it.next();
					GetProductResponse.ProductModel.Image img = product. new Image();
					img.setUrl(pic.getPicture());
					product.getImages().add(img);
				}
				GetProductResponse.ProductModel.Producer producer = product. new Producer();
				producer.setUserId(prod.getUser().getId());
				producer.setUserName(prod.getUser().getUserName());
				product.setProducer(producer);
				list.add(product);
			}
		} catch (Exception e) {
		}
		return response;
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public GetProductResponse getProductsByCriteria(@RequestBody String token, @RequestBody String keyword, @RequestBody int page) {
		GetProductResponse response = new GetProductResponse();
		try {
			List<Product> products = dao.getAll();
			List<GetProductResponse.ProductModel> list = response.getProducts();
			for (Product prod : products) {
				GetProductResponse.ProductModel product = response.new ProductModel();
				product.setDescription(prod.getDescription());
				product.setId(prod.getId());
				product.setName(prod.getProdName());
				
				Set<Pricesslot> prices = prod.getPricesslots();
				Iterator<Pricesslot> iterator = prices.iterator();			
				while ( iterator.hasNext()) {
					Pricesslot slot = iterator.next();
					GetProductResponse.ProductModel.Prices pr = product. new Prices();
					pr.setMinOrder(slot.getMinOrder());
					pr.setPrice(slot.getPrice());
					product.getPrices().add(pr);
				}
				Set<Productpicture> pictures = prod.getProductpictures();
				Iterator<Productpicture> it = pictures.iterator();
				while ( it.hasNext()) {
					Productpicture pic = it.next();
					GetProductResponse.ProductModel.Image img = product. new Image();
					img.setUrl(pic.getPicture());
					product.getImages().add(img);
				}
				GetProductResponse.ProductModel.Producer producer = product. new Producer();
				producer.setUserId(prod.getUser().getId());
				producer.setUserName(prod.getUser().getUserName());
				product.setProducer(producer);
				list.add(product);
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
