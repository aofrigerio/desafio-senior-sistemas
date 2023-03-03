package br.com.desafio.senior.services;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.querydsl.core.types.Predicate;

import br.com.desafio.senior.domain.dtos.ProductListDTO;
import br.com.desafio.senior.domain.dtos.ProductRequestDTO;
import br.com.desafio.senior.domain.entities.ProductEntity;

public interface ProductService {

	/**
	 * Listar registro paginado
	 * 
	 * @param pageable
	 * @return
	 */
	Page<ProductListDTO> listPageable(Predicate predicate, Pageable pageable);

	/**
	 * Criar um registro
	 * 
	 * @param productRequestDTO
	 * @return
	 */
	ProductListDTO create(ProductRequestDTO productRequestDTO);

	/**
	 * Buscar um unico registro
	 * 
	 * @param uuId
	 * @return
	 */
	ProductEntity getOne(UUID uuId);

	/**
	 * Atualizar um registro
	 * 
	 * @param uuId
	 * @param productRequestDTO
	 * @return
	 */
	ProductListDTO update(UUID uuId, ProductRequestDTO productRequestDTO);

	/**
	 * Deletar um registro
	 * 
	 * @param uuId
	 */
	void delete(UUID uuId);
}
