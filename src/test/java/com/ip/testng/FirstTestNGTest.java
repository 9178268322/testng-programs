package com.ip.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTestNGTest {

    @Test
    public void successfulAddUserReturnsTrue(){
        // Arrange
        UserManager um = new UserManager();

        // Act
        boolean result = um.addUser("john@email.com");

        // Assert
        Assert.assertTrue(result);
    }

    @Test
    public void getExistingUserReturnsExistingSavedUser(){
        // Arrange
        UserManager um = new UserManager();
        um.addUser("john@email.com");

        // Act
        String user = um.getUser("john@email.com");

        // Assert
        Assert.assertEquals(user, "john@email.com");
    }

    @Test
    public void getNonExistingUserReturnsNull(){
        // Arrange
        UserManager um = new UserManager();

        // Act
        String user = um.getUser("john@email.com");

        // Assert
        Assert.assertNull(user,"The method should return null if it doesn't find a user");
    }
}
