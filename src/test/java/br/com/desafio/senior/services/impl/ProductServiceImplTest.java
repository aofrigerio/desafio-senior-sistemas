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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import br.com.desafio.senior.domain.entities.ProductEntity;
import br.com.desafio.senior.dtos.ProductRequestDTO;
import br.com.desafio.senior.repositories.ProductRepository;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {

	ProductServiceImpl productServiceImpl;

	@Mock
	ProductRepository productRepository;

	@BeforeEach
	void setUp() {
		this.productServiceImpl = new ProductServiceImpl(productRepository);
	}

	@Test
	void createWithParametersIsNull() {
		assertThrows(NullPointerException.class, () -> productServiceImpl.create(null));
	}

	@Test
	void createHappyEnding() {
		assertDoesNotThrow(() -> productServiceImpl.create(buildProductRequestDTO()));
	}

	@Test
	void listPageable() {
		Pageable pageable = PageRequest.of(0, 8);
		when(productRepository.findAll(pageable)).thenReturn(new PageImpl<>(List.of(buildProductEntity())));
		assertDoesNotThrow(() -> productServiceImpl.listPageable(pageable));
	}

	@Test
	void getOne() {
		when(productRepository.findById(any())).thenReturn(Optional.of(buildProductEntity()));
		assertDoesNotThrow(() -> productServiceImpl.getOne(UUID.fromString("e639dab4-2fa3-43f4-9c69-7444af5130e4")));
	}

	@Test
	void getOneWithoutValue() {
		assertDoesNotThrow(() -> productServiceImpl.getOne(UUID.fromString("e639dab4-2fa3-43f4-9c69-7444af5130e4")));
	}

	@Test
	void updateWithNull() {
		assertThrows(NullPointerException.class, () -> productServiceImpl
				.update(UUID.fromString("e639dab4-2fa3-43f4-9c69-7444af5130e4"), buildProductRequestDTO()));
	}

	@Test
	void update() {		
		when(productRepository.findById(any())).thenReturn(Optional.of(buildProductEntity()));
		assertDoesNotThrow(() -> productServiceImpl.update(UUID.fromString("e639dab4-2fa3-43f4-9c69-7444af5130e4"), buildProductRequestDTO()));
	}

	@Test
	void delete() {
		assertDoesNotThrow(() -> productServiceImpl.delete(UUID.fromString("e639dab4-2fa3-43f4-9c69-7444af5130e4")));
	}

	ProductRequestDTO buildProductRequestDTO() {
		return ProductRequestDTO.builder().name("Alan").price(15D).build();
	}

	ProductEntity buildProductEntity() {
		return ProductEntity.builder().name("Alan").price(16D).build();
	}

}