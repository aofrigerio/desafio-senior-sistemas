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
	ItemOrderListDTO create(ItemOrderRequestDTO orderRequestDTO);
	ItemOrderListDTO getOne(UUID uuId);
	ItemOrderListDTO update(UUID uuId, ItemOrderRequestDTO orderRequestDTO);
	void delete(UUID uuId);
	
	List<ItemOrderEntity> getItems(List<UUID> uuIds);
}
