package com.pedro.librarySystem.exceptions;

import java.time.LocalDateTime;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StandardError {
	private LocalDateTime timestamp;
	private Integer status;
	private String message;
	private Map<String, String> errors;
}
