package com.trade.database.service;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.trade.database.api.request.AddUpdateOrder;
import com.trade.database.api.response.AddUpdateResponse;
import com.trade.database.api.response.GetOrderDetailResponse;
import com.trade.database.api.response.GetOrderResponse;
import com.trade.database.dao.OrderDAO;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/order")
public class OrderService {
	@Autowired
	  private OrderDAO dao;
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ApiOperation(value = "Add Order ", notes = "Add New Order")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Fields are with validation errors"),
            @ApiResponse(code = 201, message = "") })
	public AddUpdateResponse addOrder(@RequestBody AddUpdateOrder order) {
		AddUpdateResponse response = new AddUpdateResponse();
		return response;
	}
	
	@RequestMapping(value="/get/customer",method=RequestMethod.POST)
	@ApiOperation(value = "Get Orders ", notes = "Get Orders")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Fields are with validation errors"),
            @ApiResponse(code = 201, message = "") })
	public GetOrderResponse getOrdersByCustomer(@RequestBody String token, @RequestBody int userId) {
		GetOrderResponse response = new GetOrderResponse();		
		return response;
	}
	
	@RequestMapping(value="/get/producer",method=RequestMethod.POST)
	@ApiOperation(value = "Get Orders ", notes = "Get Orders")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Fields are with validation errors"),
            @ApiResponse(code = 201, message = "") })
	public GetOrderResponse getOrdersByProducer(@RequestBody String token, @RequestBody int userId) {
		GetOrderResponse response = new GetOrderResponse();		
		return response;
	}
	
	@RequestMapping(value="/detail",method=RequestMethod.POST)
	@ApiOperation(value = "Get Order Detail ", notes = "Get Order Detail")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Fields are with validation errors"),
            @ApiResponse(code = 201, message = "") })
	public GetOrderDetailResponse getOrderDetail(@RequestBody String token, @RequestBody int orderId) {
		GetOrderDetailResponse response = new GetOrderDetailResponse();
		
		return response;
	}
	
	@RequestMapping(value="/updatestatus",method=RequestMethod.POST)
	@ApiOperation(value = "Update User ", notes = "Update User")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Fields are with validation errors"),
            @ApiResponse(code = 201, message = "") })
	public AddUpdateResponse updateUser(@RequestBody String token,@RequestBody int orderId, @RequestBody int productId, @RequestBody int status) {
		AddUpdateResponse response = new AddUpdateResponse();
		
		return response;
	}
}
