package com.ip.testng;

import com.ip.testng.baseclasses.UnitTestBaseClass;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstTestNGTestBase extends UnitTestBaseClass {

    private UserManager um;

    @BeforeMethod
    public void customLocalSetupMethod() {
        um = new UserManager();
    }

    @Test(description = "This is something")
    public void successfulAddUserReturnsTrue() {
        // Arrange

        // Act
        boolean result = um.addUser("john@email.com");

        // Assert
        Assert.assertTrue(result);
    }

    @Test
    public void getExistingUserReturnsExistingSavedUser() {
        // Arrange
        um.addUser("john@email.com");

        // Act
        String user = um.getUser("john@email.com");

        // Assert
        Assert.assertEquals(user, "john@email.com");
    }

    @Test
    public void getNonExistingUserReturnsNull() {
        // Arrange

        // Act
        String user = um.getUser("john@email.com");

        // Assert
        Assert.assertNull(user,"The method should return null if it doesn't find a user");
    }
}
