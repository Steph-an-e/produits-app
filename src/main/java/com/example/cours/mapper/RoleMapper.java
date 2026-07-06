package com.example.cours.mapper;

import com.example.cours.dto.RoleDTO;
import com.example.cours.entities.Role;
import org.mapstruct.*;
import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleDTO toDTO(Role role);

    @Mapping(target = "users", ignore = true)
    Role toEntity(RoleDTO dto);

    List<RoleDTO> toDTOList(List<Role> roles);
}
