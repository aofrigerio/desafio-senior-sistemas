package br.com.desafio.senior.domain.repositories.custom;

import java.util.List;
import java.util.UUID;

import br.com.desafio.senior.domain.entities.ItemOrderEntity;

public interface CustomItemOrderRepository {
	
	List<ItemOrderEntity> findAllByOrderId(UUID uuId);
}
