package com.example.cours.services;

import com.example.cours.dto.UserDTO;
import java.util.List;

public interface UserService {
    UserDTO findById(Long id);
    List<UserDTO> findAll();
    UserDTO update(Long id, UserDTO dto);
    void deleteById(Long id);
}
