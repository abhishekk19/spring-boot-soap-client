package com.example.genericrestapi.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LabInfo {

	@JsonProperty("name")
	private String name;

	@JsonProperty("code")
	private int code;

	@JsonProperty("branches")
	private List<Branch> dataObject;

	@JsonProperty("distance")
	private Long distance;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public List<Branch> getDataObject() {
		return dataObject;
	}

	public void setDataObject(List<Branch> dataObject) {
		this.dataObject = dataObject;
	}

	public Long getDistance() {
		return distance;
	}

	public void setDistance(Long distance) {
		this.distance = distance;
	}
	
	

}
