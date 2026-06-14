package com.example.notification_service.service;

import org.springframework.stereotype.Service;
import com.example.notification_service.model.Pedido;
import com.example.notification_service.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.kafka.annotation.KafkaListener;

@Service
public class EmailSenderService {
    private JavaMailSender MailSender;
    private final PedidoRepository pedidoRepository;

    @Value("${spring.mail.username}")
    private String emailRemetente;

    public EmailSenderService(JavaMailSender mailSender, PedidoRepository pedidoRepository) {
        this.MailSender = mailSender;
        this.pedidoRepository = pedidoRepository;
    }

    @KafkaListener(topics = "lojavintage-pedidos", groupId = "group_notification_final")
    public void processarNotificacao(Pedido pedido) {
        try {

            this.pedidoRepository.save(pedido);


            this.enviarEmailConfirmacao(pedido);

        } catch (Exception e) {
            System.out.println("Erro ao processar o pedido: " + e.getMessage());
        }
    }

    public void enviarEmailConfirmacao(Pedido pedido) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailRemetente);
            message.setTo(pedido.getEmailCliente());
            message.setSubject("Confirmação de Pedido - Loja Vintage");

            String textoEmail = String.format(
                    "Olá, %s!\n\nSeu pedido nº %d foi recebido.\nProduto: %s\nValor: R$ %.2f",
                    pedido.getNomeCliente(), pedido.getPedidoId(),
                    pedido.getDescricaoProduto(), pedido.getValorTotal()
            );
            message.setText(textoEmail);


            MailSender.send(message);


            System.out.println("🟢 STATUS: E-MAIL ENVIADO COM SUCESSO");

        } catch (Exception e) {

            System.out.println("🔴 STATUS: E-MAIL NÃO ENVIADO (Falha no disparo do servidor)");
        }
    }
}