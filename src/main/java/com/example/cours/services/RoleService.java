package com.example.cours.services;

import com.example.cours.dto.RoleDTO;
import java.util.List;

public interface RoleService {
    RoleDTO findById(Long id);
    List<RoleDTO> findAll();
    RoleDTO save(RoleDTO dto);
    void deleteById(Long id);
}
