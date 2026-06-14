package com.example.notification_service.service;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.example.notification_service.model.Pedido;

@Service
public class PedidoListenerService {
    private final EmailSenderService emailSenderService;
    public PedidoListenerService(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }
    @KafkaListener(
            topics = "pedido-topico",
            groupId = "group_notification",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void ouvirNotificacao(Pedido pedido){
        System.out.println("====== 1. INFRA: Mensagem capturada no Kafka (Ouvindo) ======");

        this.emailSenderService.processarNotificacao(pedido);
    }

}
