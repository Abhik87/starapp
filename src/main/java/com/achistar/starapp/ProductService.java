package com.achistar.starapp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public Product getProduct(Integer id) {
		Optional<Product> productOptional = productRepository.findById(id);
		Product product = null;
		if (productOptional.isPresent()) {
			product = productOptional.get();
		}
		return product;
	}

	public Product addProduct(Product product) {
		return productRepository.save(product);
	}
}
