package com.example.genericrestapi.request;

public class CallHealthTestInfoRequest {
//what are madantory props 	
	private String organization;
	private String tenant;
	private String language;
	private String search_type;
	private String location;
	private String source_type;
	private String customer_ip;
	private conditions condtions;
	private String name;
	private Long offset;
	private Long limit;

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getTenant() {
		return tenant;
	}

	public void setTenant(String tenant) {
		this.tenant = tenant;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getSearch_type() {
		return search_type;
	}

	public void setSearch_type(String search_type) {
		this.search_type = search_type;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSource_type() {
		return source_type;
	}

	public void setSource_type(String source_type) {
		this.source_type = source_type;
	}

	public String getCustomer_ip() {
		return customer_ip;
	}

	public void setCustomer_ip(String customer_ip) {
		this.customer_ip = customer_ip;
	}

	public conditions getCondtions() {
		return condtions;
	}

	public void setCondtions(conditions condtions) {
		this.condtions = condtions;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getOffset() {
		return offset;
	}

	public void setOffset(Long offset) {
		this.offset = offset;
	}

	public Long getLimit() {
		return limit;
	}

	public void setLimit(Long limit) {
		this.limit = limit;
	}

}
