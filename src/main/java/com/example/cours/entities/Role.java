package com.example.cours.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String role;
    private String type;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    public Role() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getRole() { return role; }
    public void setRole(String r) { this.role = r; }
    public String getType() { return type; }
    public void setType(String t) { this.type = t; }
    public List<User> getUsers() { return users; }
    public void setUsers(List<User> u) { this.users = u; }
}
