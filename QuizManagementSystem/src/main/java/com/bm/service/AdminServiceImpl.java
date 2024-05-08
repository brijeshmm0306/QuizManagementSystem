package com.bm.service;

import com.bm.dao.AdminDaoImpl;
import com.bm.database.UserAndAdminDatabase;
import com.bm.exception.AdminAlreadyExistsException;

public class AdminServiceImpl implements AdminService, UserAndAdminDatabase
{
    AdminDaoImpl adminDaoImpl = new AdminDaoImpl();

    @Override
    public void adminSignUp(String adminUserName, String adminPassword) 
    {
        try 
        {
        	adminDaoImpl.adminSignUp(adminUserName, adminPassword);
            
        	System.out.println("Admin SignUp successful");
        } 
        catch (AdminAlreadyExistsException e) 
        {
            System.out.println(e.getMessage());
        }
    }

	@Override
	public boolean adminLoginIn(String adminUserName, String adminPassword)
	{
	    boolean isSuccess = adminDaoImpl.adminLogin(adminUserName, adminPassword);

	    if(isSuccess)
	    {
	        System.out.println("Login Successful");
	    }
	    else 
	    {
	        System.out.println("Incorrect username or password");
	    }
		
		return isSuccess;
	}

	
    
}