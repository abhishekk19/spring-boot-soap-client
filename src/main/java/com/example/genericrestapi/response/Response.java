package com.example.genericrestapi.response;

import org.springframework.http.HttpStatus;

public class Response {

	private HttpStatus Status;
	private int statusCode;
	private String reason;
	private Object data;

	public HttpStatus getStatus() {
		return Status;
	}

	public void setStatus(HttpStatus status) {
		Status = status;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
