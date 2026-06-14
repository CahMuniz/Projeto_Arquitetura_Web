package com.example.category.dto;

import java.util.List;

// Espelho do evento publicado pelo serviço principal via Kafka
public record PedidoEventDTO(
    String idPedido,
    String fornecedor,
    Double total,
    List<ItemEventDTO> itens
) {
    public record ItemEventDTO(
        String produtoId,
        int quantidade,
        int estoqueRestante  // campo necessário para atualizar disponibilidade no catalog
    ) {}
}
