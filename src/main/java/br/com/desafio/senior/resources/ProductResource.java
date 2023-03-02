package br.com.desafio.senior.resources;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.senior.domain.dtos.ProductListDTO;
import br.com.desafio.senior.domain.dtos.ProductRequestDTO;
import br.com.desafio.senior.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Tag(name = "Produtos")
@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductResource {

	private ProductService productService;

	@GetMapping
	@Operation(summary = "Listar todos paginado")
	private ResponseEntity<Page<ProductListDTO>> pageable(Pageable pageable) {
		return ResponseEntity.ok(productService.listPageable(pageable));
	}

	@GetMapping("/{uuId}")
	@Operation(summary = "Buscar um recurso por UUID")
	private ResponseEntity<?> read(@PathVariable UUID uuId) {
		return ResponseEntity.ok(new ProductListDTO(productService.getOne(uuId)));
	}

	@PostMapping
	@Operation(summary = "Criar um recurso")
	private ResponseEntity<Void> create(@Valid @RequestBody ProductRequestDTO productDTO) {
		productService.create(productDTO);
		return ResponseEntity.noContent().build();
	}

	@PutMapping
	@Operation(summary = "Editar um recurso")
	private ResponseEntity<ProductListDTO> update(@Valid @RequestBody ProductRequestDTO productDTO) {
		return ResponseEntity.ok(productService.update(null, productDTO));
	}

	@DeleteMapping("/{uuId}")
	@Operation(summary = "Deletar um recurso")
	private ResponseEntity<Void> delete(@PathVariable UUID uuId) {
		productService.delete(uuId);
		return ResponseEntity.noContent().build();
	}

}
