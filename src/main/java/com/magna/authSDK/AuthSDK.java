package com.magna.authSDK;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthSDK {

    private final RestTemplate restTemplate;
    private String authorizationServiceBaseUrl;

    public AuthSDK(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getAuthorizationServiceBaseUrl() {
        return authorizationServiceBaseUrl;
    }

    public void setAuthorizationServiceBaseUrl(String authorizationServiceBaseUrl) {
        this.authorizationServiceBaseUrl = authorizationServiceBaseUrl;
    }


    public boolean validateToken(String token) {
        // Construct the URL for the /token/validate endpoint
        String validateUrl = authorizationServiceBaseUrl + "/token/validate?token=" + token;


        ResponseEntity<String> response = restTemplate.exchange(validateUrl, HttpMethod.GET, null, String.class);

            // Check the response status code
        HttpStatusCode statusCode = response.getStatusCode();

            // If the status code is 200, the token is valid; otherwise, it's not
        return statusCode.value() == 200;
    }
}
