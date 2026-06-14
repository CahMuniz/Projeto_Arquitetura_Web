package com.example.category.repository;

import com.example.category.model.Vitrine;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VitrineRepository extends MongoRepository<Vitrine, String> {
    List<Vitrine> findByAtivaTrue();
    List<Vitrine> findByTipo(String tipo);
    Optional<Vitrine> findByTipoAndAtivaTrue(String tipo);
}
