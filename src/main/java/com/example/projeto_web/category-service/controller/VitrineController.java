package com.example.category.controller;

import com.example.category.dto.VitrineDTO;
import com.example.category.model.Vitrine;
import com.example.category.service.VitrineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalog/vitrines")
public class VitrineController {

    @Autowired
    private VitrineService vitrineService;

    @GetMapping
    public List<VitrineDTO> listar() {
        return vitrineService.listarAtivas();
    }

    @PostMapping
    public ResponseEntity<Vitrine> criar(@RequestBody Vitrine vitrine) {
        return ResponseEntity.status(201).body(vitrineService.salvar(vitrine));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vitrine> atualizar(@PathVariable String id,
                                             @RequestBody Vitrine vitrine) {
        return ResponseEntity.ok(vitrineService.atualizar(id, vitrine));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> desativar(@PathVariable String id) {
        vitrineService.desativar(id);
        return ResponseEntity.noContent().build();
    }
}
