package com.example.genericrestapi.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class conditions {
	
	@JsonProperty("assured")
	private String assured;
	
	@JsonProperty("radius")
	private String radius;
	
	@JsonProperty("business_code")
	private Long businessCode;
	
	public String getAssured() {
		return assured;
	}

	public void setAssured(String assured) {
		this.assured = assured;
	}

	public String getRadius() {
		return radius;
	}

	public void setRadius(String radius) {
		this.radius = radius;
	}

	public Long getBusinessCode() {
		return businessCode;
	}

	public void setBusinessCode(Long businessCode) {
		this.businessCode = businessCode;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public Float getRating() {
		return rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}

	@JsonProperty("search_text")
	private String searchText;
	
	@JsonProperty("rating")
	private Float rating;
	
}
