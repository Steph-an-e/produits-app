package com.example.cours.repositorie;
import com.example.cours.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CategorieRepository extends JpaRepository<Categorie, Long> {
	
}
