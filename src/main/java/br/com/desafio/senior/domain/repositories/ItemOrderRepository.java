package br.com.desafio.senior.domain.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.desafio.senior.domain.entities.ItemOrderEntity;
import br.com.desafio.senior.domain.repositories.custom.CustomItemOrderRepository;

public interface ItemOrderRepository extends JpaRepository<ItemOrderEntity, UUID>, CustomItemOrderRepository {
	
	@Query(" SELECT io from ItemOrderEntity io where io.order.id = :uuId  ")
	List<ItemOrderEntity> findAllItemOrdensByOrderId(UUID uuId);
}
