package com.example.payment_service.model;

import java.math.BigDecimal;

public class Pedido {
    private Long pedidoID;
    private String nomeCliente;
    private String emailCliente;
    private String descricaoProduto;
    private String productName;
    private BigDecimal price;
    private double valorTotal;
    private String statusPagamento;

    // Getters e Setters
    public Long getPedidoID() { return pedidoID; }
    public void setPedidoID(Long pedidoID) { this.pedidoID = pedidoID; }

    public String getNomeCliente() { return nomeCliente; }
    public void setNomeCliente(String nomeCliente) { this.nomeCliente = nomeCliente; }

    public String getEmailCliente() { return emailCliente; }
    public void setEmailCliente(String emailCliente) { this.emailCliente = emailCliente; }

    public String getDescricaoProduto() { return descricaoProduto; }
    public void setDescricaoProduto(String descricaoProduto) { this.descricaoProduto = descricaoProduto; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public double getValorTotal() { return valorTotal; }
    public void setValorTotal(double valorTotal) { this.valorTotal = valorTotal; }

    public String getStatusPagamento() { return statusPagamento; }
    public void setStatusPagamento(String statusPagamento) { this.statusPagamento = statusPagamento; }
}