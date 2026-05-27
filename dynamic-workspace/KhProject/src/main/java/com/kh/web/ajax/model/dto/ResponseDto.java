package com.kh.web.ajax.model.dto;

public class ResponseDto {
	private String code;
	private String message;
	private Object data;
	
	public String getCode() {
		return code;
	}
	public String getMessage() {
		return message;
	}
	public Object getData() {
		return data;
	}

	public ResponseDto(String code, String message, Object data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}
}
