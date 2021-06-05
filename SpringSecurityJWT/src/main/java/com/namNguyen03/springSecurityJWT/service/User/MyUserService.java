package com.namNguyen03.springSecurityJWT.service.User;


import javax.validation.Valid;

import com.namNguyen03.springSecurityJWT.MyException.BusinessException;
import com.namNguyen03.springSecurityJWT.service.User.MyUserRequestModels.Register;


public interface MyUserService {

	MyUserResponseModels.JWT authenticateUser(@Valid MyUserRequestModels.Login loginRequest) throws BusinessException ;

	int register(Register rq) throws BusinessException ;

}
