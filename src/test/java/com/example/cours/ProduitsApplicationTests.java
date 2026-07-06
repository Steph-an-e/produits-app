package com.example.cours;

import com.example.cours.entities.Produit;
import com.example.cours.repositorie.ProduitRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import org.junit.jupiter.api.*;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProduitsApplicationTests {

    @Autowired
    private ProduitRepository produitRepository;

    @Test
    @Order(1)
    public void testCreateProduit() {
        Produit p = new Produit();
        p.setNomProduit("iPhone 15");
        p.setPrixProduit(1299.99);
        produitRepository.save(p);
        System.out.println("Créé : " + p.getIdProduit());
    }

    @Test
    @Order(2)
    public void testFindAll() {
        produitRepository.findAll()
            .forEach(System.out::println);
    }

    @Test
    @Order(3)
    public void testFindById() {
        Produit p = produitRepository.findById(1L)
            .orElseThrow(() -> new RuntimeException(
                "Produit introuvable"));
        System.out.println("Trouvé : " + p);
    }

    @Test
    @Order(4)
    public void testUpdate() {
        Produit p = produitRepository.findById(1L)
            .orElseThrow(() -> new RuntimeException(
                "Produit introuvable"));
        p.setPrixProduit(1199.99);
        produitRepository.save(p);
        System.out.println("Modifié : " + p);
    }

    @Test
    @Order(5)
    public void testDelete() {
        produitRepository.deleteById(1L);
        System.out.println("Supprimé");
    }
}