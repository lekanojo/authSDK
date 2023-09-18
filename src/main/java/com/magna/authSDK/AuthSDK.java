package com.magna.authSDK;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class AuthSDK {
    private final String authorizationServiceBaseUrl;
    private final HttpService httpService;

    public AuthSDK(String authorizationServiceBaseUrl, HttpService httpService) {
        this.authorizationServiceBaseUrl = authorizationServiceBaseUrl;
        this.httpService = httpService;
    }

    public boolean validateToken(String token) {
        // Construct the URL for the /token/validate endpoint
        String validateUrl = authorizationServiceBaseUrl + "/token/validate?token=" + token;

        try {
            // Send the HTTP GET request using the HttpService
            HttpResponse response = httpService.executeGetRequest(validateUrl);

            // Check the response status code
            int statusCode = response.getStatusLine().getStatusCode();

            // If the status code is 200, the token is valid; otherwise, it's not
            if (statusCode == 200) {
                // Optionally, you can parse the response content for more information
                String responseContent = httpService.getResponseContent(response);
                // Process the response content as needed
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            // Handle any exceptions (e.g., network errors)
            e.printStackTrace();
            return false;
        }
    }
}
