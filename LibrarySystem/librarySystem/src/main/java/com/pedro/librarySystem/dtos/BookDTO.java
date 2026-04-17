package com.pedro.librarySystem.dtos;

import java.time.LocalDate;

import com.pedro.librarySystem.enums.BookGenre;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

public class BookDTO {
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
