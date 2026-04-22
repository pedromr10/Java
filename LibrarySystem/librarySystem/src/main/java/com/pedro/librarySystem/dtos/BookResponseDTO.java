package com.pedro.librarySystem.dtos;

import java.time.LocalDate;

import com.pedro.librarySystem.enums.BookGenre;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class BookResponseDTO {
	private Long id;
	private String title;
	private String author;
	private LocalDate releaseDate;
	private String synopsis;
	private Integer availableQuantity;
	private BookGenre genre;
}
