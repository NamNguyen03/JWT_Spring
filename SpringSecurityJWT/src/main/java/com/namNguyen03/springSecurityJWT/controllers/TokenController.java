package com.namNguyen03.springSecurityJWT.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.namNguyen03.springSecurityJWT.MyException.BusinessException;
import com.namNguyen03.springSecurityJWT.service.User.MyUserRequestModels;
import com.namNguyen03.springSecurityJWT.service.User.MyUserResponseModels;
import com.namNguyen03.springSecurityJWT.service.User.MyUserService;

@RestController
@RequestMapping("/api/token")
@CrossOrigin("*")
public class TokenController {
	
	@Autowired
	MyUserService myUserService;
	

	@PostMapping()
	public ResponseEntity<MyUserResponseModels.JWT> authenticateUser(@Valid @RequestBody MyUserRequestModels.Login rq) throws BusinessException {
	        return ResponseEntity.ok(myUserService.authenticateUser(rq));
	}

	
}
	