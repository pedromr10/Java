package com.pedro.librarySystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedro.librarySystem.dtos.BookRequestDTO;
import com.pedro.librarySystem.dtos.BookResponseDTO;
import com.pedro.librarySystem.services.BookService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;

	//add book:
	@PostMapping
	public ResponseEntity<BookResponseDTO> create(@RequestBody @Valid BookRequestDTO bookDto){
		
		BookResponseDTO savedDto = bookService.create(bookDto);
		return ResponseEntity.status(201).body(savedDto);
	}
	
	//find all books:
	@GetMapping
	public ResponseEntity<List<BookResponseDTO>> findAll(){
		List<BookResponseDTO> allBooksList = bookService.findAll();
		return ResponseEntity.status(200).body(allBooksList);
	}
	
	//find book by id
	@GetMapping("/{id}")
	public ResponseEntity<BookResponseDTO> findById(@PathVariable Long id){
		BookResponseDTO bookDto = bookService.findById(id);
		return ResponseEntity.status(200).body(bookDto);
	} 
	
	//delete book:
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		bookService.delete(id);
		return ResponseEntity.status(204).build();
	} 
}
