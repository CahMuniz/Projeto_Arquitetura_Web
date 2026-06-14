package com.example.category.dto;

import com.example.category.model.Produto;

import java.util.List;

public record VitrineDTO(
    String titulo,
    String tipo,
    List<Produto> produtos
) {}
