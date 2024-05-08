package com.bm.service;

import com.bm.exception.AdminAlreadyExistsException;

public interface AdminService {
	
    public void adminSignUp(String adminUserName, String adminPassword) throws AdminAlreadyExistsException;
	
	public boolean adminLoginIn(String adminUserName, String adminPassword);

}
