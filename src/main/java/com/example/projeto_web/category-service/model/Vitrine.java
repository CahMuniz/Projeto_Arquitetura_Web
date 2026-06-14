package com.example.category.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document(collection = "vitrines")
public class Vitrine {

    @Id
    private String id;
    private String titulo;            // "Lançamentos", "Mais Vendidos"
    private String tipo;              // "LANCAMENTO", "DESTAQUE", "PROMOCAO"
    private List<String> produtoIds;  // IDs dos produtos em destaque
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private boolean ativa;

    public Vitrine() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public List<String> getProdutoIds() { return produtoIds; }
    public void setProdutoIds(List<String> produtoIds) { this.produtoIds = produtoIds; }

    public LocalDate getDataInicio() { return dataInicio; }
    public void setDataInicio(LocalDate dataInicio) { this.dataInicio = dataInicio; }

    public LocalDate getDataFim() { return dataFim; }
    public void setDataFim(LocalDate dataFim) { this.dataFim = dataFim; }

    public boolean isAtiva() { return ativa; }
    public void setAtiva(boolean ativa) { this.ativa = ativa; }
}
