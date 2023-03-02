package br.com.desafio.senior.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.desafio.senior.DiscountUtil;
import br.com.desafio.senior.domain.dtos.OrderListDTO;
import br.com.desafio.senior.domain.dtos.OrderRequestDTO;
import br.com.desafio.senior.domain.entities.OrderEntity;
import br.com.desafio.senior.domain.repositories.OrderRepository;
import br.com.desafio.senior.services.OrderService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

	private final OrderRepository repository;

	public Page<OrderListDTO> listPageable(Pageable pageable) {
		List<OrderListDTO> products = repository.findAll(pageable).map(OrderListDTO::new).toList();
		return new PageImpl<>(products, pageable, products.size());
	}

	@Transactional
	public OrderEntity create(OrderRequestDTO orderRequestDTO) {
		var order = new OrderEntity(orderRequestDTO);
		repository.save(order);
		return order;
	}

	public OrderEntity getOne(UUID uuId) {
		return repository.findById(uuId).orElse(null);
	}

	public OrderEntity update(UUID uuId, OrderRequestDTO orderRequestDTO) {
		var order = new OrderEntity(orderRequestDTO);
		return repository.save(order);
	}

	public void delete(UUID uuId) {
		repository.deleteById(uuId);
	}

	public void update(OrderEntity orderEntity) {
		Double total = DiscountUtil.simpleDiscount(orderEntity.getOff(), orderEntity.getItems());
		orderEntity.setTotal(total);
		repository.save(orderEntity);
	}
}
