package com.ip.functionality.expected.exception;

import com.ip.duplicate.exception.DuplicateUserException;
import com.ip.duplicate.exception.UserManager;
import com.ip.testng.baseclasses.UnitTestBaseClass;
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

    @Test(expectedExceptions = DuplicateUserException.class)
    public void addDuplicateThrowsException() throws DuplicateUserException {
        // Act
        um.addUser("same@email.com");
        um.addUser("same@email.com");
    }
}
