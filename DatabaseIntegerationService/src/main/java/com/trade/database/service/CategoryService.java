package com.trade.database.service;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.Date;
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
import com.trade.database.api.response.GetProductResponse;
import com.trade.database.dao.ProductDAO;
import com.trade.database.pojo.Pricesslot;
import com.trade.database.pojo.Product;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/category")
public class CategoryService {
	@Autowired
	private ProductDAO dao;

	@RequestMapping(value = "/addcategory", method = RequestMethod.POST)
	@ApiOperation(value = "Add new Product", notes = "Add new Product")
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Fields are with validation errors"),
			@ApiResponse(code = 201, message = "") })
	public AddUpdateResponse addProduct(@RequestBody AddUpdateProduct request) {
		AddUpdateResponse response = new AddUpdateResponse();
		response.setStatus("600");
		try {
			Product product = new Product();
			product.setProdName(request.getName());
			//product.setUserId(1);
			product.setDescription(request.getDescription());
			product.setCreateTime(new Date());
			dao.create(product);
			response.setStatus("200");
		} catch (Exception e) {

		}
		return response;
	}

	@RequestMapping(value = "/updatecategory", method = RequestMethod.POST)
	@ApiOperation(value = "Update Product", notes = "Update Product")
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Fields are with validation errors"),
			@ApiResponse(code = 201, message = "") })
	public AddUpdateResponse updateProduct(@RequestBody AddUpdateProduct request) {
		AddUpdateResponse response = new AddUpdateResponse();
		response.setStatus("600");
		try {
			Product product = new Product();
			product.setProdName(request.getName());
			product.setDescription(request.getDescription());
			product.setCreateTime(new Date());
			dao.create(product);
			response.setStatus("200");
		} catch (Exception e) {

		}
		return response;
	}

	@RequestMapping(value = "/getcategories", method = RequestMethod.GET)
	public GetProductResponse getProducts() {
		GetProductResponse response = new GetProductResponse();
		try {
			List<Product> products = dao.getAll();
			List<GetProductResponse.ProductModel> list = response.getProducts();
			for (Product prod : products) {
				GetProductResponse.ProductModel product = response.new ProductModel();
				// GetProductResponse.Product.Image image = product. new
				// Image();
				product.setDescription(prod.getDescription());
				product.setId(prod.getId());
				product.setName(prod.getProdName());
				list.add(product);
			}
		} catch (Exception e) {

		}
		return response;
	}

	@RequestMapping(value = "/getcategoriesdetails", method = RequestMethod.GET)
	public GetProductResponse getProductDetails() {
		GetProductResponse response = new GetProductResponse();
		try {
			Product prod = dao.getProductDetail(1);
			GetProductResponse.ProductModel product = response.new ProductModel();
			// GetProductResponse.Product.Image image = product. new
			// Image();
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
			response.getProducts().add(product);
		} catch (Exception e) {

		}
		return response;
	}
}
