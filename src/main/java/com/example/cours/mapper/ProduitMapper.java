package com.example.cours.mapper;

import com.example.cours.dto.*;
import com.example.cours.entities.Produit;
import org.mapstruct.*;
import java.util.List;

@Mapper(componentModel = "spring", uses = {TagMapper.class})
public interface ProduitMapper {

    @Mapping(source = "idProduit", target = "id")
    @Mapping(source = "nomProduit", target = "designation")
    @Mapping(source = "prixProduit", target = "prix")
    @Mapping(source = "categorie.nomCat", target = "categorieNom")
    @Mapping(target = "prixTotal",
        expression = "java(calculerPrixTotal(produit))")
    ProduitResponseDTO toResponseDTO(Produit produit);

    @Mapping(source = "designation", target = "nomProduit")
    @Mapping(source = "prix", target = "prixProduit")
    @Mapping(target = "idProduit", ignore = true)
    @Mapping(target = "categorie", ignore = true)
    @Mapping(target = "dateCreation", ignore = true)
    @Mapping(target = "actif", constant = "true")
    @Mapping(target = "tags", ignore = true)
    Produit toEntity(ProduitCreateDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy =
        NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "designation", target = "nomProduit")
    @Mapping(source = "prix", target = "prixProduit")
    @Mapping(target = "idProduit", ignore = true)
    @Mapping(target = "categorie", ignore = true)
    @Mapping(target = "tags", ignore = true)
    void updateEntity(ProduitCreateDTO dto, @MappingTarget Produit produit);

    default Double calculerPrixTotal(Produit p) {
        if (p.getPrixProduit() == null
                || p.getQuantite() == null)
            return 0.0;
        return p.getPrixProduit() * p.getQuantite();
    }

    List<ProduitResponseDTO> toDTOList(List<Produit> list);
}
