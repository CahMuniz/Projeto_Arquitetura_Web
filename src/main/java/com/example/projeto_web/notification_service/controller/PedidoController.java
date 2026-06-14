package com.example.notification_service.controller;
import com.example.notification_service.model.Pedido;
import com.example.notification_service.repository.PedidoRepository;
import com.example.notification_service.service.EmailSenderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/notificacao")
public class PedidoController {
    private final PedidoRepository pedidoRepository;
    private final EmailSenderService emailSenderService;

    public PedidoController( PedidoRepository pedidoRepository, EmailSenderService emailSenderService){
        this.pedidoRepository = pedidoRepository;
        this.emailSenderService=emailSenderService;
    }
    @GetMapping("/historico")
    public  List<Pedido> listarHistorico(){
        return pedidoRepository.findAll();
    }
    @PostMapping("/reenviar/{id}")
    public ResponseEntity<String> reenviarEmail(@PathVariable Long id) {
        return pedidoRepository.findById(id)
                .map(pedido -> {
                    emailSenderService.enviarEmailConfirmacao(pedido);
                    return ResponseEntity.ok("E-mail de confirmação reenviado com sucesso para: " + pedido.getEmailCliente());
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
