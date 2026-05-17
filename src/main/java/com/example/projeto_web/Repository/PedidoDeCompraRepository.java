package com.example.projeto_web.Repository;

import com.example.projeto_web.Model.PedidoDeCompra;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PedidoDeCompraRepository extends MongoRepository<PedidoDeCompra, String> {
}