package com.example.category.controller;

import com.example.category.model.Produto;
import com.example.category.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalog/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> listar() {
        return produtoService.listarDisponiveis();
    }

    @GetMapping("/categoria/{categoriaId}")
    public List<Produto> porCategoria(@PathVariable String categoriaId) {
        return produtoService.listarPorCategoria(categoriaId);
    }

    @GetMapping("/busca")
    public List<Produto> buscar(@RequestParam String nome) {
        return produtoService.buscarPorNome(nome);
    }

    @PostMapping
    public ResponseEntity<Produto> criar(@RequestBody Produto produto) {
        return ResponseEntity.status(201).body(produtoService.salvar(produto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@PathVariable String id,
                                             @RequestBody Produto produto) {
        return ResponseEntity.ok(produtoService.atualizar(id, produto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        produtoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
