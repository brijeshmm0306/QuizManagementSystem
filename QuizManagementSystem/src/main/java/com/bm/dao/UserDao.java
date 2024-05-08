package com.bm.dao;

import com.bm.exception.UserAlreadyExistsException;

public interface UserDao {
	
	public void userSignUp(String userName, String userPassword) throws UserAlreadyExistsException;
	
	public boolean userLoginIn(String userName, String userPassword);

}
