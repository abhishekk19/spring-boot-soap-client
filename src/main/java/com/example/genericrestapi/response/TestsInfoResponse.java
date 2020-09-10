package com.example.genericrestapi.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TestsInfoResponse {

	@JsonProperty("status")
	private String status;
	
	@JsonProperty("statusCode")
	private int statusCode;
	
	@JsonProperty("dataObject")
	private List<TestInfo> dataObject;
	
	@JsonProperty("results_count")
	private Long resultsCount;
	
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

	public List<TestInfo> getDataObject() {
		return dataObject;
	}

	public void setDataObject(List<TestInfo> dataObject) {
		this.dataObject = dataObject;
	}

	public Long getResultsCount() {
		return resultsCount;
	}

	public void setResultsCount(Long resultsCount) {
		this.resultsCount = resultsCount;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@JsonProperty("reason")
	private String reason;



}
