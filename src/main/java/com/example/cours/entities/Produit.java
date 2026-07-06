package com.example.cours.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduit;
    private String nomProduit;
    private Double prixProduit;       // Double pas double
    private Integer quantite;         // Integer pas int
    private LocalDateTime dateCreation;
    private Boolean actif;            // Boolean pas boolean

    @ManyToOne
    private Categorie categorie;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "produit_tags",
        joinColumns = @JoinColumn(name = "produit_id"),
        inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> tags;

    public Produit() {}

    public Long getIdProduit() { return idProduit; }
    public void setIdProduit(Long id) { this.idProduit = id; }
    public String getNomProduit() { return nomProduit; }
    public void setNomProduit(String n) { this.nomProduit = n; }
    public Double getPrixProduit() { return prixProduit; }
    public void setPrixProduit(Double p) { this.prixProduit = p; }
    public Integer getQuantite() { return quantite; }
    public void setQuantite(Integer q) { this.quantite = q; }
    public LocalDateTime getDateCreation() { return dateCreation; }
    public void setDateCreation(LocalDateTime d) { this.dateCreation = d; }
    public Boolean getActif() { return actif; }
    public void setActif(Boolean a) { this.actif = a; }
    public Categorie getCategorie() { return categorie; }
    public void setCategorie(Categorie c) { this.categorie = c; }
    public List<Tag> getTags() { return tags; }
    public void setTags(List<Tag> t) { this.tags = t; }

    @Override
    public String toString() {
        return "Produit [id=" + idProduit
            + ", nom=" + nomProduit
            + ", prix=" + prixProduit + "]";
    }
}
