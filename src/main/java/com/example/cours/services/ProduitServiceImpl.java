package com.example.cours.services;

import com.example.cours.dto.*;
import com.example.cours.entities.*;
import com.example.cours.exception.ResourceNotFoundException;
import com.example.cours.mapper.ProduitMapper;
import com.example.cours.repositorie.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProduitServiceImpl implements ProduitService {

    @Autowired
    private ProduitRepository produitRepository;
    @Autowired
    private CategorieRepository categorieRepository;
    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private ProduitMapper produitMapper;

    @Override
    public ProduitResponseDTO createProduit(ProduitCreateDTO dto) {
        Produit p = produitMapper.toEntity(dto);
        p.setDateCreation(LocalDateTime.now());
        if (dto.getCategorieId() != null) {
            Categorie cat = categorieRepository
                .findById(dto.getCategorieId())
                .orElseThrow(() -> new ResourceNotFoundException(
                    "Catégorie introuvable : " + dto.getCategorieId()));
            p.setCategorie(cat);
        }
        return produitMapper.toResponseDTO(produitRepository.save(p));
    }

    @Override
    @Transactional(readOnly = true)
    public ProduitResponseDTO getProduitById(Long id) {
        Produit p = produitRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException(
                "Produit introuvable avec id : " + id));
        return produitMapper.toResponseDTO(p);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProduitResponseDTO> getAllProduits() {
        return produitMapper.toDTOList(produitRepository.findAll());
    }

    @Override
    public ProduitResponseDTO updateProduit(Long id, ProduitCreateDTO dto) {
        Produit existing = produitRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException(
                "Produit introuvable avec id : " + id));
        produitMapper.updateEntity(dto, existing);
        return produitMapper.toResponseDTO(produitRepository.save(existing));
    }

    @Override
    public void deleteProduit(Long id) {
        if (!produitRepository.existsById(id))
            throw new ResourceNotFoundException(
                "Produit introuvable avec id : " + id);
        produitRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProduitResponseDTO> searchByDesignation(String text) {
        return produitMapper.toDTOList(
            produitRepository.findByNomProduitContains(text));
    }

    @Override
    @Transactional(readOnly = true)
    public PageDTO<ProduitResponseDTO> getAllProduitsPaginated(
            int page, int size, String sortBy, String dir) {
        Sort sort = dir.equalsIgnoreCase("desc")
            ? Sort.by(sortBy).descending()
            : Sort.by(sortBy).ascending();
        Page<Produit> result = produitRepository.findAll(
            PageRequest.of(page, size, sort));
        return new PageDTO<>(
            produitMapper.toDTOList(result.getContent()),
            result.getNumber(), result.getSize(),
            result.getTotalElements(), result.getTotalPages(),
            result.isFirst(), result.isLast());
    }

    @Override
    public ProduitResponseDTO addTagToProduit(Long produitId, Long tagId) {
        Produit p = produitRepository.findById(produitId)
            .orElseThrow(() -> new ResourceNotFoundException("Produit introuvable"));
        Tag tag = tagRepository.findById(tagId)
            .orElseThrow(() -> new ResourceNotFoundException("Tag introuvable"));
        if (p.getTags() == null) p.setTags(new ArrayList<>());
        if (!p.getTags().contains(tag)) p.getTags().add(tag);
        return produitMapper.toResponseDTO(produitRepository.save(p));
    }

    @Override
    public ProduitResponseDTO removeTagFromProduit(Long produitId, Long tagId) {
        Produit p = produitRepository.findById(produitId)
            .orElseThrow(() -> new ResourceNotFoundException("Produit introuvable"));
        Tag tag = tagRepository.findById(tagId)
            .orElseThrow(() -> new ResourceNotFoundException("Tag introuvable"));
        if (p.getTags() != null) p.getTags().remove(tag);
        return produitMapper.toResponseDTO(produitRepository.save(p));
    }
}
