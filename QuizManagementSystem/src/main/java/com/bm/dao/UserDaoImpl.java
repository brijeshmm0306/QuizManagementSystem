package com.bm.dao;

import com.bm.database.UserAndAdminDatabase;
import com.bm.exception.UserAlreadyExistsException;

public class UserDaoImpl implements UserDao,UserAndAdminDatabase{

	@Override
	public void userSignUp(String userName, String userPassword) throws UserAlreadyExistsException {
		
		if(userData.containsKey(userName))
		{
			throw new UserAlreadyExistsException("username already exists");
		}
		
		else
		{
			userData.put(userName, userPassword);
		}
		
	}

	@Override
	public boolean userLoginIn(String userName, String userPassword) {
		// TODO Auto-generated method stub
		return userData.containsKey(userName) && userData.get(userName).contains(userPassword);

	}

}
