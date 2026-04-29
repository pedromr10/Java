package com.onlinestore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinestore.dtos.ProductRequestDto;
import com.onlinestore.dtos.ProductResponseDto;
import com.onlinestore.entities.Product;
import com.onlinestore.mappers.ProductMapper;
import com.onlinestore.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private ProductMapper mapper;
	
	//insert product:
	public ProductResponseDto createProduct(ProductRequestDto request) {
		Product newProduct = productRepo.save(mapper.toEntity(request));
		return mapper.toResponse(newProduct);
	}
	
	//insert list of products:
	public List<ProductResponseDto> createProductBatch(List<ProductRequestDto > requestList){
		List<Product> productList = requestList.stream().map(mapper::toEntity).toList();
		List<Product> savedProducts = productRepo.saveAll(productList);
		return savedProducts.stream().map(mapper::toResponse).toList();
	}
	
	//list all products:
	public List<ProductResponseDto> listAllProducts(){
		return productRepo.findAll().stream().map(mapper::toResponse).toList();
	}
	
	//search product by id:
	public ProductResponseDto findById(Long id) {
		Product product = productRepo.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
		return mapper.toResponse(product);
	}
	
	
	
	
	
}











