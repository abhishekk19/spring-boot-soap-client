package com.example.genericrestapi.request;

public class LabsInfoRequest {

	private String method;
	private String type;
	private String application;
	private Data request;

	public class Data {
		private Double latitude;
		private Double longitude;
		private String service_item_code;
		private String tenantCode;
		private String organizationCode;

		public Double getLatitude() {
			return latitude;
		}

		public void setLatitude(Double latitude) {
			this.latitude = latitude;
		}

		public Double getLongitude() {
			return longitude;
		}

		public void setLongitude(Double longitude) {
			this.longitude = longitude;
		}

		public String getService_item_code() {
			return service_item_code;
		}

		public void setService_item_code(String service_item_code) {
			this.service_item_code = service_item_code;
		}

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
