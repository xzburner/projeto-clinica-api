package com.clinica.projetoclinicaapi.controller.exceptions;

public class StandardError {

	private Integer status;
	private Long timestamp;
	private String message;
	public StandardError() {
		super();
		
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Long timestamp) {
		timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
