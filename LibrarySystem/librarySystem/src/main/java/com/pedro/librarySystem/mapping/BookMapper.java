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
        BookResponseDTO bookDto = new BookResponseDTO();
        bookDto.setId(book.getId());
        bookDto.setTitle(book.getTitle());
        bookDto.setAuthor(book.getAuthor());
        bookDto.setReleaseDate(book.getReleaseDate());
        bookDto.setSynopsis(book.getSynopsis());
        bookDto.setAvailableQuantity(book.getAvailableQuantity());
        bookDto.setGenre(book.getGenre());
        return bookDto;
    }
}
