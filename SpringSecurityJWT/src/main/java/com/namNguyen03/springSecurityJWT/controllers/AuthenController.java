package com.namNguyen03.springSecurityJWT.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/authen")
public class AuthenController {
	
	@PreAuthorize("hasAuthority('admin:write')")
	@GetMapping("/admin")
	public String getAdmin() {
		return "Admin";
	}
	
	@PreAuthorize("hasAuthority('admin:read')")
	@GetMapping("/admin-traineer")
	public String getAdminTraineer() {
		return "ADMIN_TRAINEE";
	}
	
	@PreAuthorize("hasAuthority('consumer')")
	@GetMapping("/consummer")
	public String getConsummer() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username;
		if (principal instanceof UserDetails) {
			  username = ((UserDetails)principal).getAuthorities().iterator().next().toString();
			} else {
			  username = principal.toString();
			}
		System.out.println(username);
		return "CONSUMER";
	}
}
