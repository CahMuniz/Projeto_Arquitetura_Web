package com.example.category.repository;

import com.example.category.model.Produto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends MongoRepository<Produto, String> {
    List<Produto> findByCategoriaId(String categoriaId);
    List<Produto> findByDisponivelTrue();
    List<Produto> findByTipo(String tipo);
    List<Produto> findByNomeContainingIgnoreCase(String nome);
    List<Produto> findByCategoriaIdAndDisponivelTrue(String categoriaId);
}
