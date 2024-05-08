package com.bm.questionserviceimpltest;
import org.junit.jupiter.api.Test;
import com.bm.dao.UserDao;
import com.bm.dao.UserDaoImpl;
import com.bm.exception.UserAlreadyExistsException;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoImplTest {
    private final UserDao userDao = new UserDaoImpl();

    @Test
    void testUserSignUpNewUser() {
        
        String userName = "testUser";
        String userPassword = "testPassword";

        assertDoesNotThrow(() -> userDao.userSignUp(userName, userPassword));
    }

    @Test
    void testUserSignUpExistingUser() {
        String userName = "testUser";
        String userPassword = "testPassword";

        assertThrows(UserAlreadyExistsException.class, () -> {
            userDao.userSignUp(userName, userPassword);  
            userDao.userSignUp(userName, userPassword);  
        });
    }

    @Test
    void testUserLoginWithCorrectCredentials() {
       
        String userName = "testUser2";
        String userPassword = "testPassword2";

        assertDoesNotThrow(() -> userDao.userSignUp(userName, userPassword));
        assertTrue(userDao.userLoginIn(userName, userPassword)); 
    }

    @Test
    void testUserLoginWithIncorrectCredentials() {
        
        String userName = "testUser3";
        String correctPassword = "correctPassword";
        String incorrectPassword = "incorrectPassword";

        assertDoesNotThrow(() -> userDao.userSignUp(userName, correctPassword));
        assertFalse(userDao.userLoginIn(userName, incorrectPassword));
    }
}