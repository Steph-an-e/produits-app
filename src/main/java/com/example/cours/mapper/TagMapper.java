package com.example.cours.mapper;

import com.example.cours.dto.TagDTO;
import com.example.cours.entities.Tag;
import org.mapstruct.*;
import java.util.List;

@Mapper(componentModel = "spring")
public interface TagMapper {
    TagDTO toDTO(Tag tag);

    @Mapping(target = "produits", ignore = true)
    Tag toEntity(TagDTO dto);

    List<TagDTO> toDTOList(List<Tag> tags);
}
