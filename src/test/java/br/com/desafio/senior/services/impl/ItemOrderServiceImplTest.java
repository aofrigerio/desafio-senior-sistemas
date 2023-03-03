package br.com.desafio.senior.services.impl;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.querydsl.core.types.Predicate;

import br.com.desafio.senior.domain.dtos.ItemOrderRequestDTO;
import br.com.desafio.senior.domain.entities.ItemOrderEntity;
import br.com.desafio.senior.domain.entities.ProductEntity;
import br.com.desafio.senior.domain.enuns.ProductTypeEnum;
import br.com.desafio.senior.domain.repositories.ItemOrderRepository;
import br.com.desafio.senior.domain.repositories.OrderRepository;
import br.com.desafio.senior.resources.exceptions.ResourceNotFoundedException;
import br.com.desafio.senior.services.OrderService;
import br.com.desafio.senior.services.ProductService;

@ExtendWith(MockitoExtension.class)
public class ItemOrderServiceImplTest {

	@Mock
	ItemOrderRepository itemOrderRepository;
	@Mock
	OrderService orderService;
	@Mock
	ProductService productService;
	@Mock
	OrderRepository orderRepository;
	@Mock
	Predicate predicate;

	ItemOrderServiceImpl itemOrderServiceImpl;

	@BeforeEach
	void setUp() {
		itemOrderServiceImpl = new ItemOrderServiceImpl(itemOrderRepository, orderService, productService);
	}

	@Test
	void listPageable() {
		Pageable pageable = PageRequest.of(0, 8);
		when(itemOrderRepository.findAll(predicate, pageable))
				.thenReturn(new PageImpl<>(List.of(buildItemOrderEntity())));
		assertDoesNotThrow(() -> itemOrderServiceImpl.listPageable(predicate, pageable));
	}

	@Test
	void create() {
		when(productService.getOne(UUID.fromString("e639dab4-2fa3-43f4-9c69-7444af5130e4"))).thenReturn(buildProductEntity());
		assertDoesNotThrow(() -> itemOrderServiceImpl.create(buildItemOrderRequestDTO()));
	}

	@Test
	void getOne() {
		when(itemOrderRepository.findById(UUID.fromString("e639dab4-2fa3-43f4-9c69-7444af5130e4"))).thenReturn(Optional.of(buildItemOrderEntity()));
		assertDoesNotThrow(() -> itemOrderServiceImpl.getOne(UUID.fromString("e639dab4-2fa3-43f4-9c69-7444af5130e4")) );
	}

	@Test
	void getOneWithThrows() {
		assertThrows(ResourceNotFoundedException.class,
				() -> itemOrderServiceImpl.getOne(UUID.fromString("e639dab4-2fa3-43f4-9c69-7444af5130e4")));
	}

	@Test
	void update() {
		when(itemOrderRepository.findById(UUID.fromString("e639dab4-2fa3-43f4-9c69-7444af5130e4")))
		.thenReturn(Optional.of(buildItemOrderEntity()));
		assertDoesNotThrow(() -> itemOrderServiceImpl
				.update(UUID.fromString("e639dab4-2fa3-43f4-9c69-7444af5130e4"), buildItemOrderRequestDTO()));
	}
	
	@Test
	void delete() {
		assertDoesNotThrow(() -> itemOrderServiceImpl.delete(UUID.fromString("e639dab4-2fa3-43f4-9c69-7444af5130e4")) );
	}
	
	@Test
	void listByOrder() {
		assertDoesNotThrow(() -> itemOrderServiceImpl.listByOrder(UUID.fromString("e639dab4-2fa3-43f4-9c69-7444af5130e4")) );
	}

	ItemOrderEntity buildItemOrderEntity() {
		return ItemOrderEntity.builder().product(buildProductEntity()).quantity(5).build();
	}

	ProductEntity buildProductEntity() {
		return ProductEntity.builder().name("Teste").type(ProductTypeEnum.PRODUCT).price(15D).build();
	}

	ItemOrderRequestDTO buildItemOrderRequestDTO() {
		return ItemOrderRequestDTO.builder().quantity(3).productId(UUID.fromString("e639dab4-2fa3-43f4-9c69-7444af5130e4")).build();
	}
}
