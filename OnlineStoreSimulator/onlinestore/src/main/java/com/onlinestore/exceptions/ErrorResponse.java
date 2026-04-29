package com.onlinestore.exceptions;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ErrorResponse{
	private LocalDateTime timestamp;
	private Integer status;
	private List<String> messages;
	private String path;
}
