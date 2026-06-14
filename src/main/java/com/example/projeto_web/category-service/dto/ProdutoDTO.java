package com.example.category.dto;

import java.util.List;

public record ProdutoDTO(
    String id,
    String nome,
    Double preco,
    List<String> tamanhos,
    String categoriaId,
    boolean disponivel
) {}
