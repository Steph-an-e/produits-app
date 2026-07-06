package com.example.cours.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCat;
    private String nomCat;
    private String descriptionCat;

    @OneToMany(mappedBy = "categorie")
    private List<Produit> produits;

    public Categorie() {}

    public Categorie(String nomCat, String desc) {
        this.nomCat = nomCat;
        this.descriptionCat = desc;
    }

    public Long getIdCat() { return idCat; }
    public void setIdCat(Long id) { this.idCat = id; }
    public String getNomCat() { return nomCat; }
    public void setNomCat(String n) { this.nomCat = n; }
    public String getDescriptionCat() { return descriptionCat; }
    public void setDescriptionCat(String d) { this.descriptionCat = d; }
    public List<Produit> getProduits() { return produits; }
    public void setProduits(List<Produit> p) { this.produits = p; }
}
