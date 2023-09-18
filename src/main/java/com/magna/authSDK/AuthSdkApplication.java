package com.magna.authSDK;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AuthSdkApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthSdkApplication.class, args);
	}

	String authorizationServiceBaseUrl = "https://example.com/auth-service";

	// Create an instance of HttpService
	HttpService httpService = new HttpService();

	// Create an instance of AuthSDK and inject HttpService
	AuthSDK authSDK = new AuthSDK(authorizationServiceBaseUrl, httpService);

	// Use authSDK to validate tokens
	boolean isValid = authSDK.validateToken("your_token_here");

	// Handle the validation result (e.g., print or take further action)
        if (isValid) {
		System.out.println("Token is valid.");
	} else {
		System.out.println("Token is not valid.");
	}
}


