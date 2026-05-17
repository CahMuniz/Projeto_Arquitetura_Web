package com.example.projeto_web.Model;
import com.example.projeto_web.Model.PedidodeCompraEvent;

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

}
