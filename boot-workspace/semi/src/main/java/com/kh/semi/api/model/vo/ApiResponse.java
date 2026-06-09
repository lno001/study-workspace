package com.kh.semi.api.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiResponse<T> {
	private int code;
	private String message;
	private T data;
	
	// 200 성공 응답
	public static <T> ApiResponse<T> success(T data) {
		return new ApiResponse<T>(200, "요청에 성공했습니다.", data);
	}

	public static <T> ApiResponse<T> success(String message, T data) {
		return new ApiResponse<T>(200, message, data);
	}
	
	// 201 성공 응답
	public static <T> ApiResponse<T> created(T data) {
		return new ApiResponse<T>(201, "요청에 성공했습니다.", data);
	}
	
	public static <T> ApiResponse<T> created(String message, T data) {
		return new ApiResponse<T>(201, message, data);
	}

	// 204 성공 응답
	public static <T> ApiResponse<T> noContent(T data) {
		return new ApiResponse<T>(204, "요청에 성공했습니다.", data);
	}

	
}
