package com.pedro.nubankchallenge.exceptions;

import java.time.LocalDateTime;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ErrorResponse {
	private Integer status;
	private String message;
	private LocalDateTime timestamp;
	private Map<String, String> errors;
}
