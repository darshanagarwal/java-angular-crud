package com.springboot2.test.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot2.test.exception.ResourceNotFoundException;
import com.springboot2.test.model.Product;
import com.springboot2.test.service.ProductService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class ProductController {
	
	@Autowired
	ProductService productService;

	@GetMapping("/product")
	public List<Product> getAllProducts() {
		return productService.getAllProduct();
	}

	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable(value = "id") Long productId)
			throws ResourceNotFoundException {
		return ResponseEntity.ok().body(productService.getProductById(productId));
	}

	@PostMapping(value = "/product", produces = "application/json")
	public Product createProduct(@Valid @RequestBody Product product) {
		return productService.saveProduct(product);
	}

	@PutMapping("/product/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") Long productId,
			@Valid @RequestBody Product productDetails) throws ResourceNotFoundException {
		return ResponseEntity.ok(productService.updateProduct(productId, productDetails));
	}

	@DeleteMapping("/product/{id}")
	public Map<String, Boolean> deleteProduct(@PathVariable(value = "id") Long productId)
			throws ResourceNotFoundException {
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", productService.deleteProductById(productId));
		return response;
	}
}
