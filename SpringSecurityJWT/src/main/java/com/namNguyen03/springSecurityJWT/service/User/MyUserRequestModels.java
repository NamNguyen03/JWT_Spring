package com.namNguyen03.springSecurityJWT.service.User;

import javax.validation.constraints.NotBlank;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class MyUserRequestModels {

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Login{
		@NotBlank
		private String username;

		@NotBlank
		private String password;
	}

	@AllArgsConstructor
	@Data
	@NoArgsConstructor
	public static class Register{
		
		@NotBlank
		private String username;
		
		@NotBlank
		private String password;
		
		private String fullname;
		
		private String email;
		
		private String phone;
		
		private String address;
		
		private String role;
	}
	
}
