package com.example.genericrestapi.response;

import java.util.LinkedHashMap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LabsInfoResponse {

	@JsonProperty("Status")
	private ApiStatus status;

	@JsonProperty("statusCode")
	private int statusCode;

	@JsonProperty("lab")
	private LinkedHashMap<String, LabInfo> lab;

	@JsonProperty("reason")
	private String reason;

	public ApiStatus getStatus() {
		return status;
	}

	public void setStatus(ApiStatus status) {
		this.status = status;
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

	public LinkedHashMap<String, LabInfo> getLab() {
		return lab;
	}

	public void setLab(LinkedHashMap<String, LabInfo> lab) {
		this.lab = lab;
	}

}
