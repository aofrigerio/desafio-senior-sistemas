package br.com.desafio.senior.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.querydsl.core.types.Predicate;

import br.com.desafio.senior.domain.dtos.ItemOrderListDTO;
import br.com.desafio.senior.domain.dtos.ItemOrderRequestDTO;
import br.com.desafio.senior.domain.entities.ItemOrderEntity;
import br.com.desafio.senior.domain.entities.OrderEntity;
import br.com.desafio.senior.domain.entities.ProductEntity;
import br.com.desafio.senior.domain.repositories.ItemOrderRepository;
import br.com.desafio.senior.resources.exceptions.ResourceNotFoundedException;
import br.com.desafio.senior.services.ItemOrderService;
import br.com.desafio.senior.services.OrderService;
import br.com.desafio.senior.services.ProductService;

@Service
public class ItemOrderServiceImpl implements ItemOrderService {

	private final ItemOrderRepository itemOrderRepository;
	private final OrderService orderService;
	private final ProductService productService;

	public ItemOrderServiceImpl(ItemOrderRepository itemOrderRepository, OrderService orderService,
			ProductService productService) {
		this.itemOrderRepository = itemOrderRepository;
		this.orderService = orderService;
		this.productService = productService;
	}

	public Page<ItemOrderListDTO> listPageable(Predicate predicate, Pageable pageable) {
		List<ItemOrderListDTO> itemOrder = itemOrderRepository.findAll(predicate, pageable).map(ItemOrderListDTO::new).toList();
		return new PageImpl<>(itemOrder, pageable, itemOrder.size());
	}

	@Override
	public ItemOrderListDTO create(ItemOrderRequestDTO orderRequestDTO) {

		OrderEntity order = orderService.getOne(orderRequestDTO.orderId());
		ProductEntity product = productService.getOne(orderRequestDTO.productId());

		var itemOrder = new ItemOrderEntity(order, product, orderRequestDTO.quantity(),
				orderRequestDTO.quantity() * product.getPrice());
		itemOrderRepository.save(itemOrder);

		orderService.update(order);

		return new ItemOrderListDTO(itemOrder);
	}

	public ItemOrderEntity getOne(UUID uuId) {
		return itemOrderRepository.findById(uuId).orElseThrow(ResourceNotFoundedException::new);
	}

	public ItemOrderEntity update(UUID uuId, ItemOrderRequestDTO orderRequestDTO) {
		var itemOrder = itemOrderRepository.findById(uuId).orElseThrow(ResourceNotFoundedException::new);
		itemOrder.setQuantity(orderRequestDTO.quantity());
		itemOrder.setTotal(orderRequestDTO.quantity() * itemOrder.getProduct().getPrice());
		orderService.update(itemOrder.getOrder());
		return itemOrderRepository.save(itemOrder);
	}

	public void delete(UUID uuId) {
		itemOrderRepository.deleteById(uuId);
	}

	public List<ItemOrderEntity> listByOrder(UUID uuIdOrder) {
		return itemOrderRepository.findAllByOrderId(uuIdOrder);
	}

}
