package com.bm.service;

import com.bm.exception.UserAlreadyExistsException;

public interface UserService {
	
    public void userSignUp(String userName, String userPassword) throws UserAlreadyExistsException;
	
	public boolean userLoginIn(String userName, String userPassword);

}
