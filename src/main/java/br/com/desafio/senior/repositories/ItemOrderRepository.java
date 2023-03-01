package br.com.desafio.senior.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.desafio.senior.domain.entities.ItemOrderEntity;

public interface ItemOrderRepository extends JpaRepository<ItemOrderEntity, UUID> {

}
