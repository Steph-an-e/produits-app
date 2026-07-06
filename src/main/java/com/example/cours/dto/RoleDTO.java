package com.example.cours.dto;


public class RoleDTO {
    private Long id;
    private String role;
    private String type;

    public RoleDTO() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getRole() { return role; }
    public void setRole(String r) { this.role = r; }
    public String getType() { return type; }
    public void setType(String t) { this.type = t; }
}
