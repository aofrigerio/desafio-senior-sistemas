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

import br.com.desafio.senior.dtos.ProductListDTO;
import br.com.desafio.senior.dtos.ProductRequestDTO;
import br.com.desafio.senior.services.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductResource {
	
	private ProductService productService;	
	
	@GetMapping
	private ResponseEntity<Page<ProductRequestDTO>> pageable(Pageable pageable){
		return ResponseEntity.ok(productService.listPageable(pageable));
	}

	
	@GetMapping("/{uuId}")
	private ResponseEntity<?> read(){
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping
	private ResponseEntity<Void> create(@Valid @RequestBody ProductRequestDTO productDTO){
		productService.create(productDTO);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping
	private ResponseEntity<ProductListDTO> update(@Valid @RequestBody ProductRequestDTO productDTO){
		return ResponseEntity.ok(productService.update(null, productDTO));
	} 
	
	@DeleteMapping("/{uuId}")
	private ResponseEntity<Void> delete(@PathVariable UUID uuId){
		productService.delete(uuId);
		return ResponseEntity.noContent().build();
	} 

}
