package com.ip.functionality.expected.exception;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

@Ignore
public class DisabledTest {

    @Test
    public void unstableTest1(){
        System.out.println("Test 1");
    }

    @Test
    public void unstableTest2(){
        System.out.println("Test 2");
    }
}
