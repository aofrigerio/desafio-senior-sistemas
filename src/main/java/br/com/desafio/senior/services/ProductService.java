package br.com.desafio.senior.services;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.desafio.senior.domain.entities.ProductEntity;
import br.com.desafio.senior.dtos.ProductListDTO;
import br.com.desafio.senior.dtos.ProductRequestDTO;

public interface ProductService {
	
	Page<ProductRequestDTO> listPageable(Pageable pageable);
	ProductListDTO create(ProductRequestDTO productRequestDTO);
	ProductEntity getOne(UUID uuId);
	ProductListDTO update(UUID uuId, ProductRequestDTO productRequestDTO);
	void delete(UUID uuId);
}
