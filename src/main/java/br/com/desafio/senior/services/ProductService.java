package br.com.desafio.senior.services;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.querydsl.core.types.Predicate;

import br.com.desafio.senior.domain.dtos.ProductListDTO;
import br.com.desafio.senior.domain.dtos.ProductRequestDTO;
import br.com.desafio.senior.domain.entities.ProductEntity;

public interface ProductService {
	
	Page<ProductListDTO> listPageable(Pageable pageable);
	ProductListDTO create(ProductRequestDTO productRequestDTO);
	ProductEntity getOne(UUID uuId);
	ProductListDTO update(UUID uuId, ProductRequestDTO productRequestDTO);
	void delete(UUID uuId);
}
