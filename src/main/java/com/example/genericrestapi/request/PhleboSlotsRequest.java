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
	private Request request;

	public class Request {

		@JsonProperty("tenantCode")
		private String tenantCode;

		@JsonProperty("organizationCode")
		private String organizationCode;

		@JsonProperty("from_date")
		private String fromDate;

		@JsonProperty("to_date")
		private String toDate;

		@JsonProperty("business_id")
		private int businessId;

		@JsonProperty("engagement_level")
		private int engagementLevel;

		@JsonProperty("patient_gender")
		private String patientGender;

		@JsonProperty("service_did")
		private String serviceDid;

		@JsonProperty("pin_code")
		private String pincode;

		@JsonProperty("patient_age")
		private int patientAge;

		@JsonProperty("order_latitude")
		private String orderLatitude;

		@JsonProperty("order_longitude")
		private String orderLongitude;

		public String getTenantCode() {
			return tenantCode;
		}

		public void setTenantCode(String tenantCode) {
			this.tenantCode = tenantCode;
		}

		public String getOrganizationCode() {
			return organizationCode;
		}

		public void setOrganizationCode(String organizationCode) {
			this.organizationCode = organizationCode;
		}

		public String getFromDate() {
			return fromDate;
		}

		public void setFromDate(String fromDate) {
			this.fromDate = fromDate;
		}

		public String getToDate() {
			return toDate;
		}

		public void setToDate(String toDate) {
			this.toDate = toDate;
		}

		public int getBusinessId() {
			return businessId;
		}

		public void setBusinessId(int businessId) {
			this.businessId = businessId;
		}

		public int getEngagementLevel() {
			return engagementLevel;
		}

		public void setEngagementLevel(int engagementLevel) {
			this.engagementLevel = engagementLevel;
		}

		public String getPatientGender() {
			return patientGender;
		}

		public void setPatientGender(String patientGender) {
			this.patientGender = patientGender;
		}

		public String getServiceDid() {
			return serviceDid;
		}

		public void setServiceDid(String serviceDid) {
			this.serviceDid = serviceDid;
		}

		public String getPincode() {
			return pincode;
		}

		public void setPincode(String pincode) {
			this.pincode = pincode;
		}

		public int getPatientAge() {
			return patientAge;
		}

		public void setPatientAge(int patientAge) {
			this.patientAge = patientAge;
		}

		public String getOrderLatitude() {
			return orderLatitude;
		}

		public void setOrderLatitude(String orderLatitude) {
			this.orderLatitude = orderLatitude;
		}

		public String getOrderLongitude() {
			return orderLongitude;
		}

		public void setOrderLongitude(String orderLongitude) {
			this.orderLongitude = orderLongitude;
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

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

}
