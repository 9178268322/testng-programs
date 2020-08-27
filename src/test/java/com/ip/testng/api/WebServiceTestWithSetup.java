package com.ip.testng.api;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

import static org.apache.http.entity.ContentType.getOrDefault;

public class WebServiceTestWithSetup {

    private CloseableHttpClient client;
    private CloseableHttpResponse response;

    @BeforeClass
    public void setup() throws IOException {
        client = HttpClientBuilder.create().build();
        response = client.execute(new HttpGet("https://api.github.com/"));
    }

    @AfterClass
    public void cleanup() throws IOException {
        client.close();
        response.close();
    }

    @Test
    public void statusIs200() {
        Assert.assertEquals(response.getStatusLine().getStatusCode(), 200);
    }

    @Test
    public void typeIsJson() {
        Assert.assertEquals(getOrDefault(response.getEntity()).getMimeType(), "application/json");
    }

    @Test
    public void charSetIsUtf8() {
        Assert.assertEquals(getOrDefault(response.getEntity()).getCharset().toString(), "UTF-8");
    }
}
