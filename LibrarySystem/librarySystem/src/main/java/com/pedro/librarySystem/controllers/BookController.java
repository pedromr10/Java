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

import com.pedro.librarySystem.entities.Book;
import com.pedro.librarySystem.services.BookService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;
	
	//add book:
	@PostMapping
	public ResponseEntity<Book> create(@RequestBody @Valid Book book){
		Book newBook = bookService.create(book);
		return ResponseEntity.status(201).body(newBook);
	}
	
	//find all books:
	@GetMapping
	public ResponseEntity<List<Book>> findAll(){
		List<Book> allBooksList = bookService.findAll();
		return ResponseEntity.status(200).body(allBooksList);
	}
	
	//find book by id
	@GetMapping("/{id}")
	public ResponseEntity<Book> findById(@PathVariable Long id){
		Book book = bookService.findById(id);
		return ResponseEntity.status(200).body(book);
	} 
	
	//delete book:
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		bookService.delete(id);
		return ResponseEntity.status(204).build();
	} 
}
