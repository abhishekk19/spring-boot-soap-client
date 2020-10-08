package com.example.genericrestapi.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PhleboSlotsRequest {

	@JsonProperty("method")
	private String method;

	@JsonProperty("type")
	private String type;

	@JsonProperty("application")
	private String application;

	@JsonProperty("request")
	private SlotRequest request;

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
	}

	public SlotRequest getRequest() {
		return request;
	}

	public void setRequest(SlotRequest request) {
		this.request = request;
	}

}
