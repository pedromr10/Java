package com.pedro.nubankchallenge.exceptions;

import java.time.LocalDateTime;
import java.util.Map;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder

public class ErrorResponse {
	private Integer status;
	private String message;
	private LocalDateTime timestamp;
	private Map<String, String> errors;
}
