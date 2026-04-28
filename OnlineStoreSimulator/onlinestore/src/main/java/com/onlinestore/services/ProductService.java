package com.onlinestore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinestore.entities.Product;
import com.onlinestore.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepo;
	
	//insert product:
	public Product createProduct(Product product) {
		return productRepo.save(product);
	}
	
	//list all products:
	public List<Product> listAllProducts(){
		return productRepo.findAll();
	}
	
	
	
	
	
}











