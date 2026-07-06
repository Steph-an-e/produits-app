package com.example.cours.dto;


import jakarta.validation.constraints.*;

public class TagDTO {
    private Long id;
    @NotBlank(message = "Nom obligatoire")
    private String nom;
    private String couleur;

    public TagDTO() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String n) { this.nom = n; }
    public String getCouleur() { return couleur; }
    public void setCouleur(String c) { this.couleur = c; }
}
