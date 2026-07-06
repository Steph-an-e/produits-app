package com.example.cours.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nom;
    private String couleur;

    @ManyToMany(mappedBy = "tags")
    private List<Produit> produits;

    public Tag() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String n) { this.nom = n; }
    public String getCouleur() { return couleur; }
    public void setCouleur(String c) { this.couleur = c; }
    public List<Produit> getProduits() { return produits; }
    public void setProduits(List<Produit> p) { this.produits = p; }
}
