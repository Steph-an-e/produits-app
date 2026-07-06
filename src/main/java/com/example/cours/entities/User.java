package com.example.cours.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;
    private String nom;
    private String prenom;
    @Column(unique = true)
    private String email;
    private String password;
    private Boolean enabled = true;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

    public User() {}

    public Long getIdUser() { return idUser; }
    public void setIdUser(Long id) { this.idUser = id; }
    public String getNom() { return nom; }
    public void setNom(String n) { this.nom = n; }
    public String getPrenom() { return prenom; }
    public void setPrenom(String p) { this.prenom = p; }
    public String getEmail() { return email; }
    public void setEmail(String e) { this.email = e; }
    public String getPassword() { return password; }
    public void setPassword(String p) { this.password = p; }
    public Boolean getEnabled() { return enabled; }
    public void setEnabled(Boolean e) { this.enabled = e; }
    public List<Role> getRoles() { return roles; }
    public void setRoles(List<Role> r) { this.roles = r; }
}
