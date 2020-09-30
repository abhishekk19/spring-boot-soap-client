package com.example.genericrestapi.response;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LabsInfoResponse {

	private ApiStatus Status;
	private int statusCode;

	@JsonProperty("lab")
	private Map<String, List<LabInfo>> lab;

	private String reason;

	public ApiStatus getStatus() {
		return Status;
	}

	public void setStatus(ApiStatus status) {
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

	public Map<String, List<LabInfo>> getLab() {
		return lab;
	}

	public void setLab(Map<String, List<LabInfo>> lab) {
		this.lab = lab;
	}

}
