package br.com.desafio.senior.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.desafio.senior.domain.entities.ItemOrderEntity;
import br.com.desafio.senior.dtos.ItemOrderListDTO;
import br.com.desafio.senior.dtos.ItemOrderRequestDTO;
import br.com.desafio.senior.repositories.ItemOrderRepository;
import br.com.desafio.senior.services.ItemOrderService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ItemOrderServiceImpl implements ItemOrderService {

	private ItemOrderRepository itemOrderRepository;

	public List<ItemOrderEntity> getItems(List<UUID> uuIds) {		
		//TODO -- Implementar QueryDsl
		return null;
	}

	public Page<ItemOrderListDTO> listPageable(Pageable pageable) {
		List<ItemOrderListDTO> products = itemOrderRepository.findAll(pageable).map(ItemOrderListDTO::new).toList();		
		return new PageImpl<>(products, pageable, products.size());
	}

	@Override
	public ItemOrderListDTO create(ItemOrderRequestDTO orderRequestDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemOrderListDTO getOne(UUID uuId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemOrderListDTO update(UUID uuId, ItemOrderRequestDTO orderRequestDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(UUID uuId) {
		// TODO Auto-generated method stub
		
	}

}
