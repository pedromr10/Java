package com.pedro.librarySystem.entities;

import java.time.LocalDate;

import com.pedro.librarySystem.enums.BookGenre;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

@Entity
@Table(name = "tb_book")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String author;
	private LocalDate releaseDate;
	@Column(columnDefinition = "TEXT")
	private String synopsis;
	private Integer availableQuantity;
	@Enumerated(EnumType.STRING)
	private BookGenre genre;
	
}
