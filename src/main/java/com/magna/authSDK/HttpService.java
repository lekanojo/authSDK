package com.magna.authSDK;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpService {
    private final HttpClient httpClient;

    public HttpService() {
        // Initialize the HttpClient (you can customize HttpClient settings here)
        this.httpClient = HttpClients.createDefault();
    }

    public HttpResponse executeGetRequest(String url) throws Exception {
        // Create an HTTP GET request
        HttpGet httpGet = new HttpGet(url);

        // Send the HTTP GET request and return the response
        return httpClient.execute(httpGet);
    }

    public String getResponseContent(HttpResponse response) throws Exception {
        // Extract and return the response content as a string
        return EntityUtils.toString(response.getEntity());
    }
}
