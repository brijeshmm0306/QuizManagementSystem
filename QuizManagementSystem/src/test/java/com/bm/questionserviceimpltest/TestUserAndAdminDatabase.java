package com.bm.questionserviceimpltest;
import java.util.HashMap;
import java.util.Map;
import com.bm.database.UserAndAdminDatabase;

public class TestUserAndAdminDatabase implements UserAndAdminDatabase {

    private Map<String, String> adminData = new HashMap<>();
    private Map<String, String> userData = new HashMap<>();

    @Override
    public Map<String, String> getAdminData() {
        return adminData;
    }

    @Override
    public Map<String, String> getUserData() {
        return userData;
    }
}
