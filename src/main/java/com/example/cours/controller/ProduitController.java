package com.example.cours.controller;

import com.example.cours.dto.*;
import com.example.cours.services.ProduitService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/produits")
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    @GetMapping
    public ResponseEntity<ApiResponse<PageDTO<ProduitResponseDTO>>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "idProduit") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {
        return ResponseEntity.ok(ApiResponse.ok(
            produitService.getAllProduitsPaginated(page, size, sortBy, direction)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ProduitResponseDTO>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.ok(produitService.getProduitById(id)));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ProduitResponseDTO>> create(
            @Valid @RequestBody ProduitCreateDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(ApiResponse.created(produitService.createProduit(dto)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ProduitResponseDTO>> update(
            @PathVariable Long id, @Valid @RequestBody ProduitCreateDTO dto) {
        return ResponseEntity.ok(ApiResponse.ok(produitService.updateProduit(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        produitService.deleteProduit(id);
        return ResponseEntity.ok(ApiResponse.ok("Produit supprimé", null));
    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<List<ProduitResponseDTO>>> search(
            @RequestParam String nom) {
        return ResponseEntity.ok(ApiResponse.ok(produitService.searchByDesignation(nom)));
    }

    @PostMapping("/{produitId}/tags/{tagId}")
    public ResponseEntity<ApiResponse<ProduitResponseDTO>> addTag(
            @PathVariable Long produitId, @PathVariable Long tagId) {
        return ResponseEntity.ok(ApiResponse.ok("Tag ajouté",
            produitService.addTagToProduit(produitId, tagId)));
    }

    @DeleteMapping("/{produitId}/tags/{tagId}")
    public ResponseEntity<ApiResponse<ProduitResponseDTO>> removeTag(
            @PathVariable Long produitId, @PathVariable Long tagId) {
        return ResponseEntity.ok(ApiResponse.ok("Tag retiré",
            produitService.removeTagFromProduit(produitId, tagId)));
    }
}
