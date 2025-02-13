package com.project.bookstore.controller;

import com.project.bookstore.dto.request.AuthRequest;
import com.project.bookstore.dto.request.CreateUserRequest;
import com.project.bookstore.dto.request.UpdateUserRequest;
import com.project.bookstore.dto.response.JwtResponse;
import com.project.bookstore.model.User;
import com.project.bookstore.service.AuthService;
import com.project.bookstore.service.JwtService;
import com.project.bookstore.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("v1/auth")
public class UserController {
    private final UserService userService;
    private final JwtService jwtService;
    private final AuthService authService;

    public UserController(UserService userService, JwtService jwtService, AuthService authService) {
        this.userService = userService;
        this.jwtService = jwtService;
        this.authService = authService;
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome";
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.listAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping("/addNewUser")
    public ResponseEntity<User> createUser(@RequestBody CreateUserRequest request) {
        return ResponseEntity.ok(userService.createUser(request));
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UpdateUserRequest request) {
        return ResponseEntity.ok(userService.updateUser(id, request));
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

//    @PostMapping("/refreshToken")
//    public ResponseEntity<JwtResponse> refreshToken(@RequestBody String refreshToken) {
//        return ResponseEntity.ok(authService.refresh(refreshToken));
//    }
    @PostMapping("/refresh")
    public ResponseEntity<JwtResponse> refreshToken(@RequestBody Map<String, String> tokenRequest) {
        String refreshToken = tokenRequest.get("refreshToken");
        JwtResponse jwtResponse = authService.refresh(refreshToken);
        return ResponseEntity.ok(jwtResponse);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestHeader("Authorization") String token) {
        try {
            authService.logout(token);
            return ResponseEntity.ok("Logged out successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/userEnd")
    public String privateEndPoint(){
        return "hi from user endpoint";
    }
}
