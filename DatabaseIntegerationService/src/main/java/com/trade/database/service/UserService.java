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

import com.trade.database.api.request.AddUpdateUser;
import com.trade.database.api.request.LoginRequest;
import com.trade.database.api.response.AddUpdateResponse;
import com.trade.database.api.response.UserDetail;
import com.trade.database.dao.UserDAO;
import com.trade.database.entitymapper.UserEntityMapper;
import com.trade.database.pojo.User;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserService {
	@Autowired
	  private UserDAO dao;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ApiOperation(value = "Authenticate User ", notes = "Authenticate User")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Fields are with validation errors"),
            @ApiResponse(code = 201, message = "") })
	public UserDetail login(@RequestBody LoginRequest request) {
		User user = dao.getByUsername(request.getEmail());
		UserEntityMapper mapper = new UserEntityMapper();
		UserDetail response = mapper.convertFromEntity(user);
		response.setToken(""+user.getId());
		response.setStatus("200");
		return response;
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	@ApiOperation(value = "Register User ", notes = "Register New User")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Fields are with validation errors"),
            @ApiResponse(code = 201, message = "") })
	public AddUpdateResponse register(@RequestBody AddUpdateUser user) {
		UserEntityMapper mapper = new UserEntityMapper();
		User entity =mapper.convertToEntity(user);
		 dao.create(entity);
		AddUpdateResponse response = new AddUpdateResponse();
		response.setToken("");
		response.setStatus("200");
		response.setMessage("success");
		return response;
	}
	
	@RequestMapping(value="/detail",method=RequestMethod.POST)
	@ApiOperation(value = "Get User Detail ", notes = "Get User Detail")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Fields are with validation errors"),
            @ApiResponse(code = 201, message = "") })
	public UserDetail getUserDetail(@RequestBody String token, @RequestBody long userId) {
		User user = dao.getById(userId);
		UserEntityMapper mapper = new UserEntityMapper();
		UserDetail response = mapper.convertFromEntity(user); 
		return response;
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ApiOperation(value = "Update User ", notes = "Update User")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Fields are with validation errors"),
            @ApiResponse(code = 201, message = "") })
	public AddUpdateResponse updateUser(@RequestBody AddUpdateUser user) {
		UserEntityMapper mapper = new UserEntityMapper();
		User entity =mapper.convertToEntity(user);
		 dao.update(entity);
		AddUpdateResponse response = new AddUpdateResponse();
		response.setToken("");
		response.setStatus("200");
		response.setMessage("success");
		return response;
	}
}
