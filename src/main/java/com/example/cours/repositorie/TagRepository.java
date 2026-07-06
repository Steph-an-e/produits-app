package com.example.cours.repositorie;
import com.example.cours.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface TagRepository extends JpaRepository<Tag, Long> {
    Optional<Tag> findByNom(String nom);
    boolean existsByNom(String nom);
}
