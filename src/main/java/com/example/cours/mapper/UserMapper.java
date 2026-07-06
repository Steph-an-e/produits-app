package com.example.cours.mapper;

import com.example.cours.dto.UserDTO;
import com.example.cours.entities.User;
import org.mapstruct.*;
import java.util.List;

@Mapper(componentModel = "spring", uses = {RoleMapper.class})
public interface UserMapper {

    // PAS de @Mapping pour password ici !
    // UserDTO n'a pas de champ password, donc
    // MapStruct ne le mappe pas automatiquement.
    // Si on ajoutait @Mapping(target="password", ignore=true)
    // MapStruct donnerait ERREUR : "Unknown property password
    // in result type UserDTO"
    UserDTO toDTO(User user);

    // Ici target = User qui A un champ password
    @Mapping(target = "enabled", ignore = true)
    @Mapping(target = "password", ignore = true)
    User toEntity(UserDTO dto);

    List<UserDTO> toDTOList(List<User> users);

    @BeanMapping(nullValuePropertyMappingStrategy =
        NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "enabled", ignore = true)
    void updateFromDTO(UserDTO dto, @MappingTarget User user);
}
