package com.example.projeto_web.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "pedidos_compra")
public class PedidoDeCompra {

    @Id
    private String id;

    private String fornecedor;
    private String data;
    private String status;

    private List<ItemPedido> itens;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
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