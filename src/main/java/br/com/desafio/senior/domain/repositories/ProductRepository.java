package br.com.desafio.senior.domain.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import br.com.desafio.senior.domain.entities.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {

}
