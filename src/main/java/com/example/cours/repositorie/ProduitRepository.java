package com.example.cours.repositorie;

import com.example.cours.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
    List<Produit> findByNomProduit(String nom);
    List<Produit> findByNomProduitContains(String texte);
    List<Produit> findByPrixProduitGreaterThan(double prix);
    List<Produit> findByCategorieIdCat(Long idCat);
    List<Produit> findAllByOrderByNomProduitAsc();
    List<Produit> findAllByOrderByPrixProduitDesc();

    @Query("SELECT p FROM Produit p WHERE p.nomProduit LIKE %:nom% AND p.prixProduit > :prix")
    List<Produit> findByNomPrix(@Param("nom") String nom, @Param("prix") double prix);
}
