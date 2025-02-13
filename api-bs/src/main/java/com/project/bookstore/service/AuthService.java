package com.project.bookstore.service;

import com.project.bookstore.dto.request.AuthRequest;
import com.project.bookstore.dto.response.JwtResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final TokenBlackListService tokenBlackListService;

    public AuthService(AuthenticationManager authenticationManager, JwtService jwtService,
                      TokenBlackListService tokenBlackListService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.tokenBlackListService = tokenBlackListService;
    }


    public JwtResponse login(AuthRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        if (authentication.isAuthenticated()) {
            String accessToken = jwtService.generateToken(request.getUsername());
            String refreshToken = jwtService.generateRefreshToken(request.getUsername());
            return new JwtResponse(accessToken, refreshToken, "Bearer ", request.getUsername());
        }
        throw new UsernameNotFoundException("Invalid username or password");
    }

    /**
     * Refreshes the access token using the provided refresh token.
     * It validates the refresh token, extracts the username, and issues new tokens.
     *
     * @param refreshToken The refresh token provided by the client.
     * @return A JwtResponse containing the new access token and refresh token.
     */
    public JwtResponse refresh(String refreshToken) {
        try {
            // Validate the refresh token's expiration
            if (jwtService.extractExpiration(refreshToken).before(new Date())) {
                throw new RuntimeException("Refresh token expired");
            }
            // Extract the username from the refresh token
            String username = jwtService.extractUsername(refreshToken);
            // Generate new tokens
            String newAccessToken = jwtService.generateToken(username);
            String newRefreshToken = jwtService.generateRefreshToken(username);
            return new JwtResponse(newAccessToken, newRefreshToken, "Bearer ", username);
        } catch (Exception e) {
            throw new RuntimeException("Invalid refresh token", e);
        }
    }

    public void logout(String token) {
        if (token == null || !token.startsWith("Bearer ")) {
            throw new IllegalArgumentException("Invalid token format");
        }
        String jwtToken = token.substring(7);
        tokenBlackListService.blacklistToken(jwtToken);
    }
}
