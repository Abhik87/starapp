package com.achistar.starapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;

	@RequestMapping("/products")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	@RequestMapping("/product/{id}")
	public Product getProduct(@PathVariable Integer id) {
		return productService.getProduct(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/product")
	public String addProduct(@RequestBody Product Product) {
		Product savedProduct = productService.addProduct(Product);
		return savedProduct.toString();
	}


}
