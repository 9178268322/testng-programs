package com.ip.functionality.expected.exception;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestTimeout {

    CloseableHttpClient client;
    CloseableHttpResponse response;

    @BeforeMethod(timeOut = 8000) // enough time - will pass
    public void setup() {
        // Arrange
        client = HttpClientBuilder.create().build();
    }

    @Test(timeOut = 500) // not enough time - will fail
    public void testIsToSlow() throws IOException {
        response = client.execute(new HttpGet("https://api.github.com/"));
        Assert.assertEquals(response.getStatusLine().getStatusCode(), 200);
    }

    @AfterMethod
    public void cleanup() throws IOException {
        if (client != null || response != null) {
            client.close();
            response.close();
        }
    }
}
