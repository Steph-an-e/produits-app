package com.example.cours.controller;

import com.example.cours.dto.RoleDTO;
import com.example.cours.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public List<RoleDTO> getAll() {
        return roleService.findAll();
    }

    @PostMapping
    public ResponseEntity<RoleDTO> create(@RequestBody RoleDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(roleService.save(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        roleService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
