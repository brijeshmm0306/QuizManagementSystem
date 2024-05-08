package com.bm.dao;

import com.bm.exception.AdminAlreadyExistsException;

public interface AdminDao {
	
	public void adminSignUp(String adminUserName, String adminPassword) throws AdminAlreadyExistsException;
	
	public boolean adminLogin(String adminUserName, String adminPassword);

}
