package com.example.category.kafka;

import com.example.category.dto.PedidoEventDTO;
import com.example.category.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class EstoqueEventConsumer {

    @Autowired
    private ProdutoService produtoService;

    // Escuta o mesmo tópico publicado pelo serviço principal
    // group-id diferente de "grupo-email" para receber as mensagens de forma independente
    @KafkaListener(topics = "loja-pedido-criado", groupId = "grupo-catalog")
    public void consumir(PedidoEventDTO evento) {
        if (evento.itens() == null) return;

        evento.itens().forEach(item ->
            produtoService.atualizarDisponibilidade(
                item.produtoId(),
                item.estoqueRestante()
            )
        );
    }
}
