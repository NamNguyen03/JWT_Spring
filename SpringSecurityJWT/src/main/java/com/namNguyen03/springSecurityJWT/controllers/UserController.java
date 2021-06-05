package com.namNguyen03.springSecurityJWT.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.namNguyen03.springSecurityJWT.MyException.BusinessException;
import com.namNguyen03.springSecurityJWT.service.User.MyUserRequestModels;
import com.namNguyen03.springSecurityJWT.service.User.MyUserService;


@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	MyUserService myUserService;
	
	@PostMapping("/register")
	public int register(@RequestBody MyUserRequestModels.Register rq) throws BusinessException {
	
		return myUserService.register(rq);
	}
	
}
