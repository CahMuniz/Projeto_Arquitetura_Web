package com.example.category.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "produtos")
public class Produto {

    @Id
    private String id;
    private String nome;
    private String descricao;
    private Double preco;
    private Integer estoque;
    private List<String> tamanhos;   // ["P", "M", "G", "GG"]
    private String categoriaId;      // referência à Categoria
    private String tipo;             // "conjunto" ou "avulso"
    private String parId;            // ID do par para Regra de Grade Órfã
    private List<String> imagensUrl;
    private boolean disponivel;      // false quando estoque = 0

    public Produto() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Double getPreco() { return preco; }
    public void setPreco(Double preco) { this.preco = preco; }

    public Integer getEstoque() { return estoque; }
    public void setEstoque(Integer estoque) { this.estoque = estoque; }

    public List<String> getTamanhos() { return tamanhos; }
    public void setTamanhos(List<String> tamanhos) { this.tamanhos = tamanhos; }

    public String getCategoriaId() { return categoriaId; }
    public void setCategoriaId(String categoriaId) { this.categoriaId = categoriaId; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getParId() { return parId; }
    public void setParId(String parId) { this.parId = parId; }

    public List<String> getImagensUrl() { return imagensUrl; }
    public void setImagensUrl(List<String> imagensUrl) { this.imagensUrl = imagensUrl; }

    public boolean isDisponivel() { return disponivel; }
    public void setDisponivel(boolean disponivel) { this.disponivel = disponivel; }
}
