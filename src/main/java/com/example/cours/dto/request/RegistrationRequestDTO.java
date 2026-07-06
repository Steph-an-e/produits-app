package com.example.cours.dto.request;

import jakarta.validation.constraints.*;

public class RegistrationRequestDTO {
    @NotBlank(message = "Nom obligatoire")
    private String nom;
    @NotBlank(message = "Prénom obligatoire")
    private String prenom;
    @NotBlank @Size(min = 6, message = "6 caractères min")
    private String password;
    @NotBlank @Email(message = "Format email invalide")
    private String email;

    public RegistrationRequestDTO() {}

    public String getNom() { return nom; }
    public void setNom(String n) { this.nom = n; }
    public String getPrenom() { return prenom; }
    public void setPrenom(String p) { this.prenom = p; }
    public String getPassword() { return password; }
    public void setPassword(String p) { this.password = p; }
    public String getEmail() { return email; }
    public void setEmail(String e) { this.email = e; }
}
