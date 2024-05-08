package com.bm.service;

import com.bm.dao.UserDaoImpl;
import com.bm.exception.UserAlreadyExistsException;

public class UserServiceImpl implements UserService{
	
	UserDaoImpl userDaoImpl = new UserDaoImpl();

	@Override
	public void userSignUp(String userName, String userPassword) throws UserAlreadyExistsException {
		
		userDaoImpl.userSignUp(userName, userPassword);
		
	}

	@Override
	public boolean userLoginIn(String userName, String userPassword) {
		// TODO Auto-generated method stub
		return userDaoImpl.userLoginIn(userName, userPassword);
	}

	
	

}
