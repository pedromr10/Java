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
	@NotBlank
	private String title;
	@NotBlank
	private String author;
	private LocalDate releaseDate;
	private String synopsis;
	@NotNull
	private Integer availableQuantity;
	private BookGenre genre;
}
