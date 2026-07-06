package com.example.cours.services;

import com.example.cours.dto.RoleDTO;
import com.example.cours.entities.Role;
import com.example.cours.exception.ResourceNotFoundException;
import com.example.cours.mapper.RoleMapper;
import com.example.cours.repositorie.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public RoleDTO findById(Long id) {
        Role role = roleRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException(
                "Role introuvable"));
        return roleMapper.toDTO(role);
    }

    @Override
    public List<RoleDTO> findAll() {
        return roleMapper.toDTOList(roleRepository.findAll());
    }

    @Override
    public RoleDTO save(RoleDTO dto) {
        return roleMapper.toDTO(
            roleRepository.save(roleMapper.toEntity(dto)));
    }

    @Override
    public void deleteById(Long id) {
        if (!roleRepository.existsById(id))
            throw new ResourceNotFoundException("Role introuvable");
        roleRepository.deleteById(id);
    }
}
