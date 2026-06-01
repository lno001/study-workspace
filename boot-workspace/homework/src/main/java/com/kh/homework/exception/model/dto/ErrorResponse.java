package com.kh.homework.exception.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {
	private int code;
	private String message;
	private Object data;
}
