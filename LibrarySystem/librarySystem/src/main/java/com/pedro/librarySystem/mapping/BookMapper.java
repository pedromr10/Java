package com.pedro.librarySystem.mapping;

import org.springframework.stereotype.Component;

import com.pedro.librarySystem.dtos.BookRequestDTO;
import com.pedro.librarySystem.dtos.BookResponseDTO;
import com.pedro.librarySystem.entities.Book;

@Component
public class BookMapper {
	
	public Book toEntity(BookRequestDTO bookDto) {
		Book book = new Book();
		book.setTitle(bookDto.getTitle());
		book.setAuthor(bookDto.getAuthor());
		book.setReleaseDate(bookDto.getReleaseDate());
		book.setSynopsis(bookDto.getSynopsis());
		book.setAvailableQuantity(bookDto.getAvailableQuantity());
		book.setGenre(bookDto.getGenre());
		return book;
	}
	
    public BookResponseDTO toResponseDTO(Book book) {
        BookResponseDTO bookResponse = new BookResponseDTO();
        bookResponse.setId(book.getId());
        bookResponse.setTitle(book.getTitle());
        bookResponse.setAuthor(book.getAuthor());
        bookResponse.setReleaseDate(book.getReleaseDate());
        bookResponse.setSynopsis(book.getSynopsis());
        bookResponse.setAvailableQuantity(book.getAvailableQuantity());
        bookResponse.setGenre(book.getGenre());
        return bookResponse;
    }
}
