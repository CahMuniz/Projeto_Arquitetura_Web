package com.example.projeto_web.Repository;

import com.example.projeto_web.Model.ProdutoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProdutoRepository extends MongoRepository<ProdutoEntity, String> {

    // Buscar por categoria (ex: "Streetwear", "Terno")
    List<ProdutoEntity> findByCategoria(String categoria);

    // Buscar por tipo (ex: "conjunto", "avulso")
    List<ProdutoEntity> findByTipo(String tipo);

    // Buscar o par de uma peça de conjunto (para a Regra de Grade Órfã)
    List<ProdutoEntity> findByParId(String parId);

    // Buscar produtos com estoque disponível
    List<ProdutoEntity> findByEstoqueGreaterThan(int quantidade);

    // Buscar por nome (útil para a busca no frontend)
    List<ProdutoEntity> findByNomeContainingIgnoreCase(String nome);
}