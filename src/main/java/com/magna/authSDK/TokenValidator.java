package com.magna.authSDK;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.security.SignatureException;
import com.magna.authSDK.TokenValidationResult;


public class TokenValidator {

    private final String secretKey; // secret key for JWT validation

    public TokenValidator(String secretKey) {
        this.secretKey = secretKey;
    }

    public TokenValidationResult validateToken(String token) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token)
                    .getBody();

            //  perform additional validation on claims here
            // For example, check the expiration, issuer, or custom claims

            // Example: Check if the token has expired
            long currentTimeMillis = System.currentTimeMillis();
            if (claims.getExpiration().getTime() < currentTimeMillis) {
                return TokenValidationResult.EXPIRED;
            }

            // Add more custom validation logic here as needed

            // If all validations pass, the token is valid
            return TokenValidationResult.VALID;

        } catch (ExpiredJwtException e) {
            // Token has expired
            return TokenValidationResult.EXPIRED;
        } catch (MalformedJwtException e) {
            // Token is malformed
            return TokenValidationResult.INVALID;
        } catch (SignatureException e) {
            // Token signature is invalid
            return TokenValidationResult.INVALID;
        } catch (Exception e) {
            // Other exceptions
            return TokenValidationResult.ERROR;
        }
    }
}


