package com.pedro.librarySystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedro.librarySystem.dtos.BookRequestDTO;
import com.pedro.librarySystem.dtos.BookResponseDTO;
import com.pedro.librarySystem.entities.Book;
import com.pedro.librarySystem.mapping.BookMapper;
import com.pedro.librarySystem.repositories.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepo;
	
	@Autowired
	private BookMapper bookMapper;

	
	//add book:
	public BookResponseDTO create(BookRequestDTO bookDto) {
		Book book = bookMapper.toEntity(bookDto);
		Book savedBook = bookRepo.save(book);
		return bookMapper.toResponseDTO(savedBook);
	}
	
	//find all books:
	public List<BookResponseDTO> findAll(){
		return bookRepo.findAll().stream().map(bookMapper::toResponseDTO).toList();
	}
	
	//find book by id:
	public BookResponseDTO findById(Long id){
		Book book = bookRepo.findById(id).orElseThrow(()-> new RuntimeException("Book not found"));
		BookResponseDTO bookDto = bookMapper.toResponseDTO(book);
		return bookDto;
	}
	
	//delete book:
	public void delete(Long id){
		Book book = bookRepo.findById(id).orElseThrow(()-> new RuntimeException("Book not found"));
		bookRepo.delete(book);
	}
}
