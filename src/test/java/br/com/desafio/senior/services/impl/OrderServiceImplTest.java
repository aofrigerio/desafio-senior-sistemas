package br.com.desafio.senior.services.impl;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
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

import br.com.desafio.senior.domain.dtos.OrderRequestDTO;
import br.com.desafio.senior.domain.entities.ItemOrderEntity;
import br.com.desafio.senior.domain.entities.OrderEntity;
import br.com.desafio.senior.domain.entities.ProductEntity;
import br.com.desafio.senior.domain.enuns.ProductTypeEnum;
import br.com.desafio.senior.domain.repositories.OrderRepository;
import br.com.desafio.senior.resources.exceptions.ResourceNotFoundedException;

@ExtendWith(MockitoExtension.class)
public class OrderServiceImplTest {

	@Mock
	OrderRepository repository;

	@Mock
	Predicate predicate;

	OrderServiceImpl orderServiceImpl;

	@BeforeEach
	void setUp() {
		orderServiceImpl = new OrderServiceImpl(repository);
	}

	@Test
	void listPageable() {
		Pageable pageable = PageRequest.of(0, 8);
		when(repository.findAll(predicate, pageable)).thenReturn(new PageImpl<>(List.of(buildOrderEntity())));
		assertDoesNotThrow(() -> orderServiceImpl.listPageable(predicate, pageable));
	}

	@Test
	void getOneWithThrows() {
		assertThrows(ResourceNotFoundedException.class,
				() -> orderServiceImpl.getOne(UUID.fromString("e639dab4-2fa3-43f4-9c69-7444af5130e4")));
	}

	@Test
	void getOne() {
		when(repository.findById(any())).thenReturn(Optional.of(buildOrderEntity()));
		assertDoesNotThrow(() -> orderServiceImpl.getOne(UUID.fromString("e639dab4-2fa3-43f4-9c69-7444af5130e4")));
	}

	@Test
	void create() {
		assertDoesNotThrow(() -> orderServiceImpl.create(buildOrderRequestDTO()));
	}

	@Test
	void update() {
		assertDoesNotThrow(() -> orderServiceImpl.update(UUID.fromString("e639dab4-2fa3-43f4-9c69-7444af5130e4"),
				buildOrderRequestDTO()));
	}

	@Test
	void delete() {
		assertDoesNotThrow(() -> orderServiceImpl.delete(UUID.fromString("e639dab4-2fa3-43f4-9c69-7444af5130e4")));
	}

	@Test
	void updateEntityWhenItemIsNull() {
		assertThrows(NullPointerException.class, () -> orderServiceImpl.update(buildOrderEntity()));
	}

	@Test
	void updateEntity() {
		assertDoesNotThrow(() -> orderServiceImpl.update(buildOrderEntityWithItens()));
	}

	OrderEntity buildOrderEntity() {
		return OrderEntity.builder().customer("ok").off(3D).build();
	}

	OrderEntity buildOrderEntityWithItens() {
		return OrderEntity.builder().customer("ok").off(3D).items(List.of(buildItemOrderEntity())).build();
	}

	ItemOrderEntity buildItemOrderEntity() {
		return ItemOrderEntity.builder().product(buildProductEntity()).quantity(5).build();
	}

	ProductEntity buildProductEntity() {
		return ProductEntity.builder().name("Teste").type(ProductTypeEnum.PRODUCT).price(15D).build();
	}

	OrderRequestDTO buildOrderRequestDTO() {
		return OrderRequestDTO.builder().build();
	}

}
