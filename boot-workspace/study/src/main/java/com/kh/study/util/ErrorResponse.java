package com.kh.study.util;

public class ErrorResponse {
	private int status;
	private String message;
	private Object data;
	public ErrorResponse() {
		super();
	}
	public ErrorResponse(int status, String message, Object data) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
	}
	public int getStatus() {
		return status;
	}
	public String getMessage() {
		return message;
	}
	public Object getData() {
		return data;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setData(Object data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "ErrorResponse [status=" + status + ", message=" + message + ", data=" + data + "]";
	}
	
}
