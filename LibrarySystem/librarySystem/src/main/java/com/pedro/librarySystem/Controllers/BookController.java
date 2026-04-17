package com.pedro.librarySystem.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedro.librarySystem.entities.Book;
import com.pedro.librarySystem.services.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;
	
	//add book:
	@PostMapping
	public ResponseEntity<Book> create(@RequestBody Book book){
		Book newBook = bookService.create(book);
		return ResponseEntity.status(201).body(newBook);
	}
	
	//find all books:
	@GetMapping
	public ResponseEntity<List<Book>> findAll(){
		List<Book> allBooksList = bookService.findAll();
		return ResponseEntity.status(200).body(allBooksList);
	}
}
