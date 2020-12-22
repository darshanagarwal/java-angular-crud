package com.springboot2.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot2.test.exception.ResourceNotFoundException;
import com.springboot2.test.model.Product;

import com.springboot2.test.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}
	
	public Product getProductById( Long productId) throws ResourceNotFoundException {
		return productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));
	}
	
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	
	public Product updateProduct(Long productId, Product productDetails) throws ResourceNotFoundException {
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));
		product.setDescription(productDetails.getDescription());
		product.setPrice(productDetails.getPrice());
		product.setProductName(productDetails.getProductName());
		
		final Product updatedProduct = productRepository.save(product);
		return updatedProduct;
	}
	
	public boolean deleteProductById( Long productId) throws ResourceNotFoundException {
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));

		productRepository.delete(product);
		return true;
	}
	
	
}
