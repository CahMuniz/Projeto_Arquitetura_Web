package com.example.projeto_web.service;
import com.example.projeto_web.dto.PedidoEvenDTO;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class PedidoEmail {
    @Autowired
    private JavaMailSender mailSender;

    @KafkaListener(topics = "Loja-vendas-pedido-criado", groupId = "grupo-email" )
    public void escutarTopico(PedidoEvenDTO pedidoEvenDTO) {
        System.out.println("LOG INTERNO: Mensagem lida do Kafka para o pedido: "+pedidoEvenDTO.pedidoId());

        String assunto = "Confirmação de Pedido - Seu Pedido está a caminho";

        String corpo = String.format("Olá, %s!\n\n"+
                        "Seu pedido nº %d foi recebido com sucesso.\n"+
                        "Valor total: R$ %.2f\n\n" +
                        "Obrigado por comprar conosco!",
                pedidoEvenDTO.nomeCliente(),
                pedidoEvenDTO.pedidoId(),
                pedidoEvenDTO.valorTotal()
        );

         // Código que envia o E-mail Direto.

        SimpleMailMessage mensagem = new SimpleMailMessage();
        mensagem.setFrom("loja@roupassociais.com");
        mensagem.setTo(pedidoEvenDTO.emailCliente());
        mensagem.setSubject(assunto);
        mensagem.setText(corpo);

        mailSender.send(mensagem);
        System.out.println("E-mail enviado com sucesso para:"+pedidoEvenDTO.emailCliente());

    }
}
