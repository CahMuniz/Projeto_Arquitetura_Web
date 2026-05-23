package com.example.projeto_web.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "produtos")
public class ProdutoEntity {

    @Id
    private String id;

    private String nome;
    private Double preco;
    private Integer estoque;
    private List<String> tamanhos; // ["P", "M", "G", "GG"]
    private String categoria;      // "Streetwear", "Terno", "Casual"
    private String tipo;           // "conjunto" ou "avulso"
    private String parId;          // ID do par (para regra de grade órfã)

    // getters e setters...


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public List<String> getTamanhos() {
        return tamanhos;
    }

    public void setTamanhos(List<String> tamanhos) {
        this.tamanhos = tamanhos;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getParId() {
        return parId;
    }

    public void setParId(String parId) {
        this.parId = parId;
    }
}
