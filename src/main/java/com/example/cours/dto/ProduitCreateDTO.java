package com.example.cours.dto;

import jakarta.validation.constraints.*;

public class ProduitCreateDTO {
    @NotBlank(message = "La désignation est obligatoire")
    @Size(min = 2, max = 100)
    private String designation;

    @NotNull(message = "Le prix est obligatoire")
    @Positive(message = "Le prix doit être positif")
    private Double prix;

    @Min(value = 0, message = "Quantité négative interdite")
    private Integer quantite;

    private Long categorieId;

    public String getDesignation() { return designation; }
    public void setDesignation(String d) { this.designation = d; }
    public Double getPrix() { return prix; }
    public void setPrix(Double p) { this.prix = p; }
    public Integer getQuantite() { return quantite; }
    public void setQuantite(Integer q) { this.quantite = q; }
    public Long getCategorieId() { return categorieId; }
    public void setCategorieId(Long c) { this.categorieId = c; }
}
