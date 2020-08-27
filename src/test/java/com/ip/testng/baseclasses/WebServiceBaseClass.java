package com.ip.testng.baseclasses;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class WebServiceBaseClass {

    protected CloseableHttpClient client;
    protected CloseableHttpResponse response;

    @BeforeClass
    public void setup() throws IOException {
        System.out.println("Runs once per class");
        client = HttpClientBuilder.create().build();
        response = client.execute(new HttpGet("https://api.github.com/"));
    }

    @BeforeMethod
    public void setupMethod() {
        System.out.println("Runs before each @Test");
    }

    @AfterClass(alwaysRun = true)
    public void cleanup() throws IOException {
        client.close();
        response.close();
    }
}