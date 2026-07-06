package com.example.cours.services;

import com.example.cours.dto.*;
import java.util.List;

public interface ProduitService {
    ProduitResponseDTO createProduit(ProduitCreateDTO dto);
    ProduitResponseDTO getProduitById(Long id);
    List<ProduitResponseDTO> getAllProduits();
    ProduitResponseDTO updateProduit(Long id, ProduitCreateDTO dto);
    void deleteProduit(Long id);
    List<ProduitResponseDTO> searchByDesignation(String text);
    PageDTO<ProduitResponseDTO> getAllProduitsPaginated(
        int page, int size, String sortBy, String direction);
    ProduitResponseDTO addTagToProduit(Long produitId, Long tagId);
    ProduitResponseDTO removeTagFromProduit(Long produitId, Long tagId);
}
