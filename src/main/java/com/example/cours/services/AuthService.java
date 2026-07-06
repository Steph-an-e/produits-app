package com.example.cours.services;

import com.example.cours.dto.request.RegistrationRequestDTO;
import com.example.cours.entities.*;
import java.util.Optional;

public interface AuthService {
    Optional<User> findUserByEmail(String email);
    User registerUser(RegistrationRequestDTO request);
    User saveUser(User user);
    Role addRole(Role role);
    User addRoleToUser(String email, String rolename);
}
