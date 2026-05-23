package com.example.projeto_web.controller;

import com.example.projeto_web.Model.ProdutoEntity;
import com.example.projeto_web.Service.ProdutoService;
import com.example.projeto_web.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;
    // ✅ Sem ProdutoRepository aqui — tudo passa pelo Service

    @GetMapping
    public List<ProdutoEntity> listar() {
        return produtoService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<ProdutoEntity> criar(@RequestBody ProdutoEntity produto) {
        return ResponseEntity.status(201).body(produtoService.salvar(produto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoEntity> atualizar(@PathVariable String id,
                                                   @RequestBody ProdutoEntity produto) {
        produto.setId(id);
        // ✅ Service verifica se o ID existe antes de salvar
        return ResponseEntity.ok(produtoService.atualizar(id, produto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        produtoService.deletar(id); // ✅ delega ao Service
        return ResponseEntity.noContent().build();
    }
}