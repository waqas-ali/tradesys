package com.trade.database.api.request;

import com.trade.database.pojo.User;
import com.trade.database.pojo.Userprofile;

public class AddUpdateUser {
	private String token;
	private String status;
	private UserModel user;
	
	
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


	public UserModel getUser() {
		return user;
	}


	public void setUser(UserModel user) {
		this.user = user;
	}


	public class UserModel {
		private int id;
		private String firstName;
		private String lastName;
		private String email;
		private String picture;
		private String phone;
		private String address;
		private String description;
		private String password;
		private String userName;
		private UserRole role;
		
		public UserRole getRole() {
			return role;
		}
		public void setRole(UserRole role) {
			this.role = role;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public class UserRole {
		
			private int roleId;
			private String roleName;
			public int getRoleId() {
				return roleId;
			}
			public void setRoleId(int roleId) {
				this.roleId = roleId;
			}
			public String getRoleName() {
				return roleName;
			}
			public void setRoleName(String roleName) {
				this.roleName = roleName;
			}
			
			
		}
		
		
		
		
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPicture() {
			return picture;
		}
		public void setPicture(String picture) {
			this.picture = picture;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
	}
}
