package com.magna.authSDK;

import org.springframework.stereotype.Component;

@Component
public class SampleAS {
    private final AuthSDK authSDK;


    public SampleAS(AuthSDK authSDK) {
        this.authSDK = authSDK;
    }
    public void testValidateToken() {
        authSDK.setAuthorizationServiceBaseUrl("example.com");
        boolean result = authSDK.validateToken("heroiwehroireu834y02");
    }
}
