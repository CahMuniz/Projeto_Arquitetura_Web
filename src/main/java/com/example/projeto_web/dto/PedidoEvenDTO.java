package com.example.projeto_web.dto;
import java.math.BigDecimal;

public record PedidoEvenDTO(
        String emailCliente,
        String nomeCliente,
        Long pedidoId,
        BigDecimal valorTotal
) {}
