package com.example.category.service;

import com.example.category.dto.VitrineDTO;
import com.example.category.model.Produto;
import com.example.category.model.Vitrine;
import com.example.category.repository.ProdutoRepository;
import com.example.category.repository.VitrineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VitrineService {

    @Autowired
    private VitrineRepository vitrineRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Cacheable("vitrines-ativas")
    public List<VitrineDTO> listarAtivas() {
        return vitrineRepository.findByAtivaTrue().stream()
            .map(this::toDTO)
            .toList();
    }

    public Vitrine salvar(Vitrine vitrine) {
        // Valida se todos os produtos referenciados existem
        vitrine.getProdutoIds().forEach(pid ->
            produtoRepository.findById(pid)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado: " + pid))
        );
        return vitrineRepository.save(vitrine);
    }

    public Vitrine atualizar(String id, Vitrine vitrine) {
        if (!vitrineRepository.existsById(id))
            throw new RuntimeException("Vitrine não encontrada: " + id);
        vitrine.setId(id);
        return vitrineRepository.save(vitrine);
    }

    @CacheEvict(value = "vitrines-ativas", allEntries = true)
    public void desativar(String id) {
        Vitrine v = vitrineRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Vitrine não encontrada: " + id));
        v.setAtiva(false);
        vitrineRepository.save(v);
    }

    private VitrineDTO toDTO(Vitrine vitrine) {
        List<Produto> produtos = produtoRepository.findAllById(vitrine.getProdutoIds());
        return new VitrineDTO(vitrine.getTitulo(), vitrine.getTipo(), produtos);
    }
}
