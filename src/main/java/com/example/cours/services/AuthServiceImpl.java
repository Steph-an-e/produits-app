package com.example.cours.services;

import com.example.cours.dto.request.RegistrationRequestDTO;
import com.example.cours.entities.*;
import com.example.cours.exception.*;
import com.example.cours.repositorie.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

@Service
@Transactional
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User registerUser(RegistrationRequestDTO req) {
        if (userRepository.existsByEmail(req.getEmail()))
            throw new EmailAlreadyExistsException("Email déjà utilisé");
        User user = new User();
        user.setNom(req.getNom());
        user.setPrenom(req.getPrenom());
        user.setEmail(req.getEmail());
        user.setPassword(passwordEncoder.encode(req.getPassword()));
        user.setEnabled(true);
        Role userRole = roleRepository.findByRole("USER")
            .orElseThrow(() -> new ResourceNotFoundException(
                "Rôle USER introuvable"));
        user.setRoles(new ArrayList<>(List.of(userRole)));
        return userRepository.save(user);
    }

    @Override
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if (user.getRoles() == null) user.setRoles(new ArrayList<>());
        return userRepository.save(user);
    }

    @Override
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public User addRoleToUser(String email, String rolename) {
        User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new ResourceNotFoundException(
                "User introuvable"));
        Role role = roleRepository.findByRole(rolename)
            .orElseThrow(() -> new ResourceNotFoundException(
                "Role introuvable"));
        if (user.getRoles() == null) user.setRoles(new ArrayList<>());
        if (!user.getRoles().contains(role)) user.getRoles().add(role);
        return userRepository.save(user);
    }
}
