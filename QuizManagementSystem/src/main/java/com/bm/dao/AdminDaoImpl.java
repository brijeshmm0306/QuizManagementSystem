package com.bm.dao;

import java.util.Map;

import com.bm.database.UserAndAdminDatabase;
import com.bm.exception.AdminAlreadyExistsException;

public class AdminDaoImpl implements AdminDao, UserAndAdminDatabase {

	@Override
	public void adminSignUp(String adminUserName, String adminPassword) throws AdminAlreadyExistsException {

		if (adminData.containsKey(adminUserName)) {

			throw new AdminAlreadyExistsException("admin username exists");

		}
		adminData.put(adminUserName, adminPassword);

	}

	@Override
	public boolean adminLogin(String adminUserName, String adminPassword) {

		return adminData.containsKey(adminUserName) && adminData.get(adminUserName).equals(adminPassword);
	}

	@Override
	public Map<String, String> getAdminData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> getUserData() {
		// TODO Auto-generated method stub
		return null;
	}

}
