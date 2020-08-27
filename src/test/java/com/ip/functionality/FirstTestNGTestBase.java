package com.ip.functionality;

import com.ip.testng.UserManager;
import com.ip.testng.baseclasses.UnitTestBaseClass;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class FirstTestNGTestBase extends UnitTestBaseClass {

        private UserManager um;

        @BeforeMethod
        public void customLocalSetupMethod(Method testMethod) {
            String desc = testMethod.getAnnotation(Test.class).description();
            System.out.println("Starting test: " + testMethod.getName() + " with description: " + desc);
            um = new UserManager();
        }

        @Test(description = "Verify that addUser method returns true when successful")
        public void successfulAddUserReturnsTrue() {
            // Arrange

            // Act
            boolean result = um.addUser("john@email.com");

            // Assert
            Assert.assertTrue(result);
        }

        @Test(description = "Verify that getUser method retrieves the correct existing user")
        public void getExistingUserReturnsExistingSavedUser() {
            // Arrange
            um.addUser("john@email.com");

            // Act
            String user = um.getUser("john@email.com");

            // Assert
            Assert.assertEquals(user, "john@email.com");
        }

        @Test(description = "Verify that getUser method returns null if the user does not exist")
        public void getNonExistingUserReturnsNull() {
            // Arrange

            // Act
            String user = um.getUser("john@email.com");

            // Assert
            Assert.assertNull(user,"The method should return null if it doesn't find a user");
        }

}

