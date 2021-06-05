package com.namNguyen03.springSecurityJWT.service.User;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class MyUserResponseModels {
	
	@AllArgsConstructor
	@Data
	@NoArgsConstructor
	public static class JWT{
		private long id;
		private String username;
		private String fullname;
		private String email;
		private String phone;
		private String address;
		private String role;
		private String jwt;
	}
	
	
}
