package com.example.category.service;

import com.example.category.model.Categoria;
import com.example.category.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> listarAtivas() {
        return categoriaRepository.findByAtiva(true);
    }

    public List<Categoria> listarTodas() {
        return categoriaRepository.findAll();
    }

    public Categoria salvar(Categoria categoria) {
        if (categoria.getNome() == null || categoria.getNome().isBlank())
            throw new IllegalArgumentException("Nome da categoria é obrigatório");
        return categoriaRepository.save(categoria);
    }

    public Categoria atualizar(String id, Categoria categoria) {
        if (!categoriaRepository.existsById(id))
            throw new RuntimeException("Categoria não encontrada: " + id);
        categoria.setId(id);
        return categoriaRepository.save(categoria);
    }

    public void desativar(String id) {
        Categoria c = categoriaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Categoria não encontrada: " + id));
        c.setAtiva(false);
        categoriaRepository.save(c);
    }
}
