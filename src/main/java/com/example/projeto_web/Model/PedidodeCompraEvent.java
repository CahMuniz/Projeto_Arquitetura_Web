package com.example.projeto_web.Model;
import com.example.projeto_web.Model.PedidodeCompraEvent;

public class PedidodeCompraEvent {
    private String idPedido;
    private String fornecedor;
    private Double total;
    private String emailCliente;  // necessário para o PedidoEmail
    private String nomeCliente;   // necessário para o PedidoEmail

    // getters e setters...


    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
}
