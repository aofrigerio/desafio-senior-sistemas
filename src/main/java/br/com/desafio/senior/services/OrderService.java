package br.com.desafio.senior.services;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.querydsl.core.types.Predicate;

import br.com.desafio.senior.domain.dtos.OrderListDTO;
import br.com.desafio.senior.domain.dtos.OrderRequestDTO;
import br.com.desafio.senior.domain.entities.OrderEntity;

public interface OrderService {

	/**
	 * Listar todos registro paginado
	 * 
	 * @param pageable
	 * @return
	 */
	Page<OrderListDTO> listPageable(Predicate predicate, Pageable pageable);

	/**
	 * @param orderRequestDTO
	 * @return
	 */
	OrderEntity create(OrderRequestDTO orderRequestDTO);

	/**
	 * Criar um registro
	 * 
	 * @param uuId
	 * @return
	 */
	OrderEntity getOne(UUID uuId);

	/**
	 * Buscar um unico registro
	 * 
	 * @param uuId
	 * @param orderRequestDTO
	 * @return
	 */
	OrderEntity update(UUID uuId, OrderRequestDTO orderRequestDTO);

	/**
	 * Atualizar um registro
	 * 
	 * @param orderEntity
	 */
	void update(OrderEntity orderEntity);

	/**
	 * Deletar um registro
	 * 
	 * @param uuId
	 */
	void delete(UUID uuId);
}
