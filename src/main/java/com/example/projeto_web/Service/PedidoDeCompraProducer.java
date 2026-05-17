package com.example.projeto_web.Service;

import com.example.projeto_web.Model.PedidodeCompraEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class PedidoDeCompraProducer {

    private final KafkaTemplate<String, PedidodeCompraEvent> kafkaTemplate;

    public PedidoDeCompraProducer(KafkaTemplate<String, PedidodeCompraEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void enviar(PedidodeCompraEvent evento) {
        kafkaTemplate.send("pedido-criado", evento.getIdPedido(), evento);
    }
}
