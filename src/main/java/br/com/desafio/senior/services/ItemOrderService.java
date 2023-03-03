package br.com.desafio.senior.services;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.querydsl.core.types.Predicate;

import br.com.desafio.senior.domain.dtos.ItemOrderListDTO;
import br.com.desafio.senior.domain.dtos.ItemOrderRequestDTO;
import br.com.desafio.senior.domain.entities.ItemOrderEntity;

public interface ItemOrderService {

	/**
	 * 
	 * @param pageable
	 * @return
	 */
	Page<ItemOrderListDTO> listPageable(Predicate predicate, Pageable pageable);

	/**
	 * Listar item do pedido por UUID de pedido
	 * 
	 * @param uuIdOrder
	 * @return
	 */
	List<ItemOrderEntity> listByOrder(UUID uuIdOrder);

	/**
	 * Criar um item de pedido
	 * 
	 * @param orderRequestDTO
	 * @return
	 */
	ItemOrderListDTO create(ItemOrderRequestDTO orderRequestDTO);

	/**
	 * Buscar um item do pedido por UUID
	 * 
	 * @param uuId
	 * @return
	 */
	ItemOrderEntity getOne(UUID uuId);

	/**
	 * Atualizar um item de pedido
	 * 
	 * @param uuId
	 * @param orderRequestDTO
	 * @return
	 */
	ItemOrderEntity update(UUID uuId, ItemOrderRequestDTO orderRequestDTO);

	/**
	 * Deletar um Item do Pedido por UUID
	 * 
	 * @param uuId
	 */
	void delete(UUID uuId);
}
