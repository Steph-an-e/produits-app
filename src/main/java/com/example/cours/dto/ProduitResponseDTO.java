package com.example.cours.dto;

import java.util.List;

public class ProduitResponseDTO {
    private Long id;
    private String designation;
    private Double prix;
    private Integer quantite;
    private String categorieNom;
    private Boolean actif;
    private Double prixTotal;
    private List<TagDTO> tags;

    public ProduitResponseDTO() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getDesignation() { return designation; }
    public void setDesignation(String d) { this.designation = d; }
    public Double getPrix() { return prix; }
    public void setPrix(Double p) { this.prix = p; }
    public Integer getQuantite() { return quantite; }
    public void setQuantite(Integer q) { this.quantite = q; }
    public String getCategorieNom() { return categorieNom; }
    public void setCategorieNom(String c) { this.categorieNom = c; }
    public Boolean getActif() { return actif; }
    public void setActif(Boolean a) { this.actif = a; }
    public Double getPrixTotal() { return prixTotal; }
    public void setPrixTotal(Double pt) { this.prixTotal = pt; }
    public List<TagDTO> getTags() { return tags; }
    public void setTags(List<TagDTO> t) { this.tags = t; }
}
