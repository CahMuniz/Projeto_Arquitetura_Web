package com.example.projeto_web.Service;

import com.example.projeto_web.Model.ProdutoEntity;
import com.example.projeto_web.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoEntity> listarTodos() {
        return produtoRepository.findAll();
    }

    public ProdutoEntity salvar(ProdutoEntity produto) {
        if (produto.getPreco() == null || produto.getPreco() <= 0)
            throw new IllegalArgumentException("Preço deve ser maior que zero");
        if (produto.getNome() == null || produto.getCategoria() == null)
            throw new IllegalArgumentException("Nome e categoria são obrigatórios");
        return produtoRepository.save(produto);
    }

    public void decrementarEstoque(String produtoId, int quantidade) {
        ProdutoEntity p = produtoRepository.findById(produtoId)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        if (p.getEstoque() < quantidade)
            throw new RuntimeException("Estoque insuficiente");

        p.setEstoque(p.getEstoque() - quantidade);

        // Regra de Grade Órfã
        if ("conjunto".equals(p.getTipo()) && p.getParId() != null) {
            produtoRepository.findById(p.getParId()).ifPresent(par -> {
                par.setPreco(par.getPreco() * 0.85); // desconto de 15%
                par.setTipo("avulso");
                produtoRepository.save(par);
            });
        }

        produtoRepository.save(p);
    }

    public ProdutoEntity atualizar(String id, ProdutoEntity produto) {
        if (!produtoRepository.existsById(id))
            throw new RuntimeException("Produto não encontrado: " + id);
        return produtoRepository.save(produto);
    }

    public void deletar(String id) {
        if (!produtoRepository.existsById(id))
            throw new RuntimeException("Produto não encontrado: " + id);
        produtoRepository.deleteById(id);
    }
}
