package br.com.desafio.senior.services.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.desafio.senior.domain.entities.ProductEntity;
import br.com.desafio.senior.dtos.ProductListRequestDTO;
import br.com.desafio.senior.dtos.ProductRequestDTO;
import br.com.desafio.senior.repositories.ProductRepository;
import br.com.desafio.senior.services.ProductService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService  {
	
	private ProductRepository productRepository;
	
	public ProductListRequestDTO create(ProductRequestDTO productRequestDTO){
		var product = new ProductEntity(productRequestDTO);
		productRepository.save(product);
		return new ProductListRequestDTO(product);
	}
	
	public Page<ProductRequestDTO> listPageable(Pageable pageable){		
		List<ProductRequestDTO> products = productRepository.findAll(pageable).map(ProductRequestDTO::new).toList();		
		return new PageImpl<>(products, pageable, products.size());
	}

}
