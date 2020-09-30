package com.example.genericrestapi.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Branch {

	@JsonProperty("id")
	private String id;

	@JsonProperty("branchId")
	private Long branchId;

	@JsonProperty("address")
	private String address;

	@JsonProperty("area")
	private Float area;

	@JsonProperty("city")
	private String city;

	@JsonProperty("district")
	private String district;

	public String getCode() {
		return id;
	}

	public void setCode(String code) {
		this.id = code;
	}

	public Long getBranchId() {
		return branchId;
	}

	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}

	public String getName() {
		return address;
	}

	public void setName(String name) {
		this.address = name;
	}

	public Float getAvgRating() {
		return area;
	}

	public void setAvgRating(Float avgRating) {
		this.area = avgRating;
	}

	public String getProfilePic() {
		return city;
	}

	public void setProfilePic(String profilePic) {
		this.city = profilePic;
	}
	
	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

}
