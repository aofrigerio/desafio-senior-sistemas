package br.com.desafio.senior.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.desafio.senior.dtos.ProductListRequestDTO;
import br.com.desafio.senior.dtos.ProductRequestDTO;

public interface ProductService {
	
	Page<ProductRequestDTO> listPageable(Pageable pageable);
	ProductListRequestDTO create(ProductRequestDTO productRequestDTO);
}
