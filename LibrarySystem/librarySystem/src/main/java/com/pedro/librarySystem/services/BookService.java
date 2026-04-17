package com.pedro.librarySystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedro.librarySystem.entities.Book;
import com.pedro.librarySystem.repositories.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepo;
	
	//add book:
	public Book create(Book book) {
		return bookRepo.save(book);
	}
	
	//find all books:
	public List<Book> findAll(){
		return bookRepo.findAll();
	}
	
	//find book by id:
	public Book findById(Long id){
		Book book = bookRepo.findById(id).orElseThrow(()-> new RuntimeException("Book not found"));
		return book;
	}
	
	//delete book:
	public void delete(Long id){
		Book book = findById(id);
		bookRepo.delete(book);
	}
}
