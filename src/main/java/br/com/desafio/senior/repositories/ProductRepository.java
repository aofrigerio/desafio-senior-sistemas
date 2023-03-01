package br.com.desafio.senior.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.desafio.senior.domain.entities.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {

}
