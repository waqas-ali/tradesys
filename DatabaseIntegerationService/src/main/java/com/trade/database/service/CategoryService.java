package com.trade.database.service;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.trade.database.api.request.AddProduct;
import com.trade.database.api.response.AddResponse;
import com.trade.database.api.response.GetProductResponse;
import com.trade.database.dao.ProductDAO;
import com.trade.database.pojo.Pricesslot;
import com.trade.database.pojo.Product;

@RestController
@RequestMapping("/product")
public class CategoryService {
	@Autowired
	private ProductDAO dao;

	@RequestMapping(value = "/addproduct", method = RequestMethod.POST)
	@ApiOperation(value = "Add new Product", notes = "Add new Product")
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Fields are with validation errors"),
			@ApiResponse(code = 201, message = "") })
	public AddResponse addProduct(@RequestBody AddProduct request) {
		AddResponse response = new AddResponse();
		response.setStatus("600");
		try {
			Product product = new Product();
			product.setProdName(request.getProduct());
			product.setUserId(1);
			product.setDescription(request.getDescription());
			product.setCreateTime(new Date());
			dao.create(product);
			response.setStatus("200");
		} catch (Exception e) {

		}
		return response;
	}

	@RequestMapping(value = "/updateproduct", method = RequestMethod.POST)
	@ApiOperation(value = "Update Product", notes = "Update Product")
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Fields are with validation errors"),
			@ApiResponse(code = 201, message = "") })
	public AddResponse updateProduct(@RequestBody AddProduct request) {
		AddResponse response = new AddResponse();
		response.setStatus("600");
		try {
			Product product = new Product();
			product.setProdName(request.getProduct());
			product.setId(request.getId());
			product.setDescription(request.getDescription());
			product.setCreateTime(new Date());
			dao.create(product);
			response.setStatus("200");
		} catch (Exception e) {

		}
		return response;
	}

	@RequestMapping(value = "/getproducts", method = RequestMethod.GET)
	public GetProductResponse getProducts() {
		GetProductResponse response = new GetProductResponse();
		try {
			List<Product> products = dao.getAll();
			List<GetProductResponse.Product> list = response.getProducts();
			for (Product prod : products) {
				GetProductResponse.Product product = response.new Product();
				// GetProductResponse.Product.Image image = product. new
				// Image();
				product.setDescription(prod.getDescription());
				product.setId(prod.getId());
				product.setProduct(prod.getProdName());
				list.add(product);
			}
		} catch (Exception e) {

		}
		return response;
	}

	@RequestMapping(value = "/getproductdetails", method = RequestMethod.GET)
	public GetProductResponse getProductDetails() {
		GetProductResponse response = new GetProductResponse();
		try {
			Product prod = dao.getProductDetail(1);
			GetProductResponse.Product product = response.new Product();
			// GetProductResponse.Product.Image image = product. new
			// Image();
			product.setDescription(prod.getDescription());
			product.setId(prod.getId());
			product.setProduct(prod.getProdName());
			Set<Pricesslot> prices = prod.getPricesslots();
			Iterator<Pricesslot> iterator = prices.iterator();			
			while ( iterator.hasNext()) {
				Pricesslot slot = iterator.next();
				GetProductResponse.Product.Prices pr = product. new Prices();
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
