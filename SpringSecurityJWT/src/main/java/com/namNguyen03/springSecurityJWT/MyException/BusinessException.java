package com.namNguyen03.springSecurityJWT.MyException;


public class BusinessException extends Throwable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 
	public BusinessException(String message) {
		super(message);
	}
	
}
