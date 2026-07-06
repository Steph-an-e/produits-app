package com.example.cours.security;

import com.example.cours.entities.User;
import com.example.cours.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private AuthService authService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = authService.findUserByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException("Utilisateur introuvable : " + email));
        List<GrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role ->
            authorities.add(new SimpleGrantedAuthority(role.getRole())));
        return new org.springframework.security.core.userdetails.User(
            user.getEmail(), user.getPassword(), authorities);
    }
}
