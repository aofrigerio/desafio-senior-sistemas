package br.com.desafio.senior.domain.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.desafio.senior.domain.entities.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, UUID> {

}
