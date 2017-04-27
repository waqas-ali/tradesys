package com.trade.database.entitymapper;

import com.trade.database.api.request.AddUpdateUser;
import com.trade.database.api.response.UserDetail;
import com.trade.database.pojo.Role;
import com.trade.database.pojo.User;
import com.trade.database.pojo.Userprofile;

public class UserEntityMapper {
	public User convertToEntity(AddUpdateUser dto) {
		AddUpdateUser.UserModel model = dto.getUser();
		
		Userprofile profile = new Userprofile();
		profile.setAddress(model.getAddress());
		profile.setDescription(model.getDescription());
		profile.setEmail(model.getEmail());
		profile.setFirstName(model.getFirstName());
		profile.setLastName(model.getLastName());
		profile.setPhone(model.getPhone());
		profile.setPicture(model.getPicture());
		Role role = new Role();
		role.setId(model.getRole().getRoleId());
		User user = new User();
		user.setUserprofile(profile);
		user.setUserName(model.getUserName());
		user.setPassword(model.getPassword());
		user.setRole(role);
		profile.getUsers().add(user);
		role.getUsers().add(user);
		
		return user;
	}
	
	public UserDetail convertFromEntity(User user ) {
		UserDetail dto = new UserDetail();
		UserDetail.UserModel model = dto. new UserModel();
		Userprofile profile = user.getUserprofile(); 
		model.setFirstName(profile.getFirstName());
		model.setLastName(profile.getLastName());
		model.setEmail(profile.getEmail());
		model.setPhone(profile.getPhone());
		model.setPicture(profile.getPicture());
		model.setAddress(profile.getAddress());
		model.setDescription(profile.getDescription());
		dto.setUser(model);
		return dto;
		
	}
}
