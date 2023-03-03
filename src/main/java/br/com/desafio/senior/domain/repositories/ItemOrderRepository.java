package br.com.desafio.senior.domain.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import br.com.desafio.senior.domain.entities.ItemOrderEntity;
import br.com.desafio.senior.domain.repositories.custom.CustomItemOrderRepository;

public interface ItemOrderRepository extends JpaRepository<ItemOrderEntity, UUID>,
															CustomItemOrderRepository,
															QuerydslPredicateExecutor<ItemOrderEntity> {
}
