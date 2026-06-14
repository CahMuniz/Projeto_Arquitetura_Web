package com.example.payment_service.controller;
import com.example.payment_service.model.Pedido;
import com.example.payment_service.service.PaymentProducerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/pagamentos")
public class PedidoController {
    private PaymentProducerService producerService;

    public PedidoController(PaymentProducerService producerService)
    {
        this.producerService = producerService;
    }
    @PostMapping("/simular")
    public ResponseEntity<String> simularPedido(@RequestBody Pedido pedido) {
        System.out.println("\n🌐 [CONTROLLER] Processamento manual via API HTTP recebido.");
        pedido.setStatusPagamento("APROVADO");

        producerService.enviarPagamentoAprovado(pedido);
        return ResponseEntity.ok("Pagamento processado manualmente e enviado ao Kafka!");
    }
}
