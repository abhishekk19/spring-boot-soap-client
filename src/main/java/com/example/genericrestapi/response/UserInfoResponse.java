package com.example.genericrestapi.response;

import java.util.List;

import com.example.genericrestapi.request.UserDetails;

public class UserInfoResponse {

	private String status;
	private int statusCode;
	private List<UserDetails> dataObject;
	private String reason;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public List<UserDetails> getDataObject() {
		return dataObject;
	}

	public void setDataObject(List<UserDetails> dataObject) {
		this.dataObject = dataObject;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

}
