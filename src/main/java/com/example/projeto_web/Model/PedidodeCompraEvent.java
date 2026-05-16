package com.example.projeto_web.Model;

public class PedidodeCompraEvent {

    private String idPedido;
    private String fornecedor;
    private Double total;

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

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getTotal() {

        Double total = 0.0;

        if (itens != null) {

            for (ItemPedido item : itens) {

                if (item.getQuantidade() != null
                        && item.getValorUnitario() != null) {

                    total = total + (item.getQuantidade() * item.getValorUnitario());
                }
            }
        }

        return total;
    }
}
