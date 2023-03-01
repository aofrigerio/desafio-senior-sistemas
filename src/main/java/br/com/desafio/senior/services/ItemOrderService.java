package br.com.desafio.senior.services;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.desafio.senior.domain.entities.ItemOrderEntity;
import br.com.desafio.senior.dtos.ItemOrderListDTO;
import br.com.desafio.senior.dtos.ItemOrderRequestDTO;

public interface ItemOrderService {	
	
	Page<ItemOrderListDTO> listPageable(Pageable pageable);
	List<ItemOrderEntity> listByOrder(UUID uuIdOrder);
	ItemOrderListDTO create(ItemOrderRequestDTO orderRequestDTO);
	ItemOrderEntity getOne(UUID uuId);
	ItemOrderEntity update(UUID uuId, ItemOrderRequestDTO orderRequestDTO);
	void delete(UUID uuId);
}
