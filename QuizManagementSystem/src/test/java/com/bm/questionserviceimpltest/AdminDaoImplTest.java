package com.bm.questionserviceimpltest;



import com.bm.dao.AdminDao;
import com.bm.dao.AdminDaoImpl;
import com.bm.database.UserAndAdminDatabase;
import com.bm.exception.AdminAlreadyExistsException;
import com.bm.model.QuestionLibrary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class AdminDaoImplTest {

    private AdminDao adminDao;
    private Map<String, String> adminData;

    @BeforeEach
    public void setup() {
        adminData = UserAndAdminDatabase.adminData;
        adminDao = new AdminDaoImpl();
    }

    @Test
    public void testAdminSignUp_adminDoesNotExist_success() throws AdminAlreadyExistsException {
        adminDao.adminSignUp("newUser", "newPassword");

        assertTrue(adminData.containsKey("newUser"));
        assertEquals("newPassword", adminData.get("newUser"));
    }

    @Test
    public void testAdminSignUp_adminAlreadyExists_throwsException() {
        adminData.put("existingUser", "existingPassword");

        assertThrows(AdminAlreadyExistsException.class, () -> adminDao.adminSignUp("existingUser", "newPassword"));
    }

    @Test
    public void testAdminLogin_adminExistsAndPasswordsMatch_returnsTrue() {
        adminData.put("testUser", "testPassword");

        assertTrue(adminDao.adminLogin("testUser", "testPassword"));
    }

    @Test
    public void testAdminLogin_adminExistsAndPasswordsDoNotMatch_returnsFalse() {
        adminData.put("testUser", "testPassword");

        assertFalse(adminDao.adminLogin("testUser", "wrongPassword"));
    }

    @Test
    public void testAdminLogin_adminDoesNotExist_returnsFalse() {
        assertFalse(adminDao.adminLogin("nonexistentUser", "anyPassword"));
    }
}