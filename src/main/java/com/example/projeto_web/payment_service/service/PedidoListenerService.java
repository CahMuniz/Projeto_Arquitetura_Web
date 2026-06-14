package com.example.payment_service.service;
import com.example.payment_service.model.Pedido;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
@Service
public class PedidoListenerService {
    private final PaymentProducerService producerService;

    public PedidoListenerService(PaymentProducerService producerService) {
        this.producerService = producerService;
    }
    @KafkaListener(topics = "lojavintage-vendas-novas", groupId = "group_payment_vintage")
    public void consumirNovaVenda(Pedido pedido) {
        System.out.println("\n📥 [LISTENER SERVICE] Nova venda recebida para pagamento! ID: " + pedido.getPedidoID());

        pedido.setStatusPagamento("APROVADO");
        System.out.println("✅ [LISTENER SERVICE] Cobrança efetuada com sucesso para: " + pedido.getNomeCliente());

        producerService.enviarPagamentoAprovado(pedido);
    }
}
