package com.example.cours.controller;

import com.example.cours.dto.ApiResponse;
import com.example.cours.dto.UserDTO;
import com.example.cours.dto.request.LoginRequestDTO;
import com.example.cours.dto.request.RegistrationRequestDTO;
import com.example.cours.entities.User;
import com.example.cours.security.JwtService;
import com.example.cours.services.AuthService;
import com.example.cours.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;


@RestController
public class UserController {

    @Autowired
    private AuthenticationManager authManager;
    @Autowired
    private AuthService authService;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<Map<String, Object>>> login(
            @Valid @RequestBody LoginRequestDTO request) {
        try {
            Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    request.getEmail(),
                    request.getPassword()));

            UserDetails userDetails =
                (UserDetails) auth.getPrincipal();
            String token =
                jwtService.generateToken(userDetails);

            List<String> roles = new ArrayList<>();
            userDetails.getAuthorities()
                .forEach(a -> roles.add(a.getAuthority()));

            Map<String, Object> data = new LinkedHashMap<>();
            data.put("token", token);
            data.put("username", userDetails.getUsername());
            data.put("roles", roles);

            return ResponseEntity.ok(
                ApiResponse.ok("Connexion réussie", data));

        } catch (AuthenticationException e) {
            return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(ApiResponse.error(
                    "Email ou mot de passe incorrect"));
        }
    }

    @PostMapping("/api/users/register")
    public ResponseEntity<ApiResponse<Map<String, String>>> register(
            @Valid @RequestBody RegistrationRequestDTO req) {
        User user = authService.registerUser(req);
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(ApiResponse.ok("Inscription réussie",
                Map.of("email", user.getEmail())));
    }

    @GetMapping("/api/users")
    public ResponseEntity<ApiResponse<List<UserDTO>>> getAllUsers() {
        return ResponseEntity.ok(
            ApiResponse.ok(userService.findAll()));
    }

    @GetMapping("/api/users/{id}")
    public ResponseEntity<ApiResponse<UserDTO>> getUserById(
            @PathVariable Long id) {
        return ResponseEntity.ok(
            ApiResponse.ok(userService.findById(id)));
    }

    @PutMapping("/api/users/{id}")
    public ResponseEntity<ApiResponse<UserDTO>> updateUser(
            @PathVariable Long id,
            @RequestBody UserDTO dto) {
        return ResponseEntity.ok(
            ApiResponse.ok(userService.update(id, dto)));
    }

    @DeleteMapping("/api/users/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteUser(
            @PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok(
            ApiResponse.ok("Utilisateur supprimé", null));
    }

    @PostMapping("/api/users/{email}/roles/{rolename}")
    public ResponseEntity<ApiResponse<Void>> addRoleToUser(
            @PathVariable String email,
            @PathVariable String rolename) {
        authService.addRoleToUser(email, rolename);
        return ResponseEntity.ok(
            ApiResponse.ok("Rôle " + rolename
                + " attribué à " + email, null));
    }
}
