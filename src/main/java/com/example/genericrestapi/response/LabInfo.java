package com.example.genericrestapi.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LabInfo {

	@JsonProperty("code")
	private String code;
	
	@JsonProperty("branch_id")
	private Long branchId;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("avg_rating")
	private Float avgRating;
	
	@JsonProperty("profile_pic")
	private String profilePic;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getBranchId() {
		return branchId;
	}

	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(Float avgRating) {
		this.avgRating = avgRating;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}
	
}
