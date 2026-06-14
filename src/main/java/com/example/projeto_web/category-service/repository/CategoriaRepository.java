package com.example.category.repository;

import com.example.category.model.Categoria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoriaRepository extends MongoRepository<Categoria, String> {
    List<Categoria> findByAtiva(boolean ativa);
    Optional<Categoria> findByNome(String nome);
}
