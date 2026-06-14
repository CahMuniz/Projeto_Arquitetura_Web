package com.example.notification_service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.notification_service.model.Pedido;

@Repository
public interface PedidoRepository extends MongoRepository<Pedido, Long> { }