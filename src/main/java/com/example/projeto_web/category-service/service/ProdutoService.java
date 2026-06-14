package com.example.category.service;

import com.example.category.model.Produto;
import com.example.category.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> listarDisponiveis() {
        return produtoRepository.findByDisponivelTrue();
    }

    public List<Produto> listarPorCategoria(String categoriaId) {
        return produtoRepository.findByCategoriaIdAndDisponivelTrue(categoriaId);
    }

    public List<Produto> buscarPorNome(String nome) {
        return produtoRepository.findByNomeContainingIgnoreCase(nome);
    }

    public Produto salvar(Produto produto) {
        if (produto.getNome() == null || produto.getNome().isBlank())
            throw new IllegalArgumentException("Nome do produto é obrigatório");
        if (produto.getPreco() == null || produto.getPreco() <= 0)
            throw new IllegalArgumentException("Preço deve ser maior que zero");
        produto.setDisponivel(produto.getEstoque() != null && produto.getEstoque() > 0);
        return produtoRepository.save(produto);
    }

    public Produto atualizar(String id, Produto produto) {
        if (!produtoRepository.existsById(id))
            throw new RuntimeException("Produto não encontrado: " + id);
        produto.setId(id);
        produto.setDisponivel(produto.getEstoque() != null && produto.getEstoque() > 0);
        return produtoRepository.save(produto);
    }

    public void deletar(String id) {
        if (!produtoRepository.existsById(id))
            throw new RuntimeException("Produto não encontrado: " + id);
        produtoRepository.deleteById(id);
    }

    // Chamado pelo Consumer Kafka quando o estoque muda no serviço principal
    public void atualizarDisponibilidade(String produtoId, int novoEstoque) {
        produtoRepository.findById(produtoId).ifPresent(p -> {
            p.setEstoque(novoEstoque);
            p.setDisponivel(novoEstoque > 0);
            produtoRepository.save(p);
        });
    }
}
