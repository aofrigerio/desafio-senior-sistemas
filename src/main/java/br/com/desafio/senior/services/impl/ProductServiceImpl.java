package br.com.desafio.senior.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.desafio.senior.domain.entities.ProductEntity;
import br.com.desafio.senior.dtos.ProductListDTO;
import br.com.desafio.senior.dtos.ProductRequestDTO;
import br.com.desafio.senior.repositories.ProductRepository;
import br.com.desafio.senior.services.ProductService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;

	public ProductListDTO create(ProductRequestDTO productRequestDTO) {
		var product = new ProductEntity(productRequestDTO);
		productRepository.save(product);
		return new ProductListDTO(product);
	}

	public Page<ProductListDTO> listPageable(Pageable pageable) {
		List<ProductListDTO> products = productRepository.findAll(pageable).map(ProductListDTO::new).toList();
		return new PageImpl<>(products, pageable, products.size());
	}

	public ProductEntity getOne(UUID uuId) {
		var product = productRepository.findById(uuId).orElse(null); //TODO -- ajustar os optionals
		return product;
	}

	public ProductListDTO update(UUID uuId, ProductRequestDTO productRequestDTO) {
		var product = productRepository.findById(uuId).orElse(null);
		product.setName(productRequestDTO.name());
		product.setPrice(productRequestDTO.price());
		return new ProductListDTO(product);
	}

	public void delete(UUID uuId) {
		productRepository.deleteById(uuId);
	}

}
