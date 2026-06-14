package com.example.payment_service.service;
import com.example.payment_service.model.Pedido;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentProducerService {
    private KafkaTemplate<String, Object> kafkaTemplate;

    public PaymentProducerService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    public void enviarPedido(Pedido pedido){
        kafkaTemplate.send("Casa do Terno- pagamento-aprovado", pedido);
        System.out.println("📣 [PRODUCER SERVICE] Pedido " + pedido.getPedidoID() + " enviado para a fila de aprovados.");
    }

    public void enviarPagamentoAprovado(Pedido pedido) {
    }
}
