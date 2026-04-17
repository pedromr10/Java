package com.pedro.librarySystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedro.librarySystem.dtos.BookDTO;
import com.pedro.librarySystem.entities.Book;
import com.pedro.librarySystem.repositories.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepo;
	
	//add book:
	public Book create(BookDTO bookDto) {
		Book book = new Book();
		book.setTitle(bookDto.getTitle());
		book.setAuthor(bookDto.getAuthor());
		book.setReleaseDate(bookDto.getReleaseDate());
		book.setSynopsis(bookDto.getSynopsis());
		book.setAvailableQuantity(bookDto.getAvailableQuantity());
		book.setGenre(bookDto.getGenre());
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
