package com.example.genericrestapi.request;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "method", "type", "application", "request" })
public class UserDetailsRequest {

	public String method;
	public String type;
	public String application;
	public Data request;

	public class Data {
		private String mrn;

		public String getMrn() {
			return mrn;
		}

		public void setMrn(String mrn) {
			this.mrn = mrn;
		}
	}

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

	public Data getRequest() {
		return request;
	}

	public void setRequest(Data request) {
		this.request = request;
	}
	
	
	

}
