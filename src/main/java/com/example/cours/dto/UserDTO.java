package com.example.cours.dto;


import java.util.List;

public class UserDTO {
    private Long idUser;
    private String nom;
    private String prenom;
    private String email;
    // PAS DE PASSWORD !
    private List<RoleDTO> roles;

    public UserDTO() {}

    public Long getIdUser() { return idUser; }
    public void setIdUser(Long id) { this.idUser = id; }
    public String getNom() { return nom; }
    public void setNom(String n) { this.nom = n; }
    public String getPrenom() { return prenom; }
    public void setPrenom(String p) { this.prenom = p; }
    public String getEmail() { return email; }
    public void setEmail(String e) { this.email = e; }
    public List<RoleDTO> getRoles() { return roles; }
    public void setRoles(List<RoleDTO> r) { this.roles = r; }
}
