package com.bm.database;


import java.util.HashMap;
import java.util.Map;

import com.bm.model.QuestionLibrary;

public interface UserAndAdminDatabase {
	
	Map<String, String> adminData = new HashMap<String, String>();
	
	Map<String, String> userData = new HashMap<String, String>();
	
	Map<String, String> getAdminData();

    Map<String, String> getUserData();
	
}
