package com.pedro.librarySystem.dtos;

import java.time.LocalDate;

import com.pedro.librarySystem.enums.BookGenre;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class BookRequestDTO {
	@NotBlank(message = "{NotBlank.book.title}")
	private String title;
	@NotBlank(message = "{NotBlank.book.author}")
	private String author;
	private LocalDate releaseDate;
	private String synopsis;
	@NotNull(message = "{NotNull.book.availableQuantity}")
	private Integer availableQuantity;
	private BookGenre genre;
}
